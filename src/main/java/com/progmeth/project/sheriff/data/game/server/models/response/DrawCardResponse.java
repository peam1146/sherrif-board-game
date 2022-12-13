package com.progmeth.project.sheriff.data.game.server.models.response;

import com.progmeth.project.sheriff.data.game.server.models.DTO.ItemDTO;

import java.util.ArrayList;

public class DrawCardResponse extends Response {
    public static final String responseTopic = "drawCard";
    public ArrayList<ItemDTO> hand;

    public DrawCardResponse() {
        super(responseTopic);
    }

    public static class Builder {
        private ArrayList<ItemDTO> hand;

        public Builder setHand(ArrayList<ItemDTO> hand) {
            this.hand = hand;
            return this;
        }

        public DrawCardResponse build() {
            DrawCardResponse res = new DrawCardResponse();
            res.hand = hand;
            return res;
        }
    }
}
