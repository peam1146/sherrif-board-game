package com.progmeth.project.sheriff.core.controllers.main.states;

public class InitState extends MainState {

    @Override
    public boolean equals(Object other) {
        return other instanceof InitState;
    }

    @Override
    public String toString() {
        return "GamePageState";
    }

}
