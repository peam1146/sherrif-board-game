package com.progmeth.project.sheriff.home.controllers.events;

public class StartClickedEvent extends HomeEvent {
    final int count;

    public StartClickedEvent(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof StartClickedEvent;
    }

    @Override
    public String toString() {
        return "StartClickedEvent";
    }
}