package com.progmeth.project.sheriff.data.game.server.models.response;

import com.progmeth.project.sheriff.data.game.server.models.DTO.ItemDTO;

public class DropCardResponse extends Response {
    public final static String responseTopic = "dropCard";
    public ItemDTO[] hand;

    public DropCardResponse() {
        super(responseTopic);
    }

    public static class Builder {
        private ItemDTO[] hand;

        public Builder setHand(ItemDTO[] hand) {
            this.hand = hand;
            return this;
        }

        public DropCardResponse build() {
            DropCardResponse res = new DropCardResponse();
            res.hand = hand;
            return res;
        }
    }
}
