package com.progmeth.project.sheriff.data.game.model.derive.legal;

import com.progmeth.project.sheriff.data.game.model.base.Item;
import com.progmeth.project.sheriff.data.game.model.base.Legal;

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
