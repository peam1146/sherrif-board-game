package com.progmeth.project.sheriff.data.game.server.models.response;

import com.progmeth.project.sheriff.data.game.server.models.DTO.ItemDTO;

import java.util.ArrayList;

/**
 * Draw card response
 */
public class DrawCardResponse extends Response {

    /**
     * topic
     */
    public static final String responseTopic = "drawCard";

    /**
     * hand payload
     */
    public ArrayList<ItemDTO> hand;

    /**
     * Constructor
     */
    public DrawCardResponse() {
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
         * @param hand hand
         *             @return builder
         */
        public Builder setHand(ArrayList<ItemDTO> hand) {
            this.hand = hand;
            return this;
        }


        /**
         * Build response
         * @return DrawCardResponse
         */
        public DrawCardResponse build() {
            DrawCardResponse res = new DrawCardResponse();
            res.hand = hand;
            return res;
        }
    }
}
