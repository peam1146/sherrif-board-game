package com.progmeth.project.sheriff.data.game.server.models.request;

public class DropAllCardsRequest extends Request{
    public static final String requestTopic = "dropAllCards";
    public int playerID;

    public DropAllCardsRequest() {
        super(requestTopic);
    }

    public static class Builder {
        private int playerID;

        public Builder setPlayerID(int playerID) {
            this.playerID = playerID;
            return this;
        }

        public DropAllCardsRequest build() {
            DropAllCardsRequest req = new DropAllCardsRequest();
            req.playerID = playerID;
            return req;
        }

    }
}
