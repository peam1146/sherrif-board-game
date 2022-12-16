package com.progmeth.project.sheriff.core.controllers.main.states;

/**
 * Init state
 */
public class InitState extends MainState {
    /**
     * Constructor
     */
    public InitState() {
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof InitState;
    }

    @Override
    public String toString() {
        return "GamePageState";
    }

}
