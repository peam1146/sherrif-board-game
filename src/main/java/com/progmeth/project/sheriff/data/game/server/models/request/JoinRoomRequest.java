package com.progmeth.project.sheriff.data.game.server.models.request;

public class JoinRoomRequest extends Request {
    public String room;
    public final static String requestTopic = "joinRoom";

    public JoinRoomRequest() {
        super(requestTopic);
    }

    public JoinRoomRequest(Builder builder) {
        super(requestTopic);
        this.room = builder.room;
    }

    public static class Builder {
        private String room;

        public Builder setRoom(String room) {
            this.room = room;
            return this;
        }

        public JoinRoomRequest build() {
            JoinRoomRequest req = new JoinRoomRequest();
            req.room = room;
            return req;
        }
    }
}
