package com.progmeth.project.sheriff.data.game.models.derive.illegal;

import com.progmeth.project.sheriff.data.game.models.base.Illegal;
import com.progmeth.project.sheriff.data.game.models.base.Item;
import com.progmeth.project.sheriff.presentors.common.ItemImg;

public class Crossbow extends Item implements Illegal {
    public static Crossbow instance = new Crossbow();
    final static int FINE = 4;
    public final static String ImgURL = ItemImg.CROSSBOW;

    private Crossbow() {
        super(9, "Crossbow", ImgURL);
    }

    public static Crossbow getInstance() {
        return instance;
    }

    @Override
    public int getFine() {
        return FINE;
    }
}
