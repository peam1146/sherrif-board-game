package com.progmeth.project.sheriff.data.game.models.base;

/**
 * Base class for all items
 */
public abstract class Item {

    /**
     * price
     */
    final int price;

    /**
     * item name
     */
    final String name;

    /**
     * Constructor
     * @param price price
     * @param name name
     */
    public Item(int price, String name) {
        this.price = price;
        this.name = name;
    }
    
    @Override
    public String toString() {
        return name;
    }

    /**
     * Get price
     * @return price
     */
    public int getPrice() {
        return price;
    }


    /**
     * Get name
     * @return name
     */
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Item && ((Item) obj).getName().equals(name);
    }
}

