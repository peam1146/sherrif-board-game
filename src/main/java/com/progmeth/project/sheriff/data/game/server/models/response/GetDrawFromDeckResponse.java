package com.progmeth.project.sheriff.data.game.server.models.response;

import com.progmeth.project.sheriff.data.game.server.models.DTO.ItemDTO;

/**
 * Get draw from deck response
 */
public class GetDrawFromDeckResponse extends Response {
    /**
     * topic
     */
    public static final String responseTopic = "getDrawFromDeck";


    /**
     * hand payload
     */
    public ItemDTO[] hand;

    /**
     * Constructor
     */
    public GetDrawFromDeckResponse() {
        super(responseTopic);
    }

    /**
     * Class Builder
     */
    public static class Builder {
        /**
         * hand
         */
        private ItemDTO[] hand;

        /**
         * Constructor
         */
        public Builder() {
        }

        /**
         * set hand
         * @param hand hand
         * @return builder
         */
        public Builder setHand(ItemDTO[] hand) {
            this.hand = hand;
            return this;
        }

        /**
         * build
         * @return GetDrawFromDeckResponse
         */
        public GetDrawFromDeckResponse build() {
            GetDrawFromDeckResponse res = new GetDrawFromDeckResponse();
            res.hand = hand;
            return res;
        }
    }
}
