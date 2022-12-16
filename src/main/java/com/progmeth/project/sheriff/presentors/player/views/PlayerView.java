package com.progmeth.project.sheriff.presentors.player.views;

import com.progmeth.project.sheriff.core.utils.view.controllers.StreamBuilder;
import com.progmeth.project.sheriff.presentors.common.ItemImg;
import com.progmeth.project.sheriff.presentors.player.controllers.PlayerController;
import com.progmeth.project.sheriff.presentors.player.controllers.states.PlayerState;
import com.progmeth.project.sheriff.presentors.player.views.components.PlayerBoard;
import com.progmeth.project.sheriff.presentors.player.views.components.SideBar;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * Player view
 */
public class PlayerView extends BorderPane {
    /**
     * controller
     */
    private final PlayerController controller;

    /**
     * Constructor
     * @param controller controller
     */
    public PlayerView(PlayerController controller){
        this.controller = controller;
        super.setStyle("-fx-background-color: #E6DCC2;");
        Text text = new Text("Player View");
        SideBar sideBar = new SideBar(controller);
        super.setLeft(sideBar);
        HBox center = new HBox();
        center.setAlignment(Pos.CENTER);
        PlayerBoard playerBoard = new PlayerBoard(controller);
        center.getChildren().addAll(new ImageView(ItemImg.CHICKEN),new ImageView(ItemImg.APPLE),new ImageView(ItemImg.BREAD),new ImageView(ItemImg.CHEESE));
        StreamBuilder<PlayerState,PlayerController> selectBox = new StreamBuilder<>(controller){
            @Override
            public Node builder(PlayerState state) {
                if(state.showSelectBox){
                    center.setOnMouseClicked(e->{
                        controller.clearSelectBox();
                    });
                    return center;
                }else{
                    return playerBoard;
                }
            }
        };

        super.setCenter(selectBox);
        getChildren().addAll(text);
    }
}
