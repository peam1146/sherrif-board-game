package com.progmeth.project.sheriff.presentors.player.views.components;

import com.progmeth.project.sheriff.presentors.common.components.BackCard;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class PlayerBoard extends BorderPane {
    private final static String IMG_PLAYER_BOARD = PlayerBoard.class.getResource("/com/progmeth/project/sheriff/images/player_board.png").toString();
    public PlayerBoard(){
        super.setMinWidth(227);
        super.setMinHeight(310);
        ImageView PlayerBoardImage = new ImageView(IMG_PLAYER_BOARD);
        PlayerBoardImage.setFitHeight(310);
        PlayerBoardImage.setFitWidth(227);
        super.setCenter(PlayerBoardImage);
        VBox LeftCardSlot = new VBox();
        LeftCardSlot.setSpacing(60);
        CardSlot AppleCardSlot = new CardSlot();
        CardSlot CheeseCardSlot = new CardSlot();
        LeftCardSlot.getChildren().addAll(AppleCardSlot, CheeseCardSlot);
        LeftCardSlot.setAlignment(Pos.CENTER_RIGHT);
        LeftCardSlot.setPadding(new javafx.geometry.Insets(0, 0, 0, 140));
        VBox RightCardSlot = new VBox();
        RightCardSlot.setSpacing(60);
        CardSlot ChickenCardSlot = new CardSlot();
        CardSlot BreadCardSlot = new CardSlot();
        RightCardSlot.getChildren().addAll(ChickenCardSlot, BreadCardSlot);
        RightCardSlot.setAlignment(Pos.CENTER_LEFT);
        RightCardSlot.setPadding(new javafx.geometry.Insets(0, 140, 0, 0));

        VBox TopContainer = new VBox();
        TopContainer.setSpacing(60);
        HBox TopCardSlot = new HBox();
        TopCardSlot.getChildren().add(new IllegalCardSlot());
        TopCardSlot.setAlignment(Pos.CENTER);

        Money money = new Money();
        TopContainer.getChildren().addAll(money,TopCardSlot );
        super.setLeft(LeftCardSlot);
        super.setRight(RightCardSlot);
        super.setTop(TopContainer);
    }
}
