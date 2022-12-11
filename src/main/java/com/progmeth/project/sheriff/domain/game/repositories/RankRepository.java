package com.progmeth.project.sheriff.domain.game.repositories;

import io.reactivex.rxjava3.core.Single;

public interface RankRepository {
    public Single<String[]> getRank();
}
