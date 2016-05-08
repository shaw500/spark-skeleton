package app.utils

import com.google.gson.Gson
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component
import spark.ResponseTransformer

@Component
@Scope('singleton')
class JsonMarshaller implements ResponseTransformer {

    Gson gson = new Gson()

    public String toJson(Object model) {
        gson.toJson(model)
    }

     public <T> T toType(String json) {
        gson.fromJson(json, T)
    }

    @Override
    String render(Object model) throws Exception {
        toJson(model)
    }
}
