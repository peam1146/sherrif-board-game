package com.progmeth.project.sheriff.domain.game.repositories;

import com.progmeth.project.sheriff.data.game.entity.base.Item;

import java.util.concurrent.Future;

public abstract class DroppedDeckRepository {

    abstract public Future<Item> getTop();

    abstract public Future<Item> draw();
}
