package com.progmeth.project.sheriff.data.game.server.models.request;

/**
 * get hand request
 */
public class GetHandRequest extends Request {

    /**
     * player id payload
     */
    public int playerID;
    /**
     * topic
     */
    public final static String requestTopic = "getHand";

    /**
     * Constructor
     */
    public GetHandRequest() {
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
         * @return GetHandRequest
         */
        public GetHandRequest build() {
            GetHandRequest req = new GetHandRequest();
            req.playerID = playerID;
            return req;
        }
    }
}
