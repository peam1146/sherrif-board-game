package com.progmeth.project.sheriff.presentors.home.controllers.states;

public class Idle extends HomeState {
    final int count;

    public Idle(int count) {
        this.count = count;
    }

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
