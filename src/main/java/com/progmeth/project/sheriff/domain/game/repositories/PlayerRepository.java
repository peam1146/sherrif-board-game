package com.progmeth.project.sheriff.domain.game.repositories;

import io.reactivex.rxjava3.core.Single;

import java.util.ArrayList;

/**
 * Player repository
 */
public interface PlayerRepository {
    /**
     * Get player list
     * @return player list
     */
    public Single<ArrayList<String>> getPlayerNames();

    /**
     * get player name
     * @return player name
     */
    public Single<String> getMyName();

    /**
     * get player money
     * @return player money
     */
    public Single<Integer> getMyMoney();

    /**
     * get players money
     * @return players money
     */
    public Single<ArrayList<Integer>> getPlayerMoney();
}
