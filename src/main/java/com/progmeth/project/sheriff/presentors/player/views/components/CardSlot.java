package com.progmeth.project.sheriff.presentors.player.views.components;

import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class CardSlot extends StackPane {
    private final static String IMG_EMPTY_SLOT = CardSlot.class.getResource("/com/progmeth/project/sheriff/images/card_empty_slot.png").toString();

    public CardSlot() {
        ImageView EmptySlot = new ImageView(IMG_EMPTY_SLOT);
        EmptySlot.setFitHeight(93);
        EmptySlot.setFitWidth(71);

        getChildren().addAll(EmptySlot);
    }
}
