package com.progmeth.project.sheriff.presentors.player.views.components;

import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

/**
 * Card slot component
 */
public class CardSlot extends StackPane {

    /**
     * image path
     */
    private final static String IMG_EMPTY_SLOT = CardSlot.class.getResource("/com/progmeth/project/sheriff/images/card_empty_slot.png").toString();

    /**
     * Constructor
     */
    public CardSlot() {
        ImageView emptySlot = new ImageView(IMG_EMPTY_SLOT);
        emptySlot.setFitHeight(93);
        emptySlot.setFitWidth(71);

        getChildren().addAll(emptySlot);
    }
}
