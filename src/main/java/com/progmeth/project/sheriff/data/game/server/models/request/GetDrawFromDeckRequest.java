package com.progmeth.project.sheriff.data.game.server.models.request;

public class GetDrawFromDeckRequest extends Request {
    public int playerID;
    public static final String requestTopic = "getDrawFromDeck";

    public GetDrawFromDeckRequest() {
        super(requestTopic);
    }

    public static class Builder {
        private int playerID;

        public Builder setPlayerID(int playerID) {
            this.playerID = playerID;
            return this;
        }

        public GetDrawFromDeckRequest build() {
            GetDrawFromDeckRequest req = new GetDrawFromDeckRequest();
            req.playerID = playerID;
            return req;
        }
    }
}
