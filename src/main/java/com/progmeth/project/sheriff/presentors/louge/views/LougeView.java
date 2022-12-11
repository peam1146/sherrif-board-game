package com.progmeth.project.sheriff.presentors.louge.views;

import com.progmeth.project.sheriff.presentors.louge.controllers.LougeController;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class LougeView extends StackPane {
    private final static String BG_IMG = LougeView.class.getResource("/com/progmeth/project/sheriff/images/bg.png").toString();
    private final static String BG_PLATE = LougeView.class.getResource("/com/progmeth/project/sheriff/images/louge_bg_plate.png").toString();

    private final LougeController controller;

    public LougeView(LougeController controller) {
        this.controller = controller;
        super.setAlignment(Pos.CENTER);
        super.setBackground(new Background(new BackgroundFill(Color.BROWN, null, null)));

        ImageView bgPlateImage = new ImageView(BG_PLATE);
        ImageView bgImage = new ImageView(BG_IMG);
        bgImage.setFitHeight(610);
        bgImage.setFitWidth(800);

        bgPlateImage.setFitHeight(466);
        bgPlateImage.setFitWidth(459);

        Background TextFieldBackground = new Background(new BackgroundFill(Color.rgb(96,58,51), null, null));
        String TextFieldStyle = "-fx-control-inner-background: #603A33;-fx-border-color: #21070B;-fx-border-width: 2px;-fx-prompt-text-fill: #FFFFFF;-fx-font-size: 16px;";
        TextField IPField = new TextField();
        IPField.setPromptText("Server IP");
        IPField.setMaxWidth(334);
        IPField.setPrefHeight(46);
        IPField.setTranslateY(-54);
        IPField.setBackground(TextFieldBackground);
        IPField.setStyle(TextFieldStyle);

        TextField UsernameField = new TextField();
        UsernameField.setPromptText("Username");
        UsernameField.setMaxWidth(334);
        UsernameField.setPrefHeight(46);
        UsernameField.setBackground(TextFieldBackground);
        UsernameField.setStyle(TextFieldStyle);

        Button JoinButton = new Button("Join");
        JoinButton.setFont(new Font(16));
        JoinButton.textFillProperty().setValue(Color.WHITE);
        JoinButton.setStyle("-fx-background-color: #21070B;-fx-border-radius: 0;");
        JoinButton.setTranslateY(50);
        JoinButton.setMinWidth(88);
        JoinButton.setTranslateX(167-44); //167 from 334/2 44 from 88/2

        JoinButton.setOnMouseClicked(event -> controller.joinGame());
        getChildren().addAll(bgImage,bgPlateImage, IPField, UsernameField,JoinButton);
    }
}
