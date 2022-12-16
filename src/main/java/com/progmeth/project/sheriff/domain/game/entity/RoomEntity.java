package com.progmeth.project.sheriff.domain.game.entity;

import java.net.InetAddress;

/**
 * Room entity
 */
public class RoomEntity {
    /**
     * Room name
     */
    private final String name;
    /**
     * Room host
     */
    private final InetAddress address;

    /**
     * Constructor
     * @param name room name
     * @param address room host
     */
    public RoomEntity(String name, InetAddress address) {
        this.name = name;
        this.address = address;
    }

    /**
     * Get room name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Get room host
     * @return host
     */
    public InetAddress getAddress() {
        return address;
    }
}
