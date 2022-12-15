package com.progmeth.project.sheriff.data.game.server.models.request;

/**
 * Draw card request
 */
public class DrawCardRequeust extends Request {

    /**
     * topic
     */
    public final static String requestTopic = "drawCard";

    /**
     * player id payload
     */
    public int playerID;

    /**
     * Constructor
     */
    public DrawCardRequeust() {
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
         * @return DrawCardRequeust
         */
        public DrawCardRequeust build() {
            DrawCardRequeust req = new DrawCardRequeust();
            req.playerID = playerID;
            return req;
        }
    }
}
