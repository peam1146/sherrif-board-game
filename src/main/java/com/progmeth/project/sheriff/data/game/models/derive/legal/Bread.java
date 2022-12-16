package com.progmeth.project.sheriff.data.game.models.derive.legal;


import com.progmeth.project.sheriff.data.game.models.base.Item;
import com.progmeth.project.sheriff.data.game.models.base.Legal;
import com.progmeth.project.sheriff.presentors.common.ItemImg;

public class Bread extends Item implements Legal {
    public static Bread instance = new Bread();
    final static int TIME_COST = 2;
    public final static String ImgURL = ItemImg.BREAD;

    private Bread() {
        super(3, "Bread",ImgURL);
    }

    public static Bread getInstance() {
        return instance;
    }

    @Override
    public int getTimeCost() {
        return TIME_COST;
    }
}
