package com.progmeth.project.sheriff.data.game.models.derive.illegal;

import com.progmeth.project.sheriff.data.game.models.base.Illegal;
import com.progmeth.project.sheriff.data.game.models.base.Item;
import com.progmeth.project.sheriff.presentors.common.ItemImg;

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
    public final static String ImgURL = ItemImg.CROSSBOW;

    /**
     * Constructor
     */
    private Crossbow() {
        super(9, "Crossbow", ImgURL);
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
