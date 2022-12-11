package com.progmeth.project.sheriff.domain.game.entity;

public class VerifyItemEntity {
    private final String playerName;
    private final String itemName;
    private final int amount;
    public VerifyItemEntity(String playerName, String itemName, int amount) {
        this.playerName = playerName;
        this.itemName = itemName;
        this.amount = amount;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getItemName() {
        return itemName;
    }

    public int getAmount() {
        return amount;
    }
}
