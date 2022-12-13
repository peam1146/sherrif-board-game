package com.progmeth.project.sheriff.data.game.server.repositories;

import com.progmeth.project.sheriff.data.game.server.models.response.GetPlayersResponse;
import com.progmeth.project.sheriff.data.game.server.models.response.JoinRoomResponse;
import com.progmeth.project.sheriff.data.game.server.network.RoomClient;
import com.progmeth.project.sheriff.data.game.server.network.RoomServer;
import com.progmeth.project.sheriff.data.game.server.models.request.JoinRoomRequest;
import com.progmeth.project.sheriff.data.game.server.models.response.Response;
import com.progmeth.project.sheriff.data.game.server.models.response.StartGameResponse;
import com.progmeth.project.sheriff.domain.game.repositories.RoomRepository;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.subjects.PublishSubject;

import java.io.IOException;
import java.util.ArrayList;


public class RoomRepositoryImpl implements RoomRepository {
    @Override
    public Completable startGame() {
        return Completable.create(emitter -> {
            RoomClient.getInstance().startGame();
            final var dispose = RoomClient.getInstance().getResponseSubject().subscribe(response -> {
                if (response instanceof StartGameResponse) {
                    emitter.onComplete();
                }
            });
            emitter.setDisposable(dispose);
        });
    }

    @Override
    public Single<ArrayList<String>> getPlayers() {
        return Single.create(emitter -> {
            RoomClient.getInstance().getPlayers();
            final var dispose = RoomClient.getInstance().getResponseSubject().subscribe(response -> {
                if (response instanceof final GetPlayersResponse getPlayersResponse) {
                    emitter.onSuccess(getPlayersResponse.players);
                }
            });
            emitter.setDisposable(dispose);
        });
    }

    @Override
    public Single<ArrayList<String>> joinGame(String host, String name) {
        if (!RoomClient.getInstance().getRunning())
            RoomClient.getInstance().setup();
        return Single.create(emitter -> {
            RoomClient.getInstance().joinRoom(name);
            final PublishSubject<Response> responseSubject = RoomClient.getInstance().getResponseSubject();
            final var disposable = responseSubject.subscribe(response -> {
                if (response.getTopic().equals(JoinRoomRequest.requestTopic)) {
                    final JoinRoomResponse joinRoomResponse = (JoinRoomResponse) response;
                    RoomClient.getInstance().setPlayerID(joinRoomResponse.playerID);
                    emitter.onSuccess(joinRoomResponse.playerNames);
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
