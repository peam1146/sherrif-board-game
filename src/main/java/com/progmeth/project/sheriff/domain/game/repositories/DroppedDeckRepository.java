package com.progmeth.project.sheriff.domain.game.repositories;

import com.progmeth.project.sheriff.data.game.entity.base.Item;
import io.reactivex.rxjava3.core.Single;


public interface DroppedDeckRepository {
    public Single<Item> getTop();

    public Single<Item> draw();
}
