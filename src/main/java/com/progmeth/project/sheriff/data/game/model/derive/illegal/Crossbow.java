package com.progmeth.project.sheriff.data.game.model.derive.illegal;

import com.progmeth.project.sheriff.data.game.model.base.Illegal;
import com.progmeth.project.sheriff.data.game.model.base.Item;

public class Crossbow extends Item implements Illegal {
    public static Crossbow instance = new Crossbow();
    final static int FINE = 4;

    private Crossbow() {
        super(9, "Crossbow");
    }

    public static Crossbow getInstance() {
        return instance;
    }

    @Override
    public int getFine() {
        return FINE;
    }
}