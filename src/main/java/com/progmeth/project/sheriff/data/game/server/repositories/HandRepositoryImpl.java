package com.progmeth.project.sheriff.data.game.server.repositories;

import com.progmeth.project.sheriff.data.game.server.models.DTO.ItemDTO;
import com.progmeth.project.sheriff.data.game.server.models.response.DropAllCardsReponse;
import com.progmeth.project.sheriff.data.game.server.models.response.DropCardResponse;
import com.progmeth.project.sheriff.data.game.server.models.response.GetHandResponse;
import com.progmeth.project.sheriff.data.game.server.network.RoomClient;
import com.progmeth.project.sheriff.domain.game.entity.ItemEntity;
import com.progmeth.project.sheriff.domain.game.repositories.HandRepository;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;

import java.util.ArrayList;

public class HandRepositoryImpl implements HandRepository {

    @Override
    public Single<ArrayList<ItemEntity>> getHand() {
        return Single.create(emitter -> {
            RoomClient.getInstance().getResponseSubject().subscribe(response -> {
                if (response instanceof final GetHandResponse res) {
                    emitter.onSuccess(ItemDTO.toEntity(res.hand));
                }
            });
            RoomClient.getInstance().getHand();
        });
    }

    @Override
    public Single<ArrayList<ItemEntity>> draw() {
        return null;
    }

    @Override
    public Single<ArrayList<ItemEntity>> drop(ItemEntity item) {
        return Single.create(emitter -> {
            emitter.setDisposable(RoomClient.getInstance().getResponseSubject().subscribe(response -> {
                if (response instanceof final DropCardResponse dropCardResponse) {
                    emitter.onSuccess(ItemDTO.toEntity(dropCardResponse.hand));
                }
            }));
            RoomClient.getInstance().dropCard(item.getName());
        });
    }

    @Override
    public Completable dropAll() {
        return Completable.create(emitter -> {
            emitter.setDisposable(RoomClient.getInstance().getResponseSubject().subscribe(response -> {
                if (response instanceof DropAllCardsReponse) {
                    emitter.onComplete();
                }
            }));
            RoomClient.getInstance().dropAllCards();
        });
    }
}
