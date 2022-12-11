package com.progmeth.project.sheriff.domain.game.usecase;

import com.progmeth.project.sheriff.data.game.models.derive.illegal.Crossbow;
import com.progmeth.project.sheriff.data.game.models.derive.illegal.Dedder;
import com.progmeth.project.sheriff.data.game.models.derive.illegal.Mead;
import com.progmeth.project.sheriff.data.game.models.derive.illegal.RoyalRooster;
import com.progmeth.project.sheriff.data.game.models.derive.legal.Apple;
import com.progmeth.project.sheriff.data.game.models.derive.legal.Bread;
import com.progmeth.project.sheriff.data.game.models.derive.legal.Cheese;
import com.progmeth.project.sheriff.data.game.models.derive.legal.Chicken;

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
