package com.progmeth.project.sheriff.data.game.models.derive.illegal;

import com.progmeth.project.sheriff.data.game.models.base.Illegal;
import com.progmeth.project.sheriff.data.game.models.base.Item;

/**
 * Crossbow item
 */
public class Crossbow extends Item implements Illegal {

    /**
     * Crossbow instance
     */
    public static Crossbow instance = new Crossbow();

    /**
     * time fine
     */
    final static int FINE = 4;

    /**
     * Constructor
     */
    private Crossbow() {
        super(9, "Crossbow");
    }

    /**
     * Get instance
     *
     * @return instance
     */
    public static Crossbow getInstance() {
        return instance;
    }

    /**
     * Get fine
     *
     * @return fine
     */
    @Override
    public int getFine() {
        return FINE;
    }
}
