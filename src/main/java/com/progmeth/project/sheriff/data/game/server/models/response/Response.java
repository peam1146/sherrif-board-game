package com.progmeth.project.sheriff.data.game.server.models.response;

import com.progmeth.project.sheriff.data.game.server.models.type.Type;

/**
 * Response
 */
public abstract class Response {
    /**
     * Response topic
     */
    public final String topic;
    /**
     * type
     */
    public final Type type = Type.RESPONSE;

    /**
     * Constructor
     * @param topic topic
     */
    public Response(String topic) {
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
