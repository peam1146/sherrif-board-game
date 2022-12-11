package com.progmeth.project.sheriff.domain.game.repositories;

import com.progmeth.project.sheriff.domain.game.entity.RoomEntity;
import io.reactivex.rxjava3.core.Single;

public interface RoomRepository {
    public Single<Void> joinGame(String room);
    public Single<RoomEntity> getRoomList();
    public Single<RoomEntity> createRoom(String room);
}
