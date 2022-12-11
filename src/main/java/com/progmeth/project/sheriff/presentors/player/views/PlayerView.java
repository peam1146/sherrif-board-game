package com.progmeth.project.sheriff.presentors.player.views;

import com.progmeth.project.sheriff.presentors.common.GameFont;
import com.progmeth.project.sheriff.presentors.common.components.Card;
import com.progmeth.project.sheriff.presentors.common.components.IllegalCard;
import com.progmeth.project.sheriff.presentors.common.components.LegalCard;
import com.progmeth.project.sheriff.presentors.player.controllers.PlayerController;
import com.progmeth.project.sheriff.presentors.player.views.components.SideBar;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class PlayerView extends BorderPane {
    private final PlayerController controller;
    public PlayerView(PlayerController controller){
        this.controller = controller;
        super.setStyle("-fx-background-color: #DACAA6;");
        Text text = new Text("Player View");
        SideBar sideBar = new SideBar();
        super.setLeft(sideBar);

        getChildren().addAll(text);
    }
}
