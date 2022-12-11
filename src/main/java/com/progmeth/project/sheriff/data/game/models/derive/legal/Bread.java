package com.progmeth.project.sheriff.data.game.models.derive.legal;


import com.progmeth.project.sheriff.data.game.models.base.Item;
import com.progmeth.project.sheriff.data.game.models.base.Legal;

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
