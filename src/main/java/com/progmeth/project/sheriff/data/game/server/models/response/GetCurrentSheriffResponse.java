package com.progmeth.project.sheriff.data.game.server.models.response;

public class GetCurrentSheriffResponse extends Response{
    public static final String responseTopic = "currentSheriff";
    public int currentSheriff;
    public GetCurrentSheriffResponse() {
        super(responseTopic);
    }

    public static class Builder {
        private int currentSheriff;

        public Builder setCurrentSheriff(int currentSheriff) {
            this.currentSheriff = currentSheriff;
            return this;
        }

        public GetCurrentSheriffResponse build() {
            GetCurrentSheriffResponse response = new GetCurrentSheriffResponse();
            response.currentSheriff = currentSheriff;
            return response;
        }
    }
}
