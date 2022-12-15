package com.progmeth.project.sheriff.data.game.models.derive.legal;


import com.progmeth.project.sheriff.data.game.models.base.Item;
import com.progmeth.project.sheriff.data.game.models.base.Legal;

/**
 * Bread item
 */
public class Bread extends Item implements Legal {
    /**
     * Bread instance
     */
    public static Bread instance = new Bread();

    /**
     * time cost
     */
    final static int TIME_COST = 2;

    /**
     * Constructor
     */
    private Bread() {
        super(3, "Bread");
    }

    /**
     * Get instance
     *
     * @return instance
     */
    public static Bread getInstance() {
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
