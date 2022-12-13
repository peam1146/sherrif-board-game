package com.progmeth.project.sheriff.domain.game.repositories;

import io.reactivex.rxjava3.core.Single;

import java.util.ArrayList;

public interface PlayerRepository {
    public Single<ArrayList<String>> getPlayerNames();

    public Single<String> getMyName();

    public Single<Integer> getMyMoney();

    public Single<ArrayList<Integer>> getPlayerMoney();
}
