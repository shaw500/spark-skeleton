package app.sparks

import app.main.Spark

import static spark.Spark.exception

class ExceptionHandler implements Spark {

    @Override
    void register() {
        registerException(RuntimeException, 500, 'Internal server error')
    }

    static def registerException(Class clazz, int statusCode, String message) {
        exception(clazz, {e, request, response ->
            response.status(statusCode);
            response.body(message)
        });
    }
}
