package com.progmeth.project.sheriff.domain.game.repositories;

import io.reactivex.rxjava3.core.Completable;

public interface RoomRepository {
    public Completable joinGame(String host);

    public Completable createRoom(String room, int tcpPort);
}
