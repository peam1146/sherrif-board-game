package com.progmeth.project.sheriff.data.game.server.models.request;

public class GetCurrentSheriffRequest extends Request {
    public static final String requestTopic = "currentSheriff";

    public GetCurrentSheriffRequest() {
        super(requestTopic);
    }
}
