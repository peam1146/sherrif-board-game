package com.progmeth.project.sheriff.presentors.game.controllers;

import com.progmeth.project.sheriff.core.utils.view.controllers.StateController;
import com.progmeth.project.sheriff.presentors.game.controllers.states.GameState;

/**
 * Game controller
 */
public class GameController extends StateController<GameState> {
    /**
     * Constructor
     */
    public GameController() {
        super(new GameState(0));
    }

    /**
     * increment value
     */
    public void increment() {
        setState(new GameState(getState().getCount() + 10));
    }

    /**
     * decrement value
     */
    public void decrement() {
        setState(new GameState(getState().getCount() - 10));
    }
}
