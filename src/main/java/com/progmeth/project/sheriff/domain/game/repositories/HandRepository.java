package com.progmeth.project.sheriff.domain.game.repositories;

import com.progmeth.project.sheriff.domain.game.entity.ItemEntity;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;

import java.util.ArrayList;

public interface HandRepository {
    public Single<ArrayList<ItemEntity>> getHand();

    public Single<ArrayList<ItemEntity>> draw();

    public Single<ArrayList<ItemEntity>> drop(ItemEntity item);

    public Completable dropAll();
}
