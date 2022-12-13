package com.progmeth.project.sheriff.domain.game.entity;

public class ItemEntity {

    final String imgURL;
    final int price;
    final String name;
    final boolean isLegal;
    final int timeCost;
    final int fine;

    public ItemEntity(int price, String name, boolean isLegal, int timeCost, int fine, String imgURL) {
        this.price = price;
        this.name = name;
        this.isLegal = isLegal;
        this.timeCost = timeCost;
        this.fine = fine;
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

    @Override
    public boolean equals(Object obj) {
        return obj instanceof ItemEntity && ((ItemEntity) obj).getName().equals(name);
    }

    public boolean isLegal() {
        return isLegal;
    }

    public int getTimeCost() {
        return timeCost;
    }

    public int getFine() {
        return fine;
    }

    public String getImgURL() {
        return imgURL;
    }
}

