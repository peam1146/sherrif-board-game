package com.progmeth.project.sheriff.domain.game.repositories;

import com.progmeth.project.sheriff.data.game.models.base.Item;
import io.reactivex.rxjava3.core.Single;

public interface HandRepository {
    public Single<Item[]> getHand();

    public Single<Void> draw();

    public Single<Void> drop(Item item);

    public Single<Void> dropAll();
}
