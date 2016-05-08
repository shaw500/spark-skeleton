package acceptance.framework

import app.utils.JsonMarshaller
import org.apache.http.client.methods.CloseableHttpResponse
import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.CloseableHttpClient
import org.apache.http.impl.client.HttpClients

class HttpClient {
    CloseableHttpClient client = HttpClients.createDefault()
    JsonMarshaller marshaller = new JsonMarshaller()

    def <T> T get(String uri) {
        def response = client.execute(new HttpGet("http://localhost:4567/$uri"))
        getResponse(response)
    }

    def <T> T getResponse(CloseableHttpResponse response) {
        marshaller.toType(response.entity.content.text)
    }
}
