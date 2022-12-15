package com.progmeth.project.sheriff.data.game.server.models.request;

/**
 * Drop all cards request
 */
public class DropAllCardsRequest extends Request{

    /**
     * topic
     */
    public static final String requestTopic = "dropAllCards";

    /**
     * player id payload
     */
    public int playerID;


    /**
     * Constructor
     */
    public DropAllCardsRequest() {
        super(requestTopic);
    }


    /**
     * Class Builder
     */
    public static class Builder {
        /**
         * player id
         */
        private int playerID;

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
        public Builder setPlayerID(int playerID) {
            this.playerID = playerID;
            return this;
        }

        /**
         * Build request
         *
         * @return DropAllCardsRequest
         */
        public DropAllCardsRequest build() {
            DropAllCardsRequest req = new DropAllCardsRequest();
            req.playerID = playerID;
            return req;
        }

    }
}
