package com.progmeth.project.sheriff.data.game.server.models.response;

import com.progmeth.project.sheriff.data.game.server.models.DTO.ItemDTO;

import java.util.ArrayList;

/**
 * Drop card response
 */
public class DropCardResponse extends Response {

    /**
     * topic
     */
    public final static String responseTopic = "dropCard";

    /**
     * hand payload
     */
    public ArrayList<ItemDTO> hand;

    /**
     * Constructor
     */
    public DropCardResponse() {
        super(responseTopic);
    }

    /**
     * Class Builder
     */
    public static class Builder {
        /**
         * hand
         */
        private ArrayList<ItemDTO> hand;

        /**
         * Constructor
         */
        public Builder() {
        }


        /**
         * set hand
         *
         * @param hand hand
         * @return builder
         */
        public Builder setHand(ArrayList<ItemDTO> hand) {
            this.hand = hand;
            return this;
        }


        /**
         * build
         *
         * @return DropCardResponse
         */
        public DropCardResponse build() {
            DropCardResponse res = new DropCardResponse();
            res.hand = hand;
            return res;
        }
    }
}
