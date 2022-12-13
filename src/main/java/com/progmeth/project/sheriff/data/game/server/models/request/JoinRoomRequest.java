package com.progmeth.project.sheriff.data.game.server.models.request;

public class JoinRoomRequest extends Request {
    public String playerName;
    public final static String requestTopic = "joinRoom";

    public JoinRoomRequest() {
        super(requestTopic);
    }

    public JoinRoomRequest(Builder builder) {
        super(requestTopic);
        this.playerName = builder.playerName;
    }

    public static class Builder {
        private String playerName;

        public Builder setRoom(String playerName) {
            this.playerName = playerName;
            return this;
        }

        public JoinRoomRequest build() {
            JoinRoomRequest req = new JoinRoomRequest();
            req.playerName = playerName;
            return req;
        }
    }
}
