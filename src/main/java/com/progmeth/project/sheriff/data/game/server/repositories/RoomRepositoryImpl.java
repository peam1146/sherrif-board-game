package com.progmeth.project.sheriff.data.game.server.repositories;

import com.progmeth.project.sheriff.data.game.server.models.response.*;
import com.progmeth.project.sheriff.data.game.server.network.RoomClient;
import com.progmeth.project.sheriff.data.game.server.network.RoomServer;
import com.progmeth.project.sheriff.data.game.server.models.request.JoinRoomRequest;
import com.progmeth.project.sheriff.domain.game.repositories.RoomRepository;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.subjects.PublishSubject;

import java.io.IOException;
import java.util.ArrayList;


/**
 * Room repository implementation
 */
public class RoomRepositoryImpl implements RoomRepository {
    /**
     * Constructor
     */
    public RoomRepositoryImpl() {
    }

    @Override
    public Completable startGame() {
        System.out.println("RoomRepositoryImpl.startGame");
        RoomClient.getInstance().startGame();
        return Completable.create(emitter -> {
            final var dispose = RoomClient.getInstance().getResponseSubject().subscribe(response -> {
                if (response instanceof StartGameResponse) {
                    emitter.onComplete();
                }
            });
//            RoomClient.getInstance().startGame();
            emitter.setDisposable(dispose);
        });
    }



    @Override
    public Single<ArrayList<String>> getPlayers() {
        System.out.println("RoomRepositoryImpl.getPlayers");
        return Single.create(emitter -> {
            final var dispose = RoomClient.getInstance().getResponseSubject().subscribe(response -> {
                if (response instanceof final GetPlayersResponse getPlayersResponse) {
                    emitter.onSuccess(getPlayersResponse.players);
                }
            });
            RoomClient.getInstance().getPlayers();
            emitter.setDisposable(dispose);
        });
    }

    @Override
    public Single<ArrayList<String>> joinGame(String host, String name) {
        if (!RoomClient.getInstance().getRunning())
            RoomClient.getInstance().setup(host);
        return Single.create(emitter -> {
            final PublishSubject<Response> responseSubject = RoomClient.getInstance().getResponseSubject();
            final var disposable = responseSubject.subscribe(response -> {
                if (response.getTopic().equals(JoinRoomRequest.requestTopic)) {
                    final JoinRoomResponse joinRoomResponse = (JoinRoomResponse) response;
                    RoomClient.getInstance().setPlayerID(joinRoomResponse.playerID);
                    emitter.onSuccess(joinRoomResponse.playerNames);
                }
            });
            RoomClient.getInstance().joinRoom(name);
            emitter.setDisposable(disposable);
        });
    }

    @Override
    public Completable createRoom(String room, int tcpPort) {
        System.out.println("RoomRepositoryImpl.createRoom");
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

    @Override
    public Single<Boolean> isGameStart() {
        return Single.create(emitter -> {
            final PublishSubject<Response> responseSubject = RoomClient.getInstance().getResponseSubject();
            final var disposable = responseSubject.subscribe(response -> {
                if (response.getTopic().equals(GetIsGameStartedResponse.responseTopic)) {
                    final GetIsGameStartedResponse getIsGameStartedResponse = (GetIsGameStartedResponse) response;
//                    System.out.println("isGameStart: " + getIsGameStartedResponse.isGameStarted);
                    emitter.onSuccess(getIsGameStartedResponse.isGameStarted);
                }
            });
            RoomClient.getInstance().isGameStarted();
            emitter.setDisposable(disposable);
        });
    }

    @Override
    public Single<Integer> getCurrentSheriff(){
        return Single.create(emitter -> {
            final PublishSubject<Response> responseSubject = RoomClient.getInstance().getResponseSubject();
            final var disposable = responseSubject.subscribe(response -> {
                if (response.getTopic().equals(GetCurrentSheriffResponse.responseTopic)) {
                    final GetCurrentSheriffResponse getCurrentSheriffResponse = (GetCurrentSheriffResponse) response;
                    emitter.onSuccess(getCurrentSheriffResponse.currentSheriff);
                }
            });
            RoomClient.getInstance().getCurrentSheriff();
            emitter.setDisposable(disposable);
        });
    }
}
