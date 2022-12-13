package com.progmeth.project.sheriff.data.game.models.derive.illegal;

import com.progmeth.project.sheriff.data.game.models.base.Illegal;
import com.progmeth.project.sheriff.data.game.models.base.Item;

public class Mead extends Item implements Illegal {

    public static Mead instance = new Mead();
    final static int FINE = 2;

    private Mead() {
        super(7, "Mead");
    }

    public static Mead getInstance() {
        return instance;
    }

    @Override
    public int getFine() {
        return FINE;
    }
}