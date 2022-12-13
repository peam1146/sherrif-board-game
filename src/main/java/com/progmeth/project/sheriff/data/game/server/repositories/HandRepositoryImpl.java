package com.progmeth.project.sheriff.data.game.server.repositories;

import com.progmeth.project.sheriff.data.game.models.base.Item;
import com.progmeth.project.sheriff.domain.game.entity.ItemEntity;
import com.progmeth.project.sheriff.domain.game.repositories.HandRepository;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;

import java.util.ArrayList;

public class HandRepositoryImpl implements HandRepository {

    @Override
    public Single<ArrayList<ItemEntity>> getHand() {
        return null;
    }

    @Override
    public Single<ArrayList<ItemEntity>> draw() {
        return null;
    }

    @Override
    public Single<ArrayList<ItemEntity>> drop(Item item) {
        return null;
    }

    @Override
    public Completable dropAll() {
        return null;
    }
}
