package com.progmeth.project.sheriff.data.game.server.models.request;

public class DrawCardRequeust extends Request {
    public final static String requestTopic = "drawCard";
    public int playerID;
    public int amount;

    public DrawCardRequeust() {
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

        public DrawCardRequeust build() {
            DrawCardRequeust req = new DrawCardRequeust();
            req.playerID = playerID;
            req.amount = amount;
            return req;
        }
    }
}
