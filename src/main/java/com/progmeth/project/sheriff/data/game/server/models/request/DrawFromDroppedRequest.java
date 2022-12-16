package com.progmeth.project.sheriff.data.game.server.models.request;

import com.progmeth.project.sheriff.data.game.server.controller.DroppedDeckPos;

public class DrawFromDroppedRequest extends Request {
    public static final String requestTopic = "drawFromDropped";
    public int playerID;
    public DroppedDeckPos pos;
    public DrawFromDroppedRequest() {
        super(requestTopic);
    }

    public static class Builder {
        /**
         * player id
         */
        private int playerID;

        private DroppedDeckPos pos;

        /**
         * Constructor
         */
        public Builder() {

        }

        /**
         * set player id
         *
         * @param playerID player id
         * @return builder
         */
        public DrawFromDroppedRequest.Builder setPlayerID(int playerID) {
            this.playerID = playerID;
            return this;
        }

        public DrawFromDroppedRequest.Builder setDrawPos(DroppedDeckPos pos) {
            this.pos = pos;
            return this;
        }

        /**
         * Build request
         *
         * @return DropAllCardsRequest
         */
        public DrawFromDroppedRequest build() {
            DrawFromDroppedRequest req = new DrawFromDroppedRequest();
            req.playerID = playerID;
            req.pos = pos;
            return req;
        }

    }
}
