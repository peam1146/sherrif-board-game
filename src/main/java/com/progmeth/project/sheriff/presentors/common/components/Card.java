package com.progmeth.project.sheriff.presentors.common.components;

import com.progmeth.project.sheriff.domain.game.entity.ItemEntity;
import com.progmeth.project.sheriff.presentors.common.GameFont;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Card extends StackPane {
    protected ItemEntity item;
    private final static String IMG_LEGAL_CARD = BackCard.class.getResource("/com/progmeth/project/sheriff/images/card_legal_template.png").toString();
    private final static String IMG_ILLEGAL_CARD = BackCard.class.getResource("/com/progmeth/project/sheriff/images/card_illegal_template.png").toString();
    protected int CARD_WIDTH = 107;
    protected int CARD_HEIGHT = 136;

    public Card(ItemEntity itemEntity) {
        this.item = itemEntity;
        super.setMinWidth(CARD_WIDTH);
        super.setMinHeight(CARD_HEIGHT);

        ImageView bg = new ImageView(item.isLegal() ? IMG_LEGAL_CARD : IMG_ILLEGAL_CARD);
        bg.setFitWidth(CARD_WIDTH);
        bg.setFitHeight(CARD_HEIGHT);

        Font font = new GameFont(14).getBlack();
        Color CARD_RED = Color.rgb(181,0,0);
        Text Price = new Text("+"+item.getPrice());
        Price.setFont(font);
        Text Fine = new Text("-"+item.getFine());
        Fine.setFont(font);
        Fine.setFill(CARD_RED);
        Text TimeCost = new Text("-"+item.getTimeCost());
        TimeCost.setFont(font);
        TimeCost.setFill(CARD_RED);
        getChildren().addAll(bg);

        if(item.isLegal()) {
            getChildren().addAll(Price,TimeCost);
            setAlignment(Price, Pos.TOP_LEFT);
            setAlignment(TimeCost, Pos.BOTTOM_RIGHT);
            TimeCost.setTranslateX(-24);
            TimeCost.setTranslateY(-10);
            TimeCost.setStyle("-fx-text-fill: #B50000;");
        } else {
            getChildren().addAll(Price,Fine);
            setAlignment(Price, Pos.TOP_LEFT);
            setAlignment(Fine, Pos.BOTTOM_RIGHT);
            Fine.setTranslateX(-24);
            Fine.setTranslateY(-10);
            Fine.setStyle("-fx-text-fill: #B50000;");
        }
        Price.setTranslateX(24);
        Price.setTranslateY(10);

        ImageView img = new ImageView(item.getImgURL());
        img.setPreserveRatio(true);
        img.setFitWidth(32);
        img.setTranslateY(-10);
        getChildren().add(img);
    }

    public BackCard getBackCard() {
        return new BackCard(item);
    }

}
