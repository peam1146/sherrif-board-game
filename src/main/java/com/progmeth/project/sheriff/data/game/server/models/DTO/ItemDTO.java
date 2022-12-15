package com.progmeth.project.sheriff.data.game.server.models.DTO;

import com.progmeth.project.sheriff.domain.game.entity.ItemEntity;

import java.util.ArrayList;

/**
 * Item DTO
 */
public class ItemDTO {
    /**
     * Item price
     */
    public int price;
    /**
     * Item name
     */
    public String name;
    /**
     * Item type
     */
    public boolean isLegal;
    /**
     * time cost
     */
    public int timeCost;
    /**
     * fine
     */
    public int fine;

    /**
     * Constructor
     */
    public ItemDTO() {
    }

    /**
     * Class Builder
     */
    public static class Builder {
        /**
         * Item price
         */
        private int price;
        /**
         * Item name
         */
        private String name;
        /**
         * Item type
         */
        private boolean isLegal;
        /**
         * time cost
         */
        private int timeCost;
        /**
         * fine
         */
        private int fine;

        /**
         * Constructor
         */
        public Builder() {
        }

        /**
         * set price
         *
         * @param price price
         * @return builder
         */
        public Builder setPrice(int price) {
            this.price = price;
            return this;
        }

        /**
         * set name
         *
         * @param name name
         * @return builder
         */
        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        /**
         * set isLegal
         *
         * @param isLegal isLegal
         * @return builder
         */
        public Builder setIsLegal(boolean isLegal) {
            this.isLegal = isLegal;
            return this;
        }

        /**
         * set timeCost
         *
         * @param timeCost timeCost
         * @return builder
         */
        public Builder setTimeCost(int timeCost) {
            this.timeCost = timeCost;
            return this;
        }

        /**
         * set fine
         *
         * @param fine fine
         * @return builder
         */
        public Builder setFine(int fine) {
            this.fine = fine;
            return this;
        }

        /**
         * build
         *
         * @return ItemDTO
         */
        public ItemDTO build() {
            ItemDTO dto = new ItemDTO();
            dto.price = price;
            dto.name = name;
            dto.isLegal = isLegal;
            dto.timeCost = timeCost;
            dto.fine = fine;
            return dto;
        }
    }

    /**
     * Convert to entity
     *
     * @param dtos dtos
     * @return entities
     */
    public static ArrayList<ItemEntity> toEntity(ArrayList<ItemDTO> dtos) {
        ArrayList<ItemEntity> res = new ArrayList<>();
        for (ItemDTO dto : dtos) {
            res.add(new ItemEntity.Builder().setName(dto.name).setPrice(dto.price).setIsLegal(dto.isLegal).setTimeCost(dto.timeCost).setFine(dto.fine).build());
        }
        return res;
    }
}
