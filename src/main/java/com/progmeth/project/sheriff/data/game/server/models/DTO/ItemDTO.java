package com.progmeth.project.sheriff.data.game.server.models.DTO;

import com.progmeth.project.sheriff.domain.game.entity.ItemEntity;

import java.util.ArrayList;

public class ItemDTO {
    public int price;
    public String name;
    public boolean isLegal;
    public int timeCost;
    public int fine;

    public static class Builder {
        private int price;
        private String name;
        private boolean isLegal;
        private int timeCost;
        private int fine;

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

    public static ArrayList<ItemEntity> toEntity(ArrayList<ItemDTO> dtos) {
        ArrayList<ItemEntity> res = new ArrayList<>();
        for (ItemDTO dto : dtos) {
            res.add(new ItemEntity.Builder().setName(dto.name).setPrice(dto.price).setIsLegal(dto.isLegal).setTimeCost(dto.timeCost).setFine(dto.fine).build());
        }
        return res;
    }
}
