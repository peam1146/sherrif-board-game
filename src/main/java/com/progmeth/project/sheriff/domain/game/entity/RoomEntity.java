package com.progmeth.project.sheriff.domain.game.entity;

public class RoomEntity {
    private final String name;
    private final String url;

    public RoomEntity(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
}
