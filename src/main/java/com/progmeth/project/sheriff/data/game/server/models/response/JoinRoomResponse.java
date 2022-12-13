package com.progmeth.project.sheriff.data.game.server.models.response;

import java.util.ArrayList;

public class JoinRoomResponse extends Response {
    public static String responseTopic = "joinRoom";
    public int playerID;
    public String playerName;
    public ArrayList<String> playerNames;
    public JoinRoomResponse() {
        super(responseTopic);
    }

    public static class Builder {
        private int playerID;
        private String playerName;
        private ArrayList<String> playerNames;

        public Builder setPlayerID(int playerID) {
            this.playerID = playerID;
            return this;
        }

        public Builder setPlayerNames(ArrayList<String> playerNames) {
            this.playerNames = playerNames;
            return this;
        }

        public Builder setPlayerName(String playerName) {
            this.playerName = playerName;
            return this;
        }

        public JoinRoomResponse build() {
            JoinRoomResponse res = new JoinRoomResponse();
            res.playerID = playerID;
            res.playerName = playerName;
            res.playerNames = playerNames;
            return res;
        }
    }
}
