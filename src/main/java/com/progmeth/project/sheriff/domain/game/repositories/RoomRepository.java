package com.progmeth.project.sheriff.domain.game.repositories;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;

import java.util.ArrayList;

public interface RoomRepository {
    public Completable startGame();

    public Single<ArrayList<String>> joinGame(String host, String name);

    public Single<ArrayList<String>> getPlayers();

    public Completable createRoom(String room, int tcpPort);

    public Single<Boolean> isGameStart();

    public Single<Integer> getCurrentSheriff();
}
