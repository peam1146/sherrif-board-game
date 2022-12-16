package com.progmeth.project.sheriff.data.game.server.repositories;

import com.progmeth.project.sheriff.data.game.models.base.Item;
import com.progmeth.project.sheriff.data.game.server.controller.DroppedDeckPos;
import com.progmeth.project.sheriff.data.game.server.models.DTO.ItemDTO;
import com.progmeth.project.sheriff.data.game.server.models.response.GetDroppedDeckTopResponse;
import com.progmeth.project.sheriff.data.game.server.models.response.GetHandResponse;
import com.progmeth.project.sheriff.data.game.server.network.RoomClient;
import com.progmeth.project.sheriff.domain.game.entity.ItemEntity;
import com.progmeth.project.sheriff.domain.game.repositories.DroppedDeckRepository;
import io.reactivex.rxjava3.core.Single;

public class DroppedDeckRepositoryImpl implements DroppedDeckRepository {
    @Override
    public Single<ItemDTO[]> getTop() {
        return Single.create(emitter -> {
            RoomClient.getInstance().getResponseSubject().subscribe(response -> {
                if (response instanceof final GetDroppedDeckTopResponse res) {
                    ItemDTO[] droppedDeck = new ItemDTO[2];
                    droppedDeck[0] = res.bottomDroppedDeckTop;
                    droppedDeck[1] = res.topDroppedDeckTop;
                    emitter.onSuccess(droppedDeck);
                }
            });
            RoomClient.getInstance().getDroppedDeckTop();
        });
    }
    @Override
    public Single<Item> draw(DroppedDeckPos pos) {
        return null;
    }

}

