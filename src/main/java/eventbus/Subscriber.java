package eventbus;

import io.vertx.core.eventbus.Message;
import ultilities.operation.Operation;
import ultilities.validation.Validation;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.json.JsonObject;

public class Subscriber extends AbstractVerticle {
    @Override
    public void start() throws Exception {

        //register a consumer
        vertx.eventBus().consumer("eventbusTest.addr", this::messageHandling);
    }

    public void messageHandling(Message msg) {
        Validation valid = new Validation();
        Operation ope = new Operation();
        try {
            JsonObject param = (JsonObject) msg.body();
            int a = param.getInteger("a");
            int b = param.getInteger("b");
            String op = param.getString("ope");
            if (valid.validateOpe(b, op) == 1) {
                int result = ope.operation(a, b, op);
                JsonObject re = new JsonObject();
                re.put("result", result);
                msg.reply(re.encodePrettily());
            }
            if (valid.validateOpe(b, op) == 0) {
                msg.reply("You can't put 0 under the denominator");
            } else {
                msg.reply("Please enter the right operation (+, -, x, :)");
            }
        } catch (Exception ex){
            msg.reply("Internal error");
        }
    }
}
