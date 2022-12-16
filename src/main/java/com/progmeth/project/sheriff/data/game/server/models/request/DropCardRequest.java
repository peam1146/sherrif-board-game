package com.progmeth.project.sheriff.data.game.server.models.request;

/**
 * Drop card request
 */
public class DropCardRequest extends Request {
    /**
     * card name payload
     */
    public String cardName;
    /**
     * player id payload
     */
    public int playerID;

    /**
     * topic
     */
    final public static String requestTopic = "dropCard";

    /**
     * Constructor
     */
    public DropCardRequest() {
        super(requestTopic);
    }


    /**
     * Class Builder
     */
    public static class Builder {
        /**
         * card name
         */
        private String cardName;

        /**
         * player id
         */
        private int playerID;

        /**
         * set card name
         *
         * @param cardName card name
         * @return builder
         */
        public Builder setCardName(String cardName) {
            this.cardName = cardName;
            return this;
        }

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
         * @return DropCardRequest
         */
        public DropCardRequest build() {
            DropCardRequest req = new DropCardRequest();
            req.cardName = cardName;
            req.playerID = playerID;
            return req;
        }
    }
}
