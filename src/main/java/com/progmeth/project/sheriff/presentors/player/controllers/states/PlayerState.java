package com.progmeth.project.sheriff.presentors.player.controllers.states;

import com.progmeth.project.sheriff.data.game.models.base.Item;
import com.progmeth.project.sheriff.data.game.models.derive.hand.Hand;
import com.progmeth.project.sheriff.data.game.server.models.DTO.ItemDTO;
import com.progmeth.project.sheriff.domain.game.entity.ItemEntity;

import java.util.ArrayList;

public class PlayerState {
    // To Implement
    public ArrayList<ItemEntity> hand;
    public String playerName;

    public ItemEntity topDroppedDeck;
    public ItemEntity bottomDroppedDeck;

    public PlayerState(ArrayList<ItemEntity> hand,String playerName,ItemEntity topDroppedDeck,ItemEntity bottomDroppedDeck) {
        this.playerName = playerName;
        this.hand = hand;
        this.topDroppedDeck = topDroppedDeck;
        this.bottomDroppedDeck = bottomDroppedDeck;
    }
}
