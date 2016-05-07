package app.actions

import org.springframework.stereotype.Component
import spark.Request
import spark.Response
import spark.Route

@Component
class ThrowException implements Route {

    @Override
    Object handle(Request request, Response response) throws Exception {
        throw new RuntimeException('moo moo')
    }
}
