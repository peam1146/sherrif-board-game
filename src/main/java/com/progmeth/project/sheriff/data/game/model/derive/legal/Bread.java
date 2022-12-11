package com.progmeth.project.sheriff.data.game.model.derive.legal;


import com.progmeth.project.sheriff.data.game.model.base.Item;
import com.progmeth.project.sheriff.data.game.model.base.Legal;

public class Bread extends Item implements Legal {
    public static Bread instance = new Bread();
    final static int TIME_COST = 2;

    private Bread() {
        super(3, "Bread");
    }

    public static Bread getInstance() {
        return instance;
    }

    @Override
    public int getTimeCost() {
        return TIME_COST;
    }
}
