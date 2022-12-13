package com.progmeth.project.sheriff.data.game.server.models.DTO;

public class ItemDTO {
    public String imgURL;
    public int price;
    public String name;
    public boolean isLegal;
    public int timeCost;
    public int fine;

    public static class Builder {
        private String imgURL;
        private int price;
        private String name;
        private boolean isLegal;
        private int timeCost;
        private int fine;

        public Builder setImaURL(String imgURL) {
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

        public ItemDTO build() {
            ItemDTO dto = new ItemDTO();
            dto.imgURL = imgURL;
            dto.price = price;
            dto.name = name;
            dto.isLegal = isLegal;
            dto.timeCost = timeCost;
            dto.fine = fine;
            return dto;
        }
    }
}
