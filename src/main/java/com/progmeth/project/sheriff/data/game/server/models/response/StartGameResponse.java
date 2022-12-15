package com.progmeth.project.sheriff.data.game.server.models.response;

/**
 * Start game response
 */
public class StartGameResponse extends Response {
    /**
     * is game started
     */
    public boolean success;
    /**
     * topic
     */
    public static final String responseTopic = "startGame";

    /**
     * Constructor
     */
    public StartGameResponse() {
        super(responseTopic);
    }

    /**
     * Class Builder
     */
    public static class Builder {
        /**
         * is game started
         */
        private boolean success;

        /**
         * Constructor
         */
        public Builder() {
        }

        /**
         * set success
         *
         * @return builder
         */
        public Builder setSuccess() {
            this.success = true;
            return this;
        }

        /**
         * build
         *
         * @return StartGameResponse
         */
        public StartGameResponse build() {
            final StartGameResponse res = new StartGameResponse();
            res.success = success;
            return res;
        }
    }
}
