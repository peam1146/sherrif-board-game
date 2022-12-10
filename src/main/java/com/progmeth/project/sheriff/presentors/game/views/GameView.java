package com.progmeth.project.sheriff.presentors.game.views;

import com.progmeth.project.sheriff.presentors.game.controllers.GameController;
import com.progmeth.project.sheriff.presentors.game.views.components.Card;
import javafx.scene.layout.StackPane;

public class GameView extends StackPane {
    private final GameController controller;
    public GameView(GameController controller) {
        this.controller = controller;
        Card card = new Card();
        getChildren().add(card);
    }
}
