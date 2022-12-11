package com.progmeth.project.sheriff.data.game.entity.derive.legal;

import com.progmeth.project.sheriff.data.game.entity.base.Item;
import com.progmeth.project.sheriff.data.game.entity.base.Legal;

public class Chicken extends Item implements Legal {
    public static Chicken instance = new Chicken();
    final static int TIME_COST = 2;

    private Chicken() {
        super(4, "Chicken");
    }

    public static Chicken getInstance() {
        return instance;
    }

    @Override
    public int getTimeCost() {
        return TIME_COST;
    }
}
