package app.actions;

import com.google.gson.Gson;
import app.models.User;
import org.springframework.stereotype.Component;
import spark.Request;
import spark.Response;
import spark.Route

@Component
public class CreateUser implements Route {

    @Override
    public Object handle(Request request, Response response) {
        User user = new Gson().fromJson(request.body(), User)
        return user
    }
}
