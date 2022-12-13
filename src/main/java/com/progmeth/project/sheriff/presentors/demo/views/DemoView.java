package com.progmeth.project.sheriff.presentors.demo.views;

import com.progmeth.project.sheriff.core.utils.view.controllers.StreamBuilder;
import com.progmeth.project.sheriff.data.game.server.network.RoomServer;
import com.progmeth.project.sheriff.presentors.demo.controllers.DemoController;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class DemoView extends StackPane {
    private final DemoController controller;
    public DemoView(DemoController controller) {
        super.setAlignment(Pos.CENTER);
        this.controller = controller;
        final TextField roomName = new TextField();
        final Button btn = new Button("Start Server");
        btn.setOnMouseClicked(e -> controller.createRoom("test"));
        final Button btn2 = new Button("Join Server");
        final Button btn3 = new Button("Disconnect");
        final Button btn4 = new Button("Close Server");
        final Button btn5 = new Button("Get Players");
        StreamBuilder<Integer, DemoController> stream = new StreamBuilder<>(controller) {
            @Override
            protected Node builder(Integer state) {
                switch (state) {
                    case 0 -> btn.setText("Start Server");
                    case 1 -> btn.setText("Creating Room");
                    case 2 -> btn.setText("Room Created");
                    case 3 -> btn.setText("Room Creation Failed");
                }
                return btn;
            }
        };
        btn2.setOnMouseClicked(e -> controller.joinRoom("test"));
        btn3.setOnMouseClicked(e -> controller.startGame());
        btn4.setOnMouseClicked(e -> RoomServer.getInstance().close());
        btn5.setOnMouseClicked(e -> controller.getPlayers());
        roomName.textProperty().addListener((observable, oldValue, newValue) -> controller.setText(newValue));
        final VBox box = new VBox(roomName, stream, btn2, btn3, btn4, btn5);
        box.setSpacing(10);
        box.setAlignment(Pos.CENTER);
        getChildren().add(box);
    }
}
