package com.progmeth.project.sheriff.presentors.player.views.components;

import com.progmeth.project.sheriff.domain.game.entity.ItemEntity;
import com.progmeth.project.sheriff.presentors.common.ItemImg;
import com.progmeth.project.sheriff.presentors.common.components.Card;
import com.progmeth.project.sheriff.presentors.player.controllers.PlayerController;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.Collection;

public class Hand extends HBox {
    PlayerController controller;
    public Hand(PlayerController controller) {
        this.controller = controller;
        super.setSpacing(10);
        super.setAlignment(Pos.CENTER);
        super.setMinHeight(200);
    }

    public void setItem(ArrayList<ItemEntity> items) {
        Collection<Node> cards = new ArrayList<>();
        for (int i = 0; i < items.size(); i++) {
            ItemEntity itemEntity = items.get(i);
            Card card = new Card(itemEntity);
            card.setSmallCard();
            card.setTranslateY(50);
            card.setOnMouseClicked(e -> {
                controller.dropItem(itemEntity,card);
            });
            cards.add(card);
        }
        super.getChildren().setAll(cards);
    }

    public void setSelectBox(){
        for(Node i : getChildren()){
            i.setOnMouseClicked(e -> {
                i.setTranslateY(60);
            });
        }
    }
}
