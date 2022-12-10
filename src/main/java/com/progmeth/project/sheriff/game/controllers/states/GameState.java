package com.progmeth.project.sheriff.game.controllers.states;

import com.progmeth.project.sheriff.core.utils.controllers.State;

public  class GameState implements State{
    final int count;
    public GameState(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }
}
