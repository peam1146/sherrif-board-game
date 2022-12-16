package com.progmeth.project.sheriff.domain.game.entity;

/**
 * Verify item entity
 */
public class VerifyItemEntity {
    /**
     * player name
     */
    private final String playerName;
    /**
     * item name
     */
    private final String itemName;
    /**
     * amount of item
     */
    private final int amount;

    /**
     * Constructor
     * @param playerName player name
     * @param itemName item name
     * @param amount amount
     */
    public VerifyItemEntity(String playerName, String itemName, int amount) {
        this.playerName = playerName;
        this.itemName = itemName;
        this.amount = amount;
    }

    /**
     * get player name
     * @return player name
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * get item name
     * @return item name
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * get amount
     * @return amount
     */
    public int getAmount() {
        return amount;
    }
}
