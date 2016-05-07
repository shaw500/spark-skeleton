package app.main

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class App {

    Logger logger = LoggerFactory.getLogger(App)

    def run(){
        ApplicationContext ctx = new AnnotationConfigApplicationContext()
        ctx.scan('app')
        ctx.refresh()

        def sparkConfig = ctx.getBean(SparkConfiguration)
        sparkConfig.sparkRunner()

        logger.info("Server started")
    }

    public static void main(String[] args) {
        new App().run()
    }
}
