package com.progmeth.project.sheriff.data.game.server.models.response;

import java.util.ArrayList;

/**
 * Join room response
 */
public class JoinRoomResponse extends Response {
    /**
     * topic
     */
    public static String responseTopic = "joinRoom";
    /**
     * player id payload
     */
    public int playerID;
    /**
     * player name payload
     */
    public String playerName;
    /**
     * current player list payload
     */
    public ArrayList<String> playerNames;

    /**
     * Constructor
     */
    public JoinRoomResponse() {
        super(responseTopic);
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
         * player name
         */
        private String playerName;
        /**
         * current player list
         */
        private ArrayList<String> playerNames;

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
         * set player name
         *
         * @param playerNames player name list
         * @return builder
         */
        public Builder setPlayerNames(ArrayList<String> playerNames) {
            this.playerNames = playerNames;
            return this;
        }

        /**
         * set player name
         *
         * @param playerName player name
         * @return builder
         */
        public Builder setPlayerName(String playerName) {
            this.playerName = playerName;
            return this;
        }

        /**
         * build response
         *
         * @return response
         */
        public JoinRoomResponse build() {
            JoinRoomResponse res = new JoinRoomResponse();
            res.playerID = playerID;
            res.playerName = playerName;
            res.playerNames = playerNames;
            return res;
        }
    }
}
