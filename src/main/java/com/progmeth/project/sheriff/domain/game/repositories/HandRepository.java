package com.progmeth.project.sheriff.domain.game.repositories;

import com.progmeth.project.sheriff.data.game.entity.base.Item;

import java.util.concurrent.Future;

public abstract class HandRepository {
    public abstract Future<Item[]> getHand();

    public abstract Future<Void> draw();

    public abstract Future<Void> drop(Item item);

    public abstract Future<Void> dropAll();
}
