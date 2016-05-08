package app.api.actions;

import app.core.models.User;
import org.springframework.stereotype.Component;
import spark.Request;
import spark.Response;
import spark.Route

@Component
public class GetUser implements Route {

    @Override
    public Object handle(Request request, Response response) {
        return new User(UUID.randomUUID().toString(), 'Matthew Shaw', 'shaw500@gmail.com', 'mjshaw')
    }
}
