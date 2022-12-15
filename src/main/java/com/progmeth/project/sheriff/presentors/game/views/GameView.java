package com.progmeth.project.sheriff.presentors.game.views;

import com.progmeth.project.sheriff.presentors.game.controllers.GameController;
import com.progmeth.project.sheriff.presentors.game.views.components.Card;
import javafx.scene.layout.StackPane;

/**
 * Game view
 */
public class GameView extends StackPane {
    /**
     * controller
     */
    private final GameController controller;

    /**
     * Constructor
     * @param controller controller
     */
    public GameView(GameController controller) {
        this.controller = controller;
        Card card = new Card();
        getChildren().add(card);
    }
}
