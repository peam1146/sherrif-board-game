package com.progmeth.project.sheriff.data.game.model.derive.illegal;

import com.progmeth.project.sheriff.data.game.model.base.Illegal;
import com.progmeth.project.sheriff.data.game.model.base.Item;

public class Dedder extends Item implements Illegal {
    public static Dedder instance = new Dedder();
    final static int FINE = 4;

    private Dedder() {
        super(6, "Dedder");
    }

    public static Dedder getInstance() {
        return instance;
    }

    @Override
    public int getFine() {
        return FINE;
    }
}
