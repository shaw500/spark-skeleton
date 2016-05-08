package app.api.spark

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
public class SparkRunner {

    private List<SparkComponent> sparks;

    @Autowired
    SparkRunner(List<SparkComponent> sparks) {
        this.sparks = sparks
    }

    void run() {
        sparks.each { spark -> spark.start() }
    }

}
