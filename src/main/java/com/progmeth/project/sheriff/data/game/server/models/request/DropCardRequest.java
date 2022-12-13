package com.progmeth.project.sheriff.data.game.server.models.request;

public class DropCardRequest extends Request{
    public String cardName;
    public int playerID;
    final public static String requestTopic = "dropCard";

    public DropCardRequest() {
        super(requestTopic);
    }

    public static class Builder {
        private String cardName;
        private int playerID;
        public Builder setCardName(String cardName) {
            this.cardName = cardName;
            return this;
        }

        public Builder setPlayerID(int playerID) {
            this.playerID = playerID;
            return this;
        }

        public DropCardRequest build() {
            DropCardRequest req = new DropCardRequest();
            req.cardName = cardName;
            req.playerID = playerID;
            return req;
        }
    }
}
