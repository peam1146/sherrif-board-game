package com.progmeth.project.sheriff.data.game.models.derive.illegal;

import com.progmeth.project.sheriff.data.game.models.base.Illegal;
import com.progmeth.project.sheriff.data.game.models.base.Item;
import com.progmeth.project.sheriff.presentors.common.ItemImg;

public class RoyalRooster extends Item implements Illegal {

    public static RoyalRooster instance = new RoyalRooster();
    final static int FINE = 4;
    public final static String ImgURL = ItemImg.ROYALROOSTER;

    private RoyalRooster() {
        super(8, "Royal Rooster",ImgURL);
    }

    public static RoyalRooster getInstance() {
        return instance;
    }

    @Override
    public int getFine() {
        return FINE;
    }
}
