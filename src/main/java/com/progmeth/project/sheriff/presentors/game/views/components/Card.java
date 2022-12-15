package com.progmeth.project.sheriff.presentors.game.views.components;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

/**
 * Card component
 */
public class Card extends StackPane {

    /**
     * Constructor
     */
    public Card() {
        super.setMaxWidth(90);
        super.setMaxHeight(150);
        super.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
    }
}