package com.progmeth.project.sheriff.usecases.game.logic.entity.derive.hand;

import com.progmeth.project.sheriff.usecases.game.logic.entity.base.Item;

import java.util.HashMap;

public class Hand {
    private final HashMap<Item, Integer> items = new HashMap<>();
    private int amount = 0;

    public void add(Item i) {
        if (amount > 6) return;
        if (items.containsKey(i)) {
            items.put(i, items.get(i) + 1);
        } else {
            items.put(i, 1);
        }
        amount++;
    }

    public void remove(Item i) {
        if (amount < 1) return;
        if (items.containsKey(i)) {
            items.put(i, items.get(i) - 1);
            if (items.get(i) == 0) {
                items.remove(i);
            }
            amount--;
        }
    }
}
