package com.progmeth.project.sheriff.data.game.server.models.request;

public class GetIsGameStartedRequest extends Request {
    public static final String requestTopic = "isGameStarted";

    public GetIsGameStartedRequest() {
        super(requestTopic);
    }
}
