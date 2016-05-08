package app.api.middleware

import app.api.spark.SparkComponent
import app.utils.JsonMarshaller
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import static spark.Spark.exception

@Component
class ExceptionHandler implements SparkComponent {

    @Autowired
    JsonMarshaller marshaller

    @Override
    void start() {
        registerException(RuntimeException, 500)
    }

    def registerException(Class clazz, int statusCode) {
        exception(clazz, {e, request, response ->
            response.status(statusCode)
            response.body(marshaller.toJson(new ExceptionView(e)))
        });
    }
}

class ExceptionView {
    String type
    String message

    ExceptionView(Exception e) {
        this.type = e.class.simpleName
        this.message = e.message
    }
}
