package com.progmeth.project.sheriff.presentors.waiting.views;

import com.progmeth.project.sheriff.presentors.waiting.controllers.WaitingRoomController;
import io.reactivex.rxjava3.core.Observable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.concurrent.TimeUnit;

public class WaitingRoomView extends StackPane {
    private final static String BG_IMG = com.progmeth.project.sheriff.presentors.louge.views.LougeView.class.getResource("/com/progmeth/project/sheriff/images/bg.png").toString();
    private final static String BG_PLATE = com.progmeth.project.sheriff.presentors.louge.views.LougeView.class.getResource("/com/progmeth/project/sheriff/images/louge_bg_plate.png").toString();

    private final WaitingRoomController controller;

    private final Text text;

    public WaitingRoomView(WaitingRoomController controller) {
        this.controller = controller;
        super.setAlignment(Pos.CENTER);
        super.setBackground(new Background(new BackgroundFill(Color.BROWN, null, null)));

        ImageView bgPlateImage = new ImageView(BG_PLATE);
        ImageView bgImage = new ImageView(BG_IMG);
        bgImage.setFitHeight(610);
        bgImage.setFitWidth(800);

        bgPlateImage.setFitHeight(466);
        bgPlateImage.setFitWidth(459);

        text = new Text("Waiting for other players...");
        text.setStyle("-fx-font-size: 16px;-fx-fill: #DACAA6;-fx-font-weight: bold;");

        HBox actionBox = new HBox();
        actionBox.setAlignment(Pos.CENTER);

        Button startGame = new Button("Start Game");
        startGame.setOnAction(e->controller.startGame());
        startGame.setFont(new Font(16));
        startGame.textFillProperty().setValue(Color.WHITE);
        startGame.setStyle("-fx-background-color: #21070B;-fx-border-radius: 0;");

        actionBox.getChildren().addAll(startGame);
        actionBox.setSpacing(10);
        actionBox.setTranslateY(30);
        getChildren().addAll(bgImage,bgPlateImage,text,actionBox);
    }

    public void getPlayers(){
        controller.getPlayersPolling(players -> {
            StringBuilder playerDisplay = new StringBuilder();
            for(String i : players) {
                playerDisplay.append(i).append(" ");
            }
            text.setText("Players: " + playerDisplay);
        });
    }

}
