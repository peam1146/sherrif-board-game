package com.progmeth.project.sheriff.domain.game.repositories;

import com.progmeth.project.sheriff.domain.game.entity.ItemEntity;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;

import java.util.ArrayList;

public interface HandRepository {
    public Single<ArrayList<ItemEntity>> getHand();

    Single<ArrayList<ItemEntity>> draw(int n);

    public Single<ArrayList<ItemEntity>> drop(ItemEntity item);

    public Completable dropAll();

    public Single<Boolean> getIsDropable();
}
