package org.usergrid.vx.server.operations;

import org.vertx.java.core.Handler;
import org.vertx.java.core.eventbus.Message;
import org.vertx.java.core.json.JsonObject;

public class SetKeyspaceHandler implements Handler<Message<JsonObject>> {

    @Override
    public void handle(Message<JsonObject> event) {
        Integer id = event.body.getInteger("id");
        JsonObject params = event.body.getObject("op");
        JsonObject state = event.body.getObject("state");
        state.putString("currentKeyspace", params.getString("keyspace"));

        event.reply(new JsonObject()
            .putString(id.toString(), "OK")
            .putObject("state", state)
        );
    }

}