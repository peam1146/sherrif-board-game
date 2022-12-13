package com.progmeth.project.sheriff.data.game.server.models.request;

public class GetPlayersRequest extends Request {
    public static final String requestTopic = "getPlayers";

    public GetPlayersRequest() {
        super(requestTopic);
    }
}
