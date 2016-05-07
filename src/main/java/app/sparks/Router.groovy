package app.sparks

import app.actions.CreateUser
import app.actions.GetUser
import app.actions.ThrowException
import app.main.Spark;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import spark.Route
import app.transformers.JsonTransformer;

import static spark.Spark.*

@Component
class Router implements Spark {

    @Autowired
    private ApplicationContext applicationContext
    @Autowired
    private JsonTransformer jsonTransformer

    @Override
    public void register() {
        post "/user", getRoute(CreateUser), jsonTransformer
        get "/user/:id", getRoute(GetUser), jsonTransformer
        get '/exception', getRoute(ThrowException)
    }

    private Route getRoute(Class<Route> clazz) {
        return applicationContext.getBean(clazz)
    }
}
