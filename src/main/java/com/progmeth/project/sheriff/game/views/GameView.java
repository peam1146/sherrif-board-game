package com.progmeth.project.sheriff.game.views;

import com.progmeth.project.sheriff.core.utils.controllers.StreamBuilder;
import com.progmeth.project.sheriff.game.controllers.GameController;
import com.progmeth.project.sheriff.game.controllers.states.GameState;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class GameView extends StackPane {
    private final GameController controller;
    public GameView(GameController controller) {
        this.controller = controller;
        final Button increment = new Button("Increment");
        increment.setOnMouseClicked(e -> controller.increment());
        final Text text = new Text();
        final Button decrement = new Button("Decrement");
        decrement.setOnMouseClicked(e -> controller.decrement());
        StreamBuilder<GameState, GameController> streamBuilder = new StreamBuilder<>(controller){
            @Override
            protected Node builder(GameState state) {
                text.setText(String.valueOf(state.getCount()));
                return text;
            }
        };
        final VBox box = new VBox(increment, streamBuilder, decrement);
        box.setAlignment(Pos.CENTER);
        box.setSpacing(10);
        getChildren().add(box);
    }
}
