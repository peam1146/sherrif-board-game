package com.progmeth.project.sheriff.data.game.models.derive.market;

import com.progmeth.project.sheriff.data.game.models.base.Illegal;
import com.progmeth.project.sheriff.data.game.models.base.Item;
import com.progmeth.project.sheriff.data.game.models.base.Legal;
import com.progmeth.project.sheriff.data.game.models.derive.legal.Apple;
import com.progmeth.project.sheriff.data.game.models.derive.legal.Bread;
import com.progmeth.project.sheriff.data.game.models.derive.legal.Cheese;
import com.progmeth.project.sheriff.data.game.models.derive.legal.Chicken;

import java.util.ArrayList;

/**
 * Market
 */
public class Market {
    /**
     * list of illegal items
     */
    private final ArrayList<Illegal> illegalItems = new ArrayList<>();
    /**
     * apple count
     */
    private int AppleCount = 0;
    /**
     * bread count
     */
    private int BreadCount = 0;
    /**
     * cheese count
     */
    private int CheeseCount = 0;
    /**
     * chicken count
     */
    private int ChickenCount = 0;

    /**
     * Constructor
     */
    public Market() {
    }

    /**
     * add illegal item to market
     *
     * @param item illegal item
     */
    public void addIllegalItem(Illegal item) {
        illegalItems.add(item);
    }

    /**
     * add legal item to market
     *
     * @param item legal item
     */
    public void addLegalItem(Item item) {
        if (!(item instanceof Legal)) return;
        switch (item.getName()) {
            case "Apple" -> AppleCount++;
            case "Bread" -> BreadCount++;
            case "Cheese" -> CheeseCount++;
            case "Chicken" -> ChickenCount++;
        }
    }

    /**
     * add item to market
     *
     * @param item item
     */
    public void add(Item item) {
        if (item instanceof Legal) {
            addLegalItem(item);
            return;
        }
        addIllegalItem((Illegal) item);
    }


    /**
     * get chicken count
     *
     * @return chicken count
     */
    public int getChickenCount() {
        return ChickenCount;
    }

    /**
     * get illegal items
     *
     * @return illegal items
     */
    public ArrayList<Illegal> getIllegalItems() {
        return illegalItems;
    }

    /**
     * get apple count
     *
     * @return apple count
     */
    public int getAppleCount() {
        return AppleCount;
    }

    /**
     * get bread count
     *
     * @return bread count
     */
    public int getBreadCount() {
        return BreadCount;
    }

    /**
     * get cheese count
     *
     * @return cheese count
     */
    public int getCheeseCount() {
        return CheeseCount;
    }

    /**
     * get score
     *
     * @return score
     */
    public int getScore() {
        int score = 0;
        for (Illegal item : illegalItems) {
            score += ((Item) item).getPrice();
        }
        score += AppleCount * Apple.getInstance().getPrice();
        score += BreadCount * Bread.getInstance().getPrice();
        score += CheeseCount * Cheese.getInstance().getPrice();
        score += ChickenCount * Chicken.getInstance().getPrice();
        return score;
    }
}
