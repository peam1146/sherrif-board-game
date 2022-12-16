package com.progmeth.project.sheriff.data.game.models.derive.legal;

import com.progmeth.project.sheriff.data.game.models.base.Item;
import com.progmeth.project.sheriff.data.game.models.base.Legal;
import com.progmeth.project.sheriff.presentors.common.ItemImg;

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
    public final static String ImgURL = ItemImg.CHICKEN;

    /**
     * Constructor
     */
    private Chicken() {
        super(4, "Chicken",ImgURL);
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
