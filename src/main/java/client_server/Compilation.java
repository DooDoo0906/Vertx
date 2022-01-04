package client_server;

import io.vertx.core.Vertx;

public class Compilation {
    public static void main(String[] args) {
        Vertx vertx=Vertx.vertx();
        //deploy client-server
        vertx.deployVerticle(new RequestSending());
        vertx.deployVerticle(new RequestHandler());
    }
}
