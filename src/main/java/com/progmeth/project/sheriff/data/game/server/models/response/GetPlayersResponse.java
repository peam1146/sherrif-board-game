package com.progmeth.project.sheriff.data.game.server.models.response;

import java.util.ArrayList;

public class GetPlayersResponse extends Response{
    public static final String responseTopic = "getPlayers";
    public ArrayList<String> players;
    public GetPlayersResponse() {
        super(responseTopic);
    }

    public static class Builder {
        private ArrayList<String> players;

        public Builder players(ArrayList<String> players) {
            this.players = players;
            return this;
        }

        public GetPlayersResponse build() {
            GetPlayersResponse response = new GetPlayersResponse();
            response.players = this.players;
            return response;
        }
    }
}
