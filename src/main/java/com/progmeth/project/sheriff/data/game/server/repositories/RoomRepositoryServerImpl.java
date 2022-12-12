package com.progmeth.project.sheriff.data.game.server.repositories;

import com.progmeth.project.sheriff.data.game.server.RoomClient;
import com.progmeth.project.sheriff.data.game.server.RoomServer;
import com.progmeth.project.sheriff.data.game.server.models.request.JoinRoomRequest;
import com.progmeth.project.sheriff.data.game.server.models.response.Response;
import com.progmeth.project.sheriff.domain.game.repositories.RoomRepository;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.subjects.PublishSubject;

import java.io.IOException;


public class RoomRepositoryServerImpl implements RoomRepository {
    @Override
    public Completable joinGame(String room) {
        if (!RoomClient.getInstance().getRunning())
            RoomClient.getInstance().setup();
        return Completable.create(emitter -> {
            RoomClient.getInstance().joinRoom(room);
            final PublishSubject<Response> responseSubject = RoomClient.getInstance().getResponseSubject();
            final var disposable = responseSubject.subscribe(response -> {
                if (response.getTopic().equals(JoinRoomRequest.requestTopic)) {
                    emitter.onComplete();
                }
            });
            emitter.setDisposable(disposable);
        });
    }

    @Override
    public Completable createRoom(String room, int tcpPort) {
        return Completable.create(emitter -> {
            if (RoomServer.getInstance().isRunning()) {
                emitter.onError(new IOException("Room already created"));
                return;
            }
            final Thread t = new Thread("RoomServer") {
                @Override
                public void run() {
                    System.out.println("Starting room server");
                    RoomServer.getInstance().start();
                    try {
                        RoomServer.getInstance().bind(tcpPort);
                        emitter.onComplete();
                    } catch (IOException e) {
                        RoomServer.getInstance().close();
                        emitter.onError(e);
                    }
                }
            };
            t.start();
        });
    }
}
