package com.progmeth.project.sheriff.data.game.server.models.response;

public class GetIsGameStartedResponse extends Response{
    public static final String responseTopic = "isGameStarted";
    public Boolean isGameStarted;
    public GetIsGameStartedResponse() {
        super(responseTopic);
    }

    public static class Builder {
        private Boolean isGameStarted;

        public Builder isGameStarted(Boolean isGameStarted) {
            this.isGameStarted = isGameStarted;
            return this;
        }

        public GetIsGameStartedResponse build() {
            GetIsGameStartedResponse response = new GetIsGameStartedResponse();
            response.isGameStarted = isGameStarted;
            return response;
        }
    }
}
