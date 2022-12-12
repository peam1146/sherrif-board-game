package com.progmeth.project.sheriff.data.game.server.models.response;

import com.progmeth.project.sheriff.data.game.server.models.DTO.ItemDTO;

public class GetDrawFromDeckResponse extends Response {
    public static final String responseTopic = "getDrawFromDeck";

    public ItemDTO[] hand;

    public GetDrawFromDeckResponse() {
        super(responseTopic);
    }

    public static class Builder {
        private ItemDTO[] hand;

        public Builder setHand(ItemDTO[] hand) {
            this.hand = hand;
            return this;
        }

        public GetDrawFromDeckResponse build() {
            GetDrawFromDeckResponse res = new GetDrawFromDeckResponse();
            res.hand = hand;
            return res;
        }
    }
}
