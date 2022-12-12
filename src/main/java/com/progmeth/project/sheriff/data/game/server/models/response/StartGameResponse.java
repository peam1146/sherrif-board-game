package com.progmeth.project.sheriff.data.game.server.models.response;

public class StartGameResponse extends Response{
    public boolean success;
    public static final String responseTopic = "startGame";
    public StartGameResponse() {
        super(responseTopic);
    }

    public static class Builder {
        private boolean success;
        public Builder setSuccess() {
            this.success = true;
            return this;
        }

        public StartGameResponse build() {
            final StartGameResponse res = new StartGameResponse();
            res.success = success;
            return res;
        }
    }
}
