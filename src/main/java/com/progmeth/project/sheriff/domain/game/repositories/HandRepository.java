package com.progmeth.project.sheriff.domain.game.repositories;

import com.progmeth.project.sheriff.domain.game.entity.ItemEntity;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;

import java.util.ArrayList;

/**
 * Hand repository
 */
public interface HandRepository {
    /**
     * get hand
     * @return hand
     */
    public Single<ArrayList<ItemEntity>> getHand();

    /**
     * draw card
     * @return hand
     */
    public Single<ArrayList<ItemEntity>> draw();

    /**
     * discard card
     * @param item card
     * @return hand
     */
    public Single<ArrayList<ItemEntity>> drop(ItemEntity item);

    /**
     * discard all card
     *
     * @return done
     */
    public Completable dropAll();
}
