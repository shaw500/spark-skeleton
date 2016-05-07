package app.main

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
public class SparkConfiguration {

    private List<Spark> sparks;

    @Autowired
    SparkConfiguration(List<Spark> sparks) {
        this.sparks = sparks
    }

    void sparkRunner() {
        sparks.each {spark -> spark.register()}
    }
}
