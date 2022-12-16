package com.progmeth.project.sheriff.data.game.server.models.request;

public class GetDroppedDeckTopRequest extends Request {
    public static final String requestTopic = "droppedDeckTop";

    public GetDroppedDeckTopRequest() {
        super(requestTopic);
    }
}
