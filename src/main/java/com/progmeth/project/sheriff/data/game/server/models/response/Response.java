package com.progmeth.project.sheriff.data.game.server.models.response;

import com.progmeth.project.sheriff.data.game.server.models.type.Type;
public abstract class Response {
    public final String topic;
    public final Type type = Type.RESPONSE;

    public Response(String topic) {
        this.topic = topic;
    }

    public String getTopic() {
        return topic;
    }
}
