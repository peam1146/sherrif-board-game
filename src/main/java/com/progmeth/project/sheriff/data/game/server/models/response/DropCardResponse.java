package com.progmeth.project.sheriff.data.game.server.models.response;

import com.progmeth.project.sheriff.data.game.server.models.DTO.ItemDTO;

import java.util.ArrayList;

public class DropCardResponse extends Response {
    public final static String responseTopic = "dropCard";
    public ArrayList<ItemDTO> hand;

    public DropCardResponse() {
        super(responseTopic);
    }

    public static class Builder {
        private ArrayList<ItemDTO> hand;

        public Builder setHand(ArrayList<ItemDTO> hand) {
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
