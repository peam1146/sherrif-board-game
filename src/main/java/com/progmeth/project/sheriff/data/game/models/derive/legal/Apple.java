package com.progmeth.project.sheriff.data.game.models.derive.legal;

import com.progmeth.project.sheriff.data.game.models.base.Item;
import com.progmeth.project.sheriff.data.game.models.base.Legal;
import com.progmeth.project.sheriff.presentors.common.ItemImg;

public class Apple extends Item implements Legal {
    public static Apple instance = new Apple();
    final static int TIME_COST = 2;
    public final static String ImgURL = ItemImg.APPLE;

    private Apple() {
        super(2, "Apple",ImgURL);
    }

    public static Apple getInstance() {
        return instance;
    }
    @Override
    public int getTimeCost() {
        return TIME_COST;
    }
}
