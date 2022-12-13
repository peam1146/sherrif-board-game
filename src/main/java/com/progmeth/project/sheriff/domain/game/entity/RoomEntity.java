package com.progmeth.project.sheriff.domain.game.entity;

import java.net.InetAddress;

public class RoomEntity {
    private final String name;
    private final InetAddress address;

    public RoomEntity(String name, InetAddress address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public InetAddress getAddress() {
        return address;
    }
}
