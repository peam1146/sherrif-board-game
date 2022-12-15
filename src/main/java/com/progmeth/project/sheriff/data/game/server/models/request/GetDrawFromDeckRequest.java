package com.progmeth.project.sheriff.data.game.server.models.request;

/**
 * Get draw from deck request
 */
public class GetDrawFromDeckRequest extends Request {
    /**
     * player id payload
     */
    public int playerID;


    /**
     * topic
     */
    public static final String requestTopic = "getDrawFromDeck";

    /**
     * Constructor
     */
    public GetDrawFromDeckRequest() {
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
         * build
         *
         * @return GetDrawFromDeckRequest
         */
        public GetDrawFromDeckRequest build() {
            GetDrawFromDeckRequest req = new GetDrawFromDeckRequest();
            req.playerID = playerID;
            return req;
        }
    }
}
