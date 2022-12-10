package com.progmeth.project.sheriff.usecases.game.logic.entity.derive.hand;

import com.progmeth.project.sheriff.usecases.game.logic.entity.base.Item;

import java.util.HashMap;

public class Hand {
    private final HashMap<Item, Integer> items = new HashMap<>();

    public void add(Item i) {
        if (items.containsKey(i)) {
            items.put(i, items.get(i) + 1);
            return;
        }
        items.put(i, 1);
    }

    public void remove(Item i) {
        if (items.containsKey(i)) {
            items.put(i, items.get(i) - 1);
            if (items.get(i) == 0) {
                items.remove(i);
            }
        }
    }
}
