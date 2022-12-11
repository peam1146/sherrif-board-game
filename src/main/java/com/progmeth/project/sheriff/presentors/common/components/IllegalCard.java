package com.progmeth.project.sheriff.presentors.common.components;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class IllegalCard extends Card {
    private final static String IMG_BACK_CARD = BackCard.class.getResource("/com/progmeth/project/sheriff/images/card_illegal_template.png").toString();
    public IllegalCard() {
        ImageView bg = new ImageView(IMG_BACK_CARD);
        bg.setFitWidth(107);
        bg.setFitHeight(136);
//        super.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
        getChildren().addAll(new Text("Back"),bg);
    }
}
