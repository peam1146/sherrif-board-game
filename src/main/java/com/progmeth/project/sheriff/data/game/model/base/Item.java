package com.progmeth.project.sheriff.data.game.model.base;

public abstract class Item {

    final int price;
    final String name;
    public Item(int price, String name) {
        this.price = price;
        this.name = name;
    }
    
    @Override
    public String toString() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Item && ((Item) obj).getName().equals(name);
    }
}

