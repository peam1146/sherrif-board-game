package com.progmeth.project.sheriff.data.game.server.models.response;

import com.progmeth.project.sheriff.data.game.server.models.DTO.ItemDTO;

public class GetDroppedDeckTopResponse extends Response{
    public static final String responseTopic = "droppedDeckTop";
    public ItemDTO topDroppedDeckTop;
    public ItemDTO bottomDroppedDeckTop;

    public GetDroppedDeckTopResponse() {
        super(responseTopic);
    }

    public static class Builder {
        private ItemDTO topDroppedDeckTop;
        private ItemDTO bottomDroppedDeckTop;

        public Builder setDroppedDeckTop(ItemDTO topDroppedDeckTop,ItemDTO bottomDroppedDeckTop) {
            this.topDroppedDeckTop = topDroppedDeckTop;
            this.bottomDroppedDeckTop = bottomDroppedDeckTop;
            return this;
        }

        public GetDroppedDeckTopResponse build() {
            GetDroppedDeckTopResponse response = new GetDroppedDeckTopResponse();
            response.topDroppedDeckTop = topDroppedDeckTop;
            response.bottomDroppedDeckTop = bottomDroppedDeckTop;
            return response;
        }
    }
}
