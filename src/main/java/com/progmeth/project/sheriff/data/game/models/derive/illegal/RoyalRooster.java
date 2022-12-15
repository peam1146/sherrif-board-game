package com.progmeth.project.sheriff.data.game.models.derive.illegal;

import com.progmeth.project.sheriff.data.game.models.base.Illegal;
import com.progmeth.project.sheriff.data.game.models.base.Item;

/**
 * Royal Rooster
 */
public class RoyalRooster extends Item implements Illegal {

    /**
     * instance
     */
    public static RoyalRooster instance = new RoyalRooster();
    /**
     * fine
     */
    final static int FINE = 4;

    /**
     * Constructor
     */
    private RoyalRooster() {
        super(8, "Royal Rooster");
    }

    /**
     * instance getter
     *
     * @return instance
     */
    public static RoyalRooster getInstance() {
        return instance;
    }

    @Override
    public int getFine() {
        return FINE;
    }
}
