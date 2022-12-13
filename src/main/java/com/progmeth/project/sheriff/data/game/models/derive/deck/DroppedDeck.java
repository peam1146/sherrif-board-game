package com.progmeth.project.sheriff.data.game.models.derive.deck;

import com.progmeth.project.sheriff.data.game.models.base.Item;

import java.util.Stack;

public class DroppedDeck {
    final private Stack<Item> items = new Stack<>();

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