package com.progmeth.project.sheriff.usecases.game.logic.entity.derive.legal;


import com.progmeth.project.sheriff.usecases.game.logic.entity.base.Legal;
import com.progmeth.project.sheriff.usecases.game.logic.entity.base.Item;

public class Bread extends Item implements Legal {
    final static int TIME_COST = 2;

    public Bread() {
        super(3, "Bread");
    }

    @Override
    public int getTimeCost() {
        return TIME_COST;
    }
}
