package com.progmeth.project.sheriff.data.game.entity.derive.legal;

import com.progmeth.project.sheriff.data.game.entity.base.Item;
import com.progmeth.project.sheriff.data.game.entity.base.Legal;

public class Apple extends Item implements Legal {
    public static Apple instance = new Apple();
    final static int TIME_COST = 2;

    private Apple() {
        super(2, "Apple");
    }

    public static Apple getInstance() {
        return instance;
    }
    @Override
    public int getTimeCost() {
        return TIME_COST;
    }
}