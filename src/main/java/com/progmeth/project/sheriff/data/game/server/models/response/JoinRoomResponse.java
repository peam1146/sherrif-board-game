package com.progmeth.project.sheriff.data.game.server.models.response;

public class JoinRoomResponse extends Response {
    public static String responseTopic = "joinRoom";
    public String room;
    private int playerID;
    public JoinRoomResponse() {
        super(responseTopic);
    }

    public static class Builder {
        private String room;
        private int playerID;

        public Builder setRoom(String room) {
            this.room = room;
            return this;
        }

        public Builder setPlayerID(int playerID) {
            this.playerID = playerID;
            return this;
        }

        public JoinRoomResponse build() {
            JoinRoomResponse res = new JoinRoomResponse();
            res.room = room;
            res.playerID = playerID;
            return res;
        }
    }
}
