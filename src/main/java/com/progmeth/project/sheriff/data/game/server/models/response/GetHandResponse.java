package com.progmeth.project.sheriff.data.game.server.models.response;

import com.progmeth.project.sheriff.data.game.server.models.DTO.ItemDTO;

import java.util.ArrayList;

/**
 * get hand response
 */
public class GetHandResponse extends Response {

    /**
     * topic
     */
    public static String responseTopic = "getHand";

    /**
     * hand payload
     */
    public ArrayList<ItemDTO> hand;

    /**
     * Constructor
     */
    public GetHandResponse() {
        super(responseTopic);
    }

    /**
     * Class Builder
     */
    public static class Builder {

        /**
         * Constructor
         */
        public Builder() {
        }

        /**
         * hand
         */
        private ArrayList<ItemDTO> hand;

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
         * Build response
         *
         * @return GetHandResponse
         */
        public GetHandResponse build() {
            GetHandResponse res = new GetHandResponse();
            res.hand = hand;
            return res;
        }
    }
}
