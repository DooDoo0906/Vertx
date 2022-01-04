package client_server;

import ultilities.operation.Operation;
import ultilities.validation.Validation;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.*;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;

public class RequestHandler extends AbstractVerticle {

    @Override
    public void start() throws Exception {
        //deploy eventbus verticle

        HttpServer server = vertx.createHttpServer();
        Router router = Router.router(vertx);
        //handler the requests
        router.post("/postOperation").handler(BodyHandler.create()).handler(this::handlingRequest);
        server.requestHandler(router).listen(1111, "localhost");
    }

    private void handlingRequest(RoutingContext context) {
        HttpServerResponse response = context.response();
        Validation valid = new Validation();
        Operation ope= new Operation();
        try{
        JsonObject param = context.getBodyAsJson();
        int a = param.getInteger("a");
        int b = param.getInteger("b");
        String op = param.getString("ope");
        if(valid.validateOpe(b, op)==1) {
            int result = ope.operation(a,b,op);
            JsonObject re = new JsonObject();
            re.put("result", result);
            response.end(re.encodePrettily());
            System.out.println(re.encodePrettily());

        }
        else if(valid.validateOpe(b,op)==0){
            System.out.println("You can't put 0 under the denominator");
        }
        else if(valid.validateOpe(b,op)==-1){
            response.end("Please enter the right operation (+, -, x, :)");
            System.out.println("Please enter the right operation (+, -, x, :)");

        }}
        catch (Exception ex){
            System.out.println("Internal error");
        }


        }
    }




