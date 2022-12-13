package com.progmeth.project.sheriff.domain.game.repositories;

import io.reactivex.rxjava3.core.Single;

import java.util.ArrayList;

public interface RankRepository {
    public Single<ArrayList<String>> getRank();
}
