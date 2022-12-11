package com.progmeth.project.sheriff.data.game.entity.derive.deck;

import com.progmeth.project.sheriff.data.game.entity.base.Item;
import com.progmeth.project.sheriff.data.game.entity.derive.illegal.Crossbow;
import com.progmeth.project.sheriff.data.game.entity.derive.illegal.Dedder;
import com.progmeth.project.sheriff.data.game.entity.derive.illegal.Mead;
import com.progmeth.project.sheriff.data.game.entity.derive.illegal.RoyalRooster;
import com.progmeth.project.sheriff.data.game.entity.derive.legal.Apple;
import com.progmeth.project.sheriff.data.game.entity.derive.legal.Cheese;
import com.progmeth.project.sheriff.data.game.entity.derive.legal.Chicken;
import com.progmeth.project.sheriff.data.game.entity.derive.legal.Bread;

import java.util.Random;

public class MainCardDeck {
    private final Item[] items = new Item[]{
            Apple.getInstance(),
            Bread.getInstance(),
            Cheese.getInstance(),
            Chicken.getInstance(),
            Crossbow.getInstance(),
            Dedder.getInstance(),
            Mead.getInstance(),
            RoyalRooster.getInstance(),
    };

    public Item draw() {
        int index = new Random().nextInt(items.length);
        return items[index];
    }
}
