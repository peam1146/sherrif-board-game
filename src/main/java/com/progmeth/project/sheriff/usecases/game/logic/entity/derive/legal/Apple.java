package com.progmeth.project.sheriff.usecases.game.logic.entity.derive.legal;

import com.progmeth.project.sheriff.usecases.game.logic.entity.base.Item;
import com.progmeth.project.sheriff.usecases.game.logic.entity.base.Legal;

public class Apple extends Item implements Legal {
    final static int TIME_COST = 2;
    public Apple() {
        super(2, "Apple");
    }
    @Override
    public int getTimeCost() {
        return TIME_COST;
    }
}
