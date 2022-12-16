package com.progmeth.project.sheriff.data.game.server.models.request;

public class DrawCardRequest extends Request {
    public final static String requestTopic = "drawCard";
    public int playerID;
    public int amount;

    public DrawCardRequest() {
        super(requestTopic);
    }

    public static class Builder {
        private int playerID;
        private int amount;

        public Builder setPlayerID(int playerID) {
            this.playerID = playerID;
            return this;
        }

        public Builder setAmount(int n) {
            this.amount = n;
            return this;
        }

        public DrawCardRequest build() {
            DrawCardRequest req = new DrawCardRequest();
            req.playerID = playerID;
            req.amount = amount;
            return req;
        }
    }
}
