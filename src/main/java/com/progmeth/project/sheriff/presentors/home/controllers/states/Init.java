package com.progmeth.project.sheriff.presentors.home.controllers.states;

/**
 * Init state
 */
public class Init extends HomeState {
    /**
     * Constructor
     */
    public Init() {}
    @Override
    public boolean equals(Object other) {
        return other instanceof Init;
    }

    @Override
    public String toString() {
        return "Init";
    }
}
