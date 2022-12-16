package com.progmeth.project.sheriff.domain.game.repositories;

import io.reactivex.rxjava3.core.Single;

import java.util.ArrayList;

/**
 * Rank repository
 */
public interface RankRepository {
    /**
     * Get rank list
     * @return rank list
     */
    public Single<ArrayList<String>> getRank();
}
