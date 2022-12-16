package com.progmeth.project.sheriff.data.game.models.base;

public abstract class Item {
    final int price;
    final String name;

    public final String imgURL;

    public Item(int price, String name,String imgURL) {
        this.price = price;
        this.name = name;
        this.imgURL = imgURL;
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

    public String getImgURL() {
        return imgURL;
    }
    @Override
    public boolean equals(Object obj) {
        return obj instanceof Item && ((Item) obj).getName().equals(name);
    }
}

