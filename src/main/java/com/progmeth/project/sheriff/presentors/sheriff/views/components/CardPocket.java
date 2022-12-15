package com.progmeth.project.sheriff.presentors.sheriff.views.components;

import com.progmeth.project.sheriff.presentors.common.GameFont;
import com.progmeth.project.sheriff.presentors.player.views.components.Money;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 * Card pocket component
 */
public class CardPocket extends StackPane {

    /**
     * image path
     */
    private final static String IMG_CARD_POCKET = CardPocket.class.getResource("/com/progmeth/project/sheriff/images/card_back_pocket.png").toString();

    /**
     * name text
     */
    private Text name;

    /**
     * Constructor
     */
    public CardPocket(){
        setAlignment(Pos.CENTER_LEFT);
        ImageView cardPocket = new ImageView(IMG_CARD_POCKET);
        cardPocket.setFitHeight(84);
        cardPocket.setFitWidth(135);
        StackPane pocketOwnerNameTag = new StackPane();
        name = new Text("");
        name.setFont(new GameFont(12).getBlack());
        name.setFill(Color.rgb(96,58,51));
        name.setStyle("-fx-font-style: italic; ");

        pocketOwnerNameTag.getChildren().add(name);
        pocketOwnerNameTag.setMaxHeight(35);
        pocketOwnerNameTag.setMaxWidth(100);
        pocketOwnerNameTag.setPadding(new Insets(5, 5, 5, 5));
        pocketOwnerNameTag.setStyle("-fx-background-color: #DACAA6;");

        pocketOwnerNameTag.setTranslateY(65);
        pocketOwnerNameTag.setTranslateX(14);

        setMinHeight(84+65);

        Money bride = new Money();
        bride.setAlignment(Pos.CENTER_LEFT);
        bride.setTranslateX(165);
        setPadding(new Insets(10, 10, 10, 20));
        getChildren().addAll(cardPocket,pocketOwnerNameTag,bride);


    }

    /**
     * Set name
     * @param name name
     */
    public void setName(String name) {
        this.name.setText(name);
    }
}
