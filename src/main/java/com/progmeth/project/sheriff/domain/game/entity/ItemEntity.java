package com.progmeth.project.sheriff.domain.game.entity;

public class ItemEntity {

    String imgURL;
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
    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public static class Builder {

        private String imgURL;
        private int price;
        private String name;
        private boolean isLegal = false;
        private int timeCost = 0;
        private int fine = 0;

        public Builder setImgURL(String imgURL) {
            this.imgURL = imgURL;
            return this;
        }

        public Builder setPrice(int price) {
            this.price = price;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setIsLegal(boolean isLegal) {
            this.isLegal = isLegal;
            return this;
        }

        public Builder setTimeCost(int timeCost) {
            this.timeCost = timeCost;
            return this;
        }

        public Builder setFine(int fine) {
            this.fine = fine;
            return this;
        }

        public ItemEntity build() {
            return new ItemEntity(price, name, isLegal, timeCost, fine, imgURL);
        }
    }
}

