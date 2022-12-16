package com.progmeth.project.sheriff.data.game.models.derive.illegal;

import com.progmeth.project.sheriff.data.game.models.base.Illegal;
import com.progmeth.project.sheriff.data.game.models.base.Item;
import com.progmeth.project.sheriff.presentors.common.ItemImg;

public class Dedder extends Item implements Illegal {
    public static Dedder instance = new Dedder();
    final static int FINE = 4;
    public final static String ImgURL = ItemImg.DEDDER;

    private Dedder() {
        super(6, "Dedder",ImgURL);
    }

    public static Dedder getInstance() {
        return instance;
    }

    @Override
    public int getFine() {
        return FINE;
    }
}
