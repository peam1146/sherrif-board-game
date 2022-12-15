package com.progmeth.project.sheriff.data.game.models.derive.deck;

import com.progmeth.project.sheriff.data.game.models.base.Item;

import java.util.Stack;

/**
 * Deck of cards
 */
public class DroppedDeck {

    /**
     * Cards in the deck
     */
    final private Stack<Item> items = new Stack<>();

    /**
     * Add a card to the deck
     *
     * @param i item to add
     */
    public void add(Item i) {
        items.push(i);
    }

    /**
     * Constructor
     */
    public DroppedDeck() {
    }

    /**
     * Draw a card from the deck
     *
     * @return card drawn
     */
    public Item draw() {
        return items.pop();
    }

    /**
     * get the card at the top of the deck
     *
     * @return item
     */
    public Item top() {
        return items.peek();
    }
}