package com.progmeth.project.sheriff.data.game.entity.derive.market;

import com.progmeth.project.sheriff.data.game.entity.base.Illegal;
import com.progmeth.project.sheriff.data.game.entity.base.Item;
import com.progmeth.project.sheriff.data.game.entity.base.Legal;
import com.progmeth.project.sheriff.data.game.entity.derive.legal.Apple;
import com.progmeth.project.sheriff.data.game.entity.derive.legal.Bread;
import com.progmeth.project.sheriff.data.game.entity.derive.legal.Cheese;
import com.progmeth.project.sheriff.data.game.entity.derive.legal.Chicken;

import java.util.ArrayList;

public class Market {
    private final ArrayList<Illegal> illegalItems = new ArrayList<>();
    private int AppleCount = 0;
    private int BreadCount = 0;
    private int CheeseCount = 0;
    private int ChickenCount = 0;

    public void addIllegalItem(Illegal item) {
        illegalItems.add(item);
    }

    public void addLegalItem(Item item) {
        if (!(item instanceof Legal)) return;
        switch (item.getName()) {
            case "Apple" -> AppleCount++;
            case "Bread" -> BreadCount++;
            case "Cheese" -> CheeseCount++;
            case "Chicken" -> ChickenCount++;
        }
    }


    public int getChickenCount() {
        return ChickenCount;
    }

    public ArrayList<Illegal> getIllegalItems() {
        return illegalItems;
    }

    public int getAppleCount() {
        return AppleCount;
    }

    public int getBreadCount() {
        return BreadCount;
    }

    public int getCheeseCount() {
        return CheeseCount;
    }

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
