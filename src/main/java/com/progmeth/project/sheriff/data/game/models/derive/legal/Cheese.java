package com.progmeth.project.sheriff.data.game.models.derive.legal;

import com.progmeth.project.sheriff.data.game.models.base.Item;
import com.progmeth.project.sheriff.data.game.models.base.Legal;
import com.progmeth.project.sheriff.presentors.common.ItemImg;

public class Cheese extends Item implements Legal {
    public static Cheese instance = new Cheese();
    final static int TIME_COST = 2;
    public final static String ImgURL = ItemImg.CHEESE;

    private Cheese() {
        super(2, "Cheese",ImgURL);
    }

    public static Cheese getInstance() {
        return instance;
    }

    @Override
    public int getTimeCost() {
        return TIME_COST;
    }
}
