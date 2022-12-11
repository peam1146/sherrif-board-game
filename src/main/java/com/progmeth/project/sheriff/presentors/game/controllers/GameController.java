package com.progmeth.project.sheriff.presentors.game.controllers;

import com.progmeth.project.sheriff.core.utils.view.controllers.StateController;
import com.progmeth.project.sheriff.presentors.game.controllers.states.GameState;

public class GameController extends StateController<GameState> {
    public GameController() {
        super(new GameState(0));
    }

    public void increment() {
        setState(new GameState(getState().getCount() + 10));
    }

    public void decrement() {
        setState(new GameState(getState().getCount() - 10));
    }
}
