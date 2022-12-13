package com.progmeth.project.sheriff.data.game.server.models.request;

public class GetHandRequest extends Request{
    public int playerID;
    public final static String requestTopic = "getHand";
    public GetHandRequest() {
        super(requestTopic);
    }

    public static class Builder {
        private int playerID;
        public Builder setPlayerID(int playerID) {
            this.playerID = playerID;
            return this;
        }

        public GetHandRequest build() {
            GetHandRequest req = new GetHandRequest();
            req.playerID = playerID;
            return req;
        }
    }
}
