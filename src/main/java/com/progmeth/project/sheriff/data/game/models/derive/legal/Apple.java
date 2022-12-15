package com.progmeth.project.sheriff.data.game.models.derive.legal;

import com.progmeth.project.sheriff.data.game.models.base.Item;
import com.progmeth.project.sheriff.data.game.models.base.Legal;

/**
 * Apple item
 */
public class Apple extends Item implements Legal {
    /**
     * Apple instance
     */
    public static Apple instance = new Apple();

    /**
     * time cost
     */
    final static int TIME_COST = 2;

    /**
     * Constructor
     */
    private Apple() {
        super(2, "Apple");
    }

    /**
     * Get instance
     *
     * @return instance
     */
    public static Apple getInstance() {
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
