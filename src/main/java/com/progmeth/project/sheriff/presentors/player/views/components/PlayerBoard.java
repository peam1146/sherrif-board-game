package com.progmeth.project.sheriff.presentors.player.views.components;

import com.progmeth.project.sheriff.domain.game.entity.ItemEntity;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.transform.Rotate;

/**
 * player board
 */
public class PlayerBoard extends BorderPane {
    /**
     * player board image
     */
    private final static String IMG_PLAYER_BOARD = PlayerBoard.class.getResource("/com/progmeth/project/sheriff/images/player_board.png").toString();

    /**
     * Constructor
     */
    public PlayerBoard(){
        super.setMinWidth(227);
        super.setMinHeight(310);
        ImageView playerBoardImage = new ImageView(IMG_PLAYER_BOARD);
        playerBoardImage.setFitHeight(310);
        playerBoardImage.setFitWidth(227);
        super.setCenter(playerBoardImage);
        VBox leftCardSlot = new VBox();
        leftCardSlot.setSpacing(60);
        CardSlot AppleCardSlot = new CardSlot();
        CardSlot CheeseCardSlot = new CardSlot();
        leftCardSlot.getChildren().addAll(AppleCardSlot, CheeseCardSlot);
        leftCardSlot.setAlignment(Pos.CENTER_RIGHT);
        leftCardSlot.setPadding(new javafx.geometry.Insets(0, 0, 0, 140));
        leftCardSlot.setTranslateY(-40);
        VBox rightCardSlot = new VBox();
        rightCardSlot.setSpacing(60);
        CardSlot ChickenCardSlot = new CardSlot();
        CardSlot BreadCardSlot = new CardSlot();
        rightCardSlot.getChildren().addAll(ChickenCardSlot, BreadCardSlot);
        rightCardSlot.setAlignment(Pos.CENTER_LEFT);
        rightCardSlot.setPadding(new javafx.geometry.Insets(0, 140, 0, 0));
        rightCardSlot.setTranslateY(-40);


        VBox topContainer = new VBox();
        topContainer.setSpacing(60);
        HBox topCardSlot = new HBox();
        topCardSlot.getChildren().add(new IllegalCardSlot());
        topCardSlot.setAlignment(Pos.CENTER);

        Rotate illegalCardRotate = new Rotate();
        illegalCardRotate.setAngle(90);
        illegalCardRotate.setPivotX(360);
        illegalCardRotate.setPivotY(10);
        topCardSlot.getTransforms().add(illegalCardRotate);

        Money money = new Money();
        NameTag nameTag = new NameTag();
        nameTag.setName("Meen");
        nameTag.setTranslateX(420);
        nameTag.setTranslateY(10);
        HBox topContainerHBox = new HBox();
        topContainerHBox.getChildren().addAll(money,nameTag);
        topContainer.getChildren().addAll(topContainerHBox,topCardSlot);

        Hand hand = new Hand();
        hand.setItem(new ItemEntity[0]);

        super.setLeft(leftCardSlot);
        super.setRight(rightCardSlot);
        super.setTop(topContainer);
        super.setBottom(hand);

    }
}
