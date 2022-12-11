package com.progmeth.project.sheriff.data.game.models.derive.illegal;

import com.progmeth.project.sheriff.data.game.models.base.Illegal;
import com.progmeth.project.sheriff.data.game.models.base.Item;

public class RoyalRooster extends Item implements Illegal {

    public static RoyalRooster instance = new RoyalRooster();
    final static int FINE = 4;

    private RoyalRooster() {
        super(8, "Royal Rooster");
    }

    public static RoyalRooster getInstance() {
        return instance;
    }

    @Override
    public int getFine() {
        return FINE;
    }
}
