package com.progmeth.project.sheriff.data.game.server.models.response;

import java.util.ArrayList;

/**
 * get players response
 */
public class GetPlayersResponse extends Response {
    /**
     * topic
     */
    public static final String responseTopic = "getPlayers";

    /**
     * players payload
     */
    public ArrayList<String> players;

    /**
     * Constructor
     */
    public GetPlayersResponse() {
        super(responseTopic);
    }

    /**
     * Class Builder
     */
    public static class Builder {
        /**
         * players
         */
        private ArrayList<String> players;

        /**
         * Constructor
         */
        public Builder() {
        }

        /**
         * set players
         *
         * @param players players
         * @return builder
         */
        public Builder players(ArrayList<String> players) {
            this.players = players;
            return this;
        }

        /**
         * Build response
         *
         * @return GetPlayersResponse
         */
        public GetPlayersResponse build() {
            GetPlayersResponse response = new GetPlayersResponse();
            response.players = this.players;
            return response;
        }
    }
}
