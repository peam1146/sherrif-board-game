package com.progmeth.project.sheriff.data.game.server.models.request;

/**
 * Join room request
 */
public class JoinRoomRequest extends Request {
    /**
     * player name
     */
    public String playerName;
    /**
     * topic
     */
    public final static String requestTopic = "joinRoom";

    /**
     * Constructor
     */
    public JoinRoomRequest() {
        super(requestTopic);
    }

    /**
     * Class Builder
     */
    public static class Builder {
        /**
         * player name
         */
        private String playerName;

        /**
         * Constructor
         */
        public Builder() {
        }

        /**
         * set room name
         *
         * @param playerName player name
         * @return builder
         */
        public Builder setPlayerName(String playerName) {
            this.playerName = playerName;
            return this;
        }

        /**
         * build request
         *
         * @return request
         */
        public JoinRoomRequest build() {
            JoinRoomRequest req = new JoinRoomRequest();
            req.playerName = playerName;
            return req;
        }
    }
}
