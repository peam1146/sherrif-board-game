package com.progmeth.project.sheriff.presentors.sheriff.views.components;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class Inspect extends StackPane {
    public Inspect(){
        VBox playerCardContainer = new VBox();
        CardPocket pocket1 = new CardPocket();
        pocket1.setName("Meen");
        CardPocket pocket2 = new CardPocket();
        pocket2.setName("Peam");
        CardPocket pocket3 = new CardPocket();
        pocket3.setName("Test");
        playerCardContainer.getChildren().addAll(pocket1,pocket2,pocket3);
        getChildren().addAll(playerCardContainer);
    }
}
