package com.progmeth.project.sheriff.home.controllers.states;

public class Init extends HomeState {
    @Override
    public boolean equals(Object other) {
        return other instanceof Init;
    }

    @Override
    public String toString() {
        return "Init";
    }
}
