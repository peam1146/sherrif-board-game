package com.progmeth.project.sheriff.data.game.models.derive.deck;

import com.progmeth.project.sheriff.data.game.models.base.Item;
import com.progmeth.project.sheriff.data.game.models.derive.illegal.Crossbow;
import com.progmeth.project.sheriff.data.game.models.derive.illegal.Dedder;
import com.progmeth.project.sheriff.data.game.models.derive.illegal.Mead;
import com.progmeth.project.sheriff.data.game.models.derive.illegal.RoyalRooster;
import com.progmeth.project.sheriff.data.game.models.derive.legal.Apple;
import com.progmeth.project.sheriff.data.game.models.derive.legal.Bread;
import com.progmeth.project.sheriff.data.game.models.derive.legal.Cheese;
import com.progmeth.project.sheriff.data.game.models.derive.legal.Chicken;

import java.util.Random;
import java.util.Stack;

public class DroppedDeck {
    private Stack<Item> items = new Stack<>();
    private final Item[] randomAbleCards = new Item[]{
            Apple.getInstance(),
            Bread.getInstance(),
            Cheese.getInstance(),
            Chicken.getInstance(),
            Crossbow.getInstance(),
            Dedder.getInstance(),
            Mead.getInstance(),
            RoyalRooster.getInstance(),
    };
    public DroppedDeck(){
        this.items = new Stack<>();
        for(int i = 0; i < 5; i++) {
            int index = new Random().nextInt(randomAbleCards.length);
            add(randomAbleCards[index]);
        }
    }

    public void add(Item i) {
        items.push(i);
    }

    public Item draw() {
        return items.pop();
    }

    public Item top() {
        return items.peek();
    }
}