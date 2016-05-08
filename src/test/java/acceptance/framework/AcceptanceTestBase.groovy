package acceptance.framework

import app.api.spark.Server
import spock.lang.Shared
import spock.lang.Specification

class AcceptanceTestBase extends Specification {

    HttpClient client = new HttpClient();
    @Shared Server app = new Server()

    def setupSpec() {
        app.start()
    }
    def cleanupSpec() {
        app.stop()
    }

    def <T> T get(String uri) {
        client.get(uri)
    }

    def <T> T post(String uri, Object payload) {
        client.post(uri, payload)
    }
}
