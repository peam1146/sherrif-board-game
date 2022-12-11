package com.progmeth.project.sheriff.data.game.server.repositories;

import com.progmeth.project.sheriff.data.game.server.MainServer;
import com.progmeth.project.sheriff.domain.game.entity.RoomEntity;
import com.progmeth.project.sheriff.domain.game.repositories.RoomRepository;
import io.reactivex.rxjava3.core.Single;

import java.io.IOException;

public class RoomRepositoryImpl implements RoomRepository {
    @Override
    public Single<Void> joinGame(String room) {
        return null;
    }

    @Override
    public RoomEntity getRoomList() {
        return null;
    }

    @Override
    public Single<RoomEntity> createRoom(String room) {
        MainServer.getInstance().start();
        try {
            MainServer.getInstance().bind(54555);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
