package com.progmeth.project.sheriff.usecases.game.logic.entity.derive.illegal;

import com.progmeth.project.sheriff.usecases.game.logic.entity.base.Illegal;
import com.progmeth.project.sheriff.usecases.game.logic.entity.base.Item;

public class Dedder extends Item implements Illegal {
    final static int FINE = 4;

    public Dedder() {
        super(6, "Dedder");
    }

    @Override
    public int getFine() {
        return FINE;
    }
}
