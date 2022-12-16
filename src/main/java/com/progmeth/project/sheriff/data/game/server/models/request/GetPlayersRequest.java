package com.progmeth.project.sheriff.data.game.server.models.request;

/**
 * get players request
 */
public class GetPlayersRequest extends Request {
    /**
     * topic
     */
    public static final String requestTopic = "getPlayers";

    /**
     * Constructor
     */
    public GetPlayersRequest() {
        super(requestTopic);
    }
}
