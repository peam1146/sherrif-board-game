package com.progmeth.project.sheriff.data.game.server.models.response;

import com.progmeth.project.sheriff.data.game.server.models.DTO.ItemDTO;

import java.util.ArrayList;

public class GetHandResponse extends Response {
    public static String responseTopic = "getHand";
    public ArrayList<ItemDTO> hand;
    public GetHandResponse () {
        super(responseTopic);
    }

    public static class Builder {
        private ArrayList<ItemDTO> hand;

        public Builder setHand(ArrayList<ItemDTO> hand) {
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
