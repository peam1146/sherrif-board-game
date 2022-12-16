package com.progmeth.project.sheriff.data.game.server.models.request;

import com.progmeth.project.sheriff.data.game.server.models.type.Type;

/**
 * Request
 */
public abstract class Request {
    /**
     * Request topic
     */
    public final String topic;
    /**
     * type
     */
    public final Type type = Type.REQUEST;

    /**
     * Constructor
     * @param topic topic
     */
    public Request(String topic) {
        this.topic = topic;
    }

    /**
     * Get topic
     * @return topic
     */
    public String getTopic() {
        return topic;
    }
}
