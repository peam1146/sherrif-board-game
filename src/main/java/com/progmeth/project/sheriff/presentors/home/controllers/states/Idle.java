package com.progmeth.project.sheriff.presentors.home.controllers.states;

/**
 * Idle state
 */
public class Idle extends HomeState {
    /**
     * count
     */
    final int count;

    /**
     * Constructor
     * @param count count
     */
    public Idle(int count) {
        this.count = count;
    }

    /**
     * get count
     * @return count
     */
    public int getCount() {
        return count;
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof Idle;
    }

    @Override
    public String toString() {
        return "Idle";
    }
}
