package com.progmeth.project.sheriff.presentors.common.components;

import com.progmeth.project.sheriff.domain.game.entity.ItemEntity;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class BackCard extends Card {
    private final static String IMG_BACK_CARD = BackCard.class.getResource("/com/progmeth/project/sheriff/images/card_back.png").toString();
    public BackCard(ItemEntity item) {
        super(item);
        ImageView bg = new ImageView(IMG_BACK_CARD);
        bg.setFitWidth(super.CARD_WIDTH);
        bg.setFitHeight(super.CARD_HEIGHT);
        getChildren().add(bg);
    }
}
