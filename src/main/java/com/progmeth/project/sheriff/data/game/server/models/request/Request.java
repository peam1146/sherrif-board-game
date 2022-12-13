package com.progmeth.project.sheriff.data.game.server.models.request;

import com.progmeth.project.sheriff.data.game.server.models.type.Type;

public abstract class Request {
    public final String topic;
    public final Type type = Type.REQUEST;

    public Request(String topic) {
        this.topic = topic;
    }

    public String getTopic() {
        return topic;
    }
}
