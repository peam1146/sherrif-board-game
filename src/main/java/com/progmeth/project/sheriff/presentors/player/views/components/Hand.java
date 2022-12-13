package com.progmeth.project.sheriff.presentors.player.views.components;

import com.progmeth.project.sheriff.domain.game.entity.ItemEntity;
import com.progmeth.project.sheriff.presentors.common.ItemImg;
import com.progmeth.project.sheriff.presentors.common.components.Card;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

public class Hand extends HBox {
    public Hand() {
        super.setSpacing(10);
        super.setAlignment(Pos.CENTER);
        super.setMinHeight(200);
    }

    public void setItem(ItemEntity[] items) {
        for (int i = 0; i < 6; i++) {
            ItemEntity itemEntity = new ItemEntity(4,"test", false, 4, 10, ItemImg.CHICKEN);
            Card card = new Card(itemEntity);
            card.setSmallCard();
            card.setTranslateY(50);
            super.getChildren().add(card);
        }
    }

}
