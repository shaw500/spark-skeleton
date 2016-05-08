package app.api.spark

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class Server {

    Logger logger = LoggerFactory.getLogger(Server)

    def Server start(){
        ApplicationContext ctx = new AnnotationConfigApplicationContext()
        ctx.scan('app')
        ctx.refresh()

        def sparkRunner = ctx.getBean(SparkRunner)
        sparkRunner.run()

        logger.info("Server started")
        this
    }

    def stop() {
        spark.Spark.stop()
    }

    public static void main(String[] args) {
        new Server().start()
    }
}
