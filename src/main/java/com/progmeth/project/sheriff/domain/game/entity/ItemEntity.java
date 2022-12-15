package com.progmeth.project.sheriff.domain.game.entity;

/**
 * Item Entity
 */
public class ItemEntity {

    /**
     * Item image url
     */
    final String imgURL;
    /**
     * Item price
     */
    final int price;
    /**
     * Item name
     */
    final String name;
    /**
     * Item type
     */
    final boolean isLegal;
    /**
     * time cost
     */
    final int timeCost;
    /**
     * fine
     */
    final int fine;

    /**
     * Constructor
     *
     * @param price    item price
     * @param name     item name
     * @param isLegal  item type
     * @param timeCost item time cost
     * @param fine     item fine
     * @param imgURL   item image url
     */
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

    /**
     * Get price
     *
     * @return price
     */
    public int getPrice() {
        return price;
    }

    /**
     * Get name
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof ItemEntity && ((ItemEntity) obj).getName().equals(name);
    }

    /**
     * Get item type
     *
     * @return item type
     */
    public boolean isLegal() {
        return isLegal;
    }

    /**
     * Get item time cost
     *
     * @return item time cost
     */
    public int getTimeCost() {
        return timeCost;
    }

    /**
     * Get item fine
     *
     * @return item fine
     */
    public int getFine() {
        return fine;
    }

    /**
     * Get item image url
     *
     * @return item image url
     */
    public String getImgURL() {
        return imgURL;
    }

    /**
     * Class Builder
     */
    public static class Builder {

        /**
         * Item image url
         */
        private String imgURL;
        /**
         * Item price
         */
        private int price;
        /**
         * Item name
         */
        private String name;
        /**
         * item type
         */
        private boolean isLegal = false;
        /**
         * time cost
         */
        private int timeCost = 0;
        /**
         * fine
         */
        private int fine = 0;

        /**
         * Constructor
         */
        public Builder() {
        }

        /**
         * Set item image url
         *
         * @param imgURL item image url
         * @return builder
         */
        public Builder setImgURL(String imgURL) {
            this.imgURL = imgURL;
            return this;
        }

        /**
         * set item price
         *
         * @param price item price
         * @return builder
         */
        public Builder setPrice(int price) {
            this.price = price;
            return this;
        }

        /**
         * set item name
         *
         * @param name name
         * @return builder
         */
        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        /**
         * set item type
         *
         * @param isLegal item type
         * @return builder
         */
        public Builder setIsLegal(boolean isLegal) {
            this.isLegal = isLegal;
            return this;
        }

        /**
         * set item time cost
         *
         * @param timeCost item time cost
         * @return builder
         */
        public Builder setTimeCost(int timeCost) {
            this.timeCost = timeCost;
            return this;
        }

        /**
         * set item fine
         *
         * @param fine item fine
         * @return builder
         */
        public Builder setFine(int fine) {
            this.fine = fine;
            return this;
        }

        /**
         * Build item entity
         *
         * @return item entity
         */
        public ItemEntity build() {
            return new ItemEntity(price, name, isLegal, timeCost, fine, imgURL);
        }
    }
}

