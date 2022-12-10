package com.progmeth.project.sheriff.usecases.game.logic.entity.derive.deck;

import com.progmeth.project.sheriff.usecases.game.logic.entity.base.Item;
import com.progmeth.project.sheriff.usecases.game.logic.entity.derive.illegal.Crossbow;
import com.progmeth.project.sheriff.usecases.game.logic.entity.derive.illegal.Dedder;
import com.progmeth.project.sheriff.usecases.game.logic.entity.derive.illegal.Mead;
import com.progmeth.project.sheriff.usecases.game.logic.entity.derive.illegal.RoyalRooster;
import com.progmeth.project.sheriff.usecases.game.logic.entity.derive.legal.Apple;
import com.progmeth.project.sheriff.usecases.game.logic.entity.derive.legal.Bread;
import com.progmeth.project.sheriff.usecases.game.logic.entity.derive.legal.Cheese;
import com.progmeth.project.sheriff.usecases.game.logic.entity.derive.legal.Chicken;

import java.util.Random;

public class MainCardDeck {
    private final Item[] items = new Item[]{
            new Apple(),
            new Bread(),
            new Cheese(),
            new Chicken(),
            new Crossbow(),
            new Dedder(),
            new Mead(),
            new RoyalRooster(),
    };

    public Item draw() {
        int index = new Random().nextInt(items.length);
        return items[index];
    }
}
