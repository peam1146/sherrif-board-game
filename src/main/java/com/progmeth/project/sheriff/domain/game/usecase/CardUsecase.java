package com.progmeth.project.sheriff.domain.game.usecase;

import com.progmeth.project.sheriff.data.game.entity.derive.illegal.Crossbow;
import com.progmeth.project.sheriff.data.game.entity.derive.illegal.Dedder;
import com.progmeth.project.sheriff.data.game.entity.derive.illegal.Mead;
import com.progmeth.project.sheriff.data.game.entity.derive.illegal.RoyalRooster;
import com.progmeth.project.sheriff.data.game.entity.derive.legal.Apple;
import com.progmeth.project.sheriff.data.game.entity.derive.legal.Bread;
import com.progmeth.project.sheriff.data.game.entity.derive.legal.Cheese;
import com.progmeth.project.sheriff.data.game.entity.derive.legal.Chicken;

public class CardUsecase {
    public Apple getApple() {
        return Apple.getInstance();
    }

    public Bread getBread() {
        return Bread.getInstance();
    }

    public Cheese getCheese() {
        return Cheese.getInstance();
    }

    public Chicken getChicken() {
        return Chicken.getInstance();
    }

    public Crossbow getCrossbow() {
        return Crossbow.getInstance();
    }

    public Dedder getDedder() {
        return Dedder.getInstance();
    }

    public Mead getMead() {
        return Mead.getInstance();
    }

    public RoyalRooster getRoyalRooster() {
        return RoyalRooster.getInstance();
    }
}
