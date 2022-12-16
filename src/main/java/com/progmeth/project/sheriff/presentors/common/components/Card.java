package com.progmeth.project.sheriff.presentors.common.components;

import com.almasb.fxgl.event.Subscriber;
import com.progmeth.project.sheriff.domain.game.entity.ItemEntity;
import com.progmeth.project.sheriff.presentors.common.GameFont;
import com.progmeth.project.sheriff.presentors.common.ItemImg;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.concurrent.Flow;

public class Card extends StackPane {
    protected ItemEntity item;
    private final static String IMG_LEGAL_CARD = BackCard.class.getResource("/com/progmeth/project/sheriff/images/card_legal_template.png").toString();
    private final static String IMG_ILLEGAL_CARD = BackCard.class.getResource("/com/progmeth/project/sheriff/images/card_illegal_template.png").toString();
    protected int CARD_WIDTH = 107;
    protected int CARD_HEIGHT = 136;

    private ImageView bg;
    private ImageView img;
    private Text fine;
    private Text timeCost;
    private Text price;

    private Boolean isSelectForDrop = false;

    public Card(ItemEntity itemEntity) {
        setItem(itemEntity);
    }

    public void setItem(ItemEntity item) {
        this.item = item;
        super.setMinWidth(CARD_WIDTH);
        super.setMinHeight(CARD_HEIGHT);
        this.bg = new ImageView(item.isLegal() ? IMG_LEGAL_CARD : IMG_ILLEGAL_CARD);

        bg.setFitWidth(CARD_WIDTH);
        bg.setFitHeight(CARD_HEIGHT);

        Font font = new GameFont(14).getBlack();
        Color CARD_RED = Color.rgb(181,0,0);
        price = new Text("+"+item.getPrice());
        price.setFont(font);
        fine = new Text("-"+item.getFine());
        fine.setFont(font);
        fine.setFill(CARD_RED);
        timeCost = new Text("-"+item.getTimeCost());
        timeCost.setFont(font);
        timeCost.setFill(CARD_RED);
        getChildren().addAll(bg);

        if(item.isLegal()) {
            getChildren().addAll(price,timeCost);
            setAlignment(price, Pos.TOP_LEFT);
            setAlignment(timeCost, Pos.BOTTOM_RIGHT);
            timeCost.setTranslateX(-24);
            timeCost.setTranslateY(-10);
            timeCost.setStyle("-fx-text-fill: #B50000;");
        } else {
            getChildren().addAll(price,fine);
            setAlignment(price, Pos.TOP_LEFT);
            setAlignment(fine, Pos.BOTTOM_RIGHT);
            fine.setTranslateX(-24);
            fine.setTranslateY(-10);
            fine.setStyle("-fx-text-fill: #B50000;");
        }
        price.setTranslateX(24);
        price.setTranslateY(10);

        this.img = new ImageView(getURL(item.getName()));
        img.setPreserveRatio(true);
        img.setFitWidth(32);
        img.setTranslateY(-10);
        getChildren().add(img);

    }
//
    private String getURL(String name){
        return switch (name) {
            case "Crossbow" -> ItemImg.CROSSBOW;
            case "Dedder" -> ItemImg.DEDDER;
            case "Mead" -> ItemImg.MEAD;
            case "RoyalRooster" -> ItemImg.ROYALROOSTER;
            case "Apple" -> ItemImg.APPLE;
            case "Bread" -> ItemImg.BREAD;
            case "Cheese" -> ItemImg.CHEESE;
            case "Chicken" -> ItemImg.CHICKEN;
            default -> ItemImg.CHICKEN;
        };
    }

    public BackCard getBackCard() {
        return new BackCard(item);
    }

    public void setSmallCard() {
        CARD_WIDTH = 65;
        CARD_HEIGHT = 83;
        super.setMaxWidth(CARD_WIDTH);
        super.setMinWidth(CARD_WIDTH);
        super.setMaxHeight(CARD_HEIGHT);
        super.setMinHeight(CARD_HEIGHT);
        bg.setFitHeight(CARD_HEIGHT);
        bg.setFitWidth(CARD_WIDTH);
        img.setFitWidth(24);
        img.setTranslateY(-5);

        Font font = new GameFont(10).getBlack();
        price.setTranslateX(5);
        price.setTranslateY(5);
        price.setFont(font);

        if(item.isLegal()) {
            timeCost.setTranslateX(-5);
            timeCost.setTranslateY(-5);
            timeCost.setFont(font);
        } else {
            fine.setTranslateX(-5);
            fine.setTranslateY(-5);
            fine.setFont(font);
        }
    }

    public void setDrop(EventHandler<MouseEvent> e) {
        setOnMouseClicked(e);
    }
}
