package com.progmeth.project.sheriff.presentors.common.components;

import javafx.scene.layout.StackPane;

public abstract class Card extends StackPane {
    private int value;

    public Card() {
        super.setMinWidth(107);
        super.setMinHeight(136);
    }

}
