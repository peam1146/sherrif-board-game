package com.progmeth.project.sheriff.usecases.game.logic.entity.derive.illegal;

import com.progmeth.project.sheriff.usecases.game.logic.entity.base.Illegal;
import com.progmeth.project.sheriff.usecases.game.logic.entity.base.Item;

public class RoyalRooster extends Item implements Illegal {

    final static int FINE = 4;

    public RoyalRooster() {
        super(8, "Royal Rooster");
    }

    @Override
    public int getFine() {
        return FINE;
    }
}
