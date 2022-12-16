package com.progmeth.project.sheriff.presentors.waiting.controllers;

import com.progmeth.project.sheriff.core.controllers.main.MainController;
import com.progmeth.project.sheriff.core.controllers.router.states.RouteState;
import com.progmeth.project.sheriff.core.utils.view.controllers.StateController;
import com.progmeth.project.sheriff.presentors.player.controllers.PlayerController;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class WaitingRoomController extends StateController<Integer> {
    private final MainController mainController;
    private Disposable playerPollingDisposable = null;
    private Disposable gameStartPollingDisposeable = null;
    public WaitingRoomController(MainController mainController) {
        super(0);
        this.mainController = mainController;
        getIsGameStartedPolling();
    }

    public void getPlayersPolling(Consumer<ArrayList<String>> subscriber) {
        mainController.getRoomRepository().getPlayers().subscribe(subscriber);
        this.playerPollingDisposable = Observable.interval(1, TimeUnit.SECONDS).subscribe((l) -> {
            final Single<ArrayList<String>> players = mainController.getRoomRepository().getPlayers();
            players.subscribe(subscriber);
        });
    }

    public void startGame(){
        playerPollingDisposable.dispose();
        final Completable com = mainController.getRoomRepository().startGame();
    }

    public void getIsGameStartedPolling(){
        gameStartPollingDisposeable = Observable.interval(1, TimeUnit.SECONDS).subscribe((l) -> {
            final Single<Boolean> isGameStart = mainController.getRoomRepository().isGameStart();
            isGameStart.subscribe((isGameStart1) -> {
                if (isGameStart1){
                    mainController.getRoomRepository().getCurrentSheriff().subscribe((sheriff) -> {
                        //Go to player for debug
                        mainController.getRouterController().navigateTo(RouteState.GAME_PLAYER);
                        PlayerController.getInstance().drawFullHand();
                        PlayerController.getInstance().getDroppedDeckPolling();

//                        if(sheriff == mainController.getPlayerId()){
//                            mainController.getRouterController().navigateTo(RouteState.GAME_SHERIFF);
//                        }else{
//                            mainController.getRouterController().navigateTo(RouteState.GAME_PLAYER);
//                        }
                    });
                    gameStartPollingDisposeable.dispose();
                }
            });
        });
    }
}
