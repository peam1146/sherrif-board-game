package com.progmeth.project.sheriff.data.game.models.derive.legal;

import com.progmeth.project.sheriff.data.game.models.base.Item;
import com.progmeth.project.sheriff.data.game.models.base.Legal;
import com.progmeth.project.sheriff.presentors.common.ItemImg;

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
    public final static String ImgURL = ItemImg.APPLE;

    /**
     * Constructor
     */
    private Apple() {
        super(2, "Apple",ImgURL);
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
