package com.progmeth.project.sheriff.presentors.sheriff.views.components;

import com.progmeth.project.sheriff.presentors.sheriff.controllers.SheriffController;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 * Inspect
 */
public class Inspect extends StackPane {

    private VBox playerCardContainer = new VBox();

    /**
     * Constructor
     */
    public Inspect(SheriffController controller){
        getChildren().addAll(playerCardContainer);
    }

    public void addPlayer (String name, int id) {
        CardPocket pocket = new CardPocket();
        pocket.setName(name);
        playerCardContainer.getChildren().add(pocket);
    }

    public void clear() {
        playerCardContainer.getChildren().clear();
    }
}
