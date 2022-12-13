package com.progmeth.project.sheriff.data.game.server.models.request;

public class DrawCardRequeust extends Request {
    public final static String requestTopic = "drawCard";
    public int playerID;

    public DrawCardRequeust() {
        super(requestTopic);
    }

    public static class Builder {
        private int playerID;

        public Builder setPlayerID(int playerID) {
            this.playerID = playerID;
            return this;
        }

        public DrawCardRequeust build() {
            DrawCardRequeust req = new DrawCardRequeust();
            req.playerID = playerID;
            return req;
        }
    }
}
