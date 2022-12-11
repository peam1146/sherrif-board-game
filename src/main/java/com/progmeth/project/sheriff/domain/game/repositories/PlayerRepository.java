package com.progmeth.project.sheriff.domain.game.repositories;

import io.reactivex.rxjava3.core.Single;

public interface PlayerRepository {
    public Single<String[]> getPlayerNames();

    public Single<String> getMyName();

    public Single<Integer> getMyMoney();

    public Single<Integer[]> getPlayerMoney();
}
