package com.progmeth.project.sheriff.data.game.models.derive.legal;

import com.progmeth.project.sheriff.data.game.models.base.Item;
import com.progmeth.project.sheriff.data.game.models.base.Legal;
import com.progmeth.project.sheriff.presentors.common.ItemImg;

public class Chicken extends Item implements Legal {
    public static Chicken instance = new Chicken();
    final static int TIME_COST = 2;
    public final static String ImgURL = ItemImg.CHICKEN;

    private Chicken() {
        super(4, "Chicken",ImgURL);
    }

    public static Chicken getInstance() {
        return instance;
    }

    @Override
    public int getTimeCost() {
        return TIME_COST;
    }
}
