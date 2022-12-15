package com.progmeth.project.sheriff.domain.game.repositories;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;

import java.util.ArrayList;

/**
 * Room repository
 */
public interface RoomRepository {
    /**
     * start game
     *
     * @return completable
     */
    public Completable startGame();

    /**
     * join room
     *
     * @param host host
     * @param name player name
     * @return result
     */
    public Single<ArrayList<String>> joinGame(String host, String name);

    /**
     * get players
     *
     * @return players
     */
    public Single<ArrayList<String>> getPlayers();

    /**
     * create room
     *
     * @param room    room name
     * @param tcpPort port
     * @return Completable
     */
    public Completable createRoom(String room, int tcpPort);
}
