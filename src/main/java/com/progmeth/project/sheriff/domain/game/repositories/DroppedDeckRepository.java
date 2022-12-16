package com.progmeth.project.sheriff.domain.game.repositories;

import com.progmeth.project.sheriff.data.game.models.base.Item;
import com.progmeth.project.sheriff.data.game.models.derive.deck.DroppedDeck;
import com.progmeth.project.sheriff.data.game.server.controller.DroppedDeckPos;
import com.progmeth.project.sheriff.data.game.server.models.DTO.ItemDTO;
import com.progmeth.project.sheriff.domain.game.entity.ItemEntity;
import io.reactivex.rxjava3.core.Single;


public interface DroppedDeckRepository {
    public Single<ItemDTO[]> getTop();

    public Single<Item> draw(DroppedDeckPos pos);
}
