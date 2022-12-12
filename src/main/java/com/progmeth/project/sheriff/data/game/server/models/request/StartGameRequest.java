package com.progmeth.project.sheriff.data.game.server.models.request;

public class StartGameRequest extends Request {
    public static final String requestTopic = "startGame";

    public StartGameRequest() {
        super(requestTopic);
    }
}
