package eventbus;

import io.vertx.core.Vertx;

public class Compilation {
    public static void main(String[] args) {
        Vertx vertx=Vertx.vertx();
        //deploy Eventbus
        vertx.deployVerticle(new Publisher());
        vertx.deployVerticle(new Subscriber());
    }
}
