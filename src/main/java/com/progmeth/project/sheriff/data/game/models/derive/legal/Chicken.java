package com.progmeth.project.sheriff.data.game.models.derive.legal;

import com.progmeth.project.sheriff.data.game.models.base.Item;
import com.progmeth.project.sheriff.data.game.models.base.Legal;

/**
 * Chicken item
 */
public class Chicken extends Item implements Legal {

    /**
     * Chicken instance
     */
    public static Chicken instance = new Chicken();

    /**
     * time cost
     */
    final static int TIME_COST = 2;

    /**
     * Constructor
     */
    private Chicken() {
        super(4, "Chicken");
    }

    /**
     * Get instance
     *
     * @return instance
     */
    public static Chicken getInstance() {
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
