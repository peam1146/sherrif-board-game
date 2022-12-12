package com.progmeth.project.sheriff.data.game.server.models.response;

import com.progmeth.project.sheriff.domain.game.entity.ItemEntity;

public class GetHandResponse extends Response {
    public static String responseTopic = "getHand";
    public ItemEntity[] hand;
    public GetHandResponse () {
        super(responseTopic);
    }

    public static class Builder {
        private ItemEntity[] hand;

        public Builder setHand(ItemEntity[] hand) {
            this.hand = hand;
            return this;
        }

        public GetHandResponse build() {
            GetHandResponse res = new GetHandResponse();
            res.hand = hand;
            return res;
        }
    }
}
