package com.progmeth.project.sheriff.data.game.server.models.request;

/**
 * Start game request
 */
public class StartGameRequest extends Request {
    /**
     * topic
     */
    public static final String requestTopic = "startGame";

    /**
     * Constructor
     */
    public StartGameRequest() {
        super(requestTopic);
    }
}
