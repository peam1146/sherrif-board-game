package com.progmeth.project.sheriff.data.game.models.derive.illegal;

import com.progmeth.project.sheriff.data.game.models.base.Illegal;
import com.progmeth.project.sheriff.data.game.models.base.Item;
import com.progmeth.project.sheriff.presentors.common.ItemImg;

/**
 * Dedder item
 */
public class Dedder extends Item implements Illegal {

    /**
     * Dedder instance
     */
    public static Dedder instance = new Dedder();

    /**
     * time fine
     */
    final static int FINE = 4;
    public final static String ImgURL = ItemImg.DEDDER;


    /**
     * Constructor
     */
    private Dedder() {
        super(6, "Dedder",ImgURL);
    }


    /**
     * Get instance
     *
     * @return instance
     */
    public static Dedder getInstance() {
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
