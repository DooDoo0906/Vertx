package client_server;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.client.WebClient;

public class RequestSending extends AbstractVerticle {
    public void start () throws Exception{
        //create client source
        WebClient client = WebClient.create(vertx);
        client
                .post(1111, "localhost", "/postOperation")
                .sendJsonObject(
                        new JsonObject()
                                .put("a", 0)
                                .put("b", 1)
                                .put("ope", ":"))
        ;
    }
}
