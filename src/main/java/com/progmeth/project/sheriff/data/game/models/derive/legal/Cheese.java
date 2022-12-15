package com.progmeth.project.sheriff.data.game.models.derive.legal;

import com.progmeth.project.sheriff.data.game.models.base.Item;
import com.progmeth.project.sheriff.data.game.models.base.Legal;

/**
 * Cheese item
 */
public class Cheese extends Item implements Legal {

    /**
     * Cheese instance
     */
    public static Cheese instance = new Cheese();

    /**
     * time cost
     */
    final static int TIME_COST = 2;

    /**
     * Constructor
     */
    private Cheese() {
        super(2, "Cheese");
    }

    /**
     * Get instance
     *
     * @return instance
     */
    public static Cheese getInstance() {
        return instance;
    }

    /**
     * Get time cost
     *
     * @return time cost
     */
    @Override
    public int getTimeCost() {
        return TIME_COST;
    }
}
