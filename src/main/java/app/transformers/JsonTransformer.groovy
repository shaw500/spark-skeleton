package app.transformers

import com.google.gson.Gson
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component
import spark.ResponseTransformer

@Component
@Scope("singleton")
class JsonTransformer implements ResponseTransformer {

    Gson gson = new Gson()

    @Override
    String render(Object model) throws Exception {
        return gson.toJson(model)
    }
}
