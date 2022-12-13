package com.progmeth.project.sheriff.data.game.models.derive.deck;

import com.progmeth.project.sheriff.data.game.models.base.Item;
import com.progmeth.project.sheriff.data.game.models.derive.illegal.Crossbow;
import com.progmeth.project.sheriff.data.game.models.derive.illegal.Dedder;
import com.progmeth.project.sheriff.data.game.models.derive.illegal.Mead;
import com.progmeth.project.sheriff.data.game.models.derive.illegal.RoyalRooster;
import com.progmeth.project.sheriff.data.game.models.derive.legal.Apple;
import com.progmeth.project.sheriff.data.game.models.derive.legal.Cheese;
import com.progmeth.project.sheriff.data.game.models.derive.legal.Chicken;
import com.progmeth.project.sheriff.data.game.models.derive.legal.Bread;

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
