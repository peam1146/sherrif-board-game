package com.progmeth.project.sheriff.data.game.entity.derive.legal;

import com.progmeth.project.sheriff.data.game.entity.base.Item;
import com.progmeth.project.sheriff.data.game.entity.base.Legal;

public class Cheese extends Item implements Legal {
    public static Cheese instance = new Cheese();
    final static int TIME_COST = 2;

    private Cheese() {
        super(2, "Cheese");
    }

    public static Cheese getInstance() {
        return instance;
    }

    @Override
    public int getTimeCost() {
        return TIME_COST;
    }
}
