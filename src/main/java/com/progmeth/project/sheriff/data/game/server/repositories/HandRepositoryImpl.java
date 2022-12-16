package com.progmeth.project.sheriff.data.game.server.repositories;

import com.progmeth.project.sheriff.data.game.server.models.DTO.ItemDTO;
import com.progmeth.project.sheriff.data.game.server.models.response.DrawCardResponse;
import com.progmeth.project.sheriff.data.game.server.models.response.DropAllCardsReponse;
import com.progmeth.project.sheriff.data.game.server.models.response.DropCardResponse;
import com.progmeth.project.sheriff.data.game.server.models.response.GetHandResponse;
import com.progmeth.project.sheriff.data.game.server.network.RoomClient;
import com.progmeth.project.sheriff.domain.game.entity.ItemEntity;
import com.progmeth.project.sheriff.domain.game.repositories.HandRepository;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;

import java.util.ArrayList;

/**
 * Hand repository implementation
 */
public class HandRepositoryImpl implements HandRepository {

    /*
     * Get hand from server
     */
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

    /**
     * Constructor
     */
    public HandRepositoryImpl() {
    }

    /*
     * Draw card from deck
     */
    @Override
    public Single<ArrayList<ItemEntity>> draw(int n) {
        return Single.create(emitter -> {
            RoomClient.getInstance().getResponseSubject().subscribe(response -> {
                if (response instanceof final DrawCardResponse res) {
                    emitter.onSuccess(ItemDTO.toEntity(res.hand));
                }
            });
            RoomClient.getInstance().playerDraw(n);
        });
    }

    /*
     * Drop card from hand
     */
    @Override
    public Single<ArrayList<ItemEntity>> drop(ItemEntity item) {
        return Single.create(emitter -> {
            emitter.setDisposable(RoomClient.getInstance().getResponseSubject().subscribe(response -> {
                if (response instanceof final DropCardResponse dropCardResponse) {
                    System.out.println("Drop card response");
                    emitter.onSuccess(ItemDTO.toEntity(dropCardResponse.hand));
                }
            }));
            RoomClient.getInstance().dropCard(item.getName());
        });
    }

    /*
     * Drop all cards from hand
     */
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

    @Override
    public Single<Boolean> getIsDropable() {
        return null;
    }

}
