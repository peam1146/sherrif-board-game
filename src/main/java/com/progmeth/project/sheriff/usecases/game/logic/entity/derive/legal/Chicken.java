package com.progmeth.project.sheriff.usecases.game.logic.entity.derive.legal;

import com.progmeth.project.sheriff.usecases.game.logic.entity.base.Item;
import com.progmeth.project.sheriff.usecases.game.logic.entity.base.Legal;

public class Chicken extends Item implements Legal {
    final static int TIME_COST = 2;

    public Chicken() {
        super(4, "Chicken");
    }

    @Override
    public int getTimeCost() {
        return TIME_COST;
    }
}
