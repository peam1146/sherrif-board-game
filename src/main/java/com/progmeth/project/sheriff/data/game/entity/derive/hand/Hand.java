package com.progmeth.project.sheriff.data.game.entity.derive.hand;

import com.progmeth.project.sheriff.data.game.entity.base.Item;

import java.util.ArrayList;

public class Hand {
    private final ArrayList<Item> items = new ArrayList<>();
    private int amount = 0;

    public void add(Item i) {
        if (amount > 6) return;
        items.add(i);
        amount++;
    }

    public void remove(Item i) {
        if (amount < 1) return;
        items.remove(i);
        amount--;
    }

    public ArrayList<Item> getItems() {
        return items;
    }
}
