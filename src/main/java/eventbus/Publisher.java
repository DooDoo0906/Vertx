package eventbus;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.json.JsonObject;

public class Publisher extends AbstractVerticle {
    public void start(){

        JsonObject param= new JsonObject();
        param.put("a",1).put("b",0).put("ope","'");

        vertx.eventBus().request("eventbusTest.addr","",reply->{
                System.out.println(reply.result().body());
        });

    }
}
