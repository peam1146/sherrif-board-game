package com.progmeth.project.sheriff.presentors.player.views;

import com.progmeth.project.sheriff.presentors.player.controllers.PlayerController;
import com.progmeth.project.sheriff.presentors.player.views.components.PlayerBoard;
import com.progmeth.project.sheriff.presentors.player.views.components.SideBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

public class PlayerView extends BorderPane {
    private final PlayerController controller;
    public PlayerView(PlayerController controller){
        this.controller = controller;
        super.setStyle("-fx-background-color: #E6DCC2;");
        Text text = new Text("Player View");
        SideBar sideBar = new SideBar();
        super.setLeft(sideBar);
        super.setCenter(new PlayerBoard());
        getChildren().addAll(text);
    }
}
