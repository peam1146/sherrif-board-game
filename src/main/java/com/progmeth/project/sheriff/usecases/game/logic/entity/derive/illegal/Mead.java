package com.progmeth.project.sheriff.usecases.game.logic.entity.derive.illegal;

import com.progmeth.project.sheriff.usecases.game.logic.entity.base.Illegal;
import com.progmeth.project.sheriff.usecases.game.logic.entity.base.Item;

public class Mead extends Item implements Illegal {

    final static int FINE = 2;

    public Mead() {
        super(7, "Mead");
    }

    @Override
    public int getFine() {
        return FINE;
    }
}
