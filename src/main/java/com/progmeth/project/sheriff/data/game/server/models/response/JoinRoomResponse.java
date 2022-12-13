package com.progmeth.project.sheriff.data.game.server.models.response;

public class JoinRoomResponse extends Response {
    public static String responseTopic = "joinRoom";
    public int playerID;
    public String playerName;
    public JoinRoomResponse() {
        super(responseTopic);
    }

    public static class Builder {
        private int playerID;
        private String playerName;

        public Builder setPlayerID(int playerID) {
            this.playerID = playerID;
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
            return res;
        }
    }
}
