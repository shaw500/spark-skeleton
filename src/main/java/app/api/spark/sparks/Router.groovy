package app.api.spark.sparks

import app.api.actions.CreateUser
import app.api.actions.GetUser
import app.api.actions.ThrowException
import app.api.spark.SparkComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import spark.Route
import app.api.spark.transformers.JsonTransformer;

import static spark.Spark.*

@Component
class Router implements SparkComponent {

    @Autowired
    private ApplicationContext applicationContext
    @Autowired
    private JsonTransformer jsonTransformer

    @Override
    public void start() {
        post "/user", getRoute(CreateUser), jsonTransformer
        get "/user/:id", getRoute(GetUser), jsonTransformer
        get '/exception', getRoute(ThrowException)
    }

    private Route getRoute(Class<Route> clazz) {
        return applicationContext.getBean(clazz)
    }
}
