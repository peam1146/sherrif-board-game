package com.progmeth.project.sheriff.presentors.louge.controllers;

import com.progmeth.project.sheriff.core.controllers.main.MainController;
import com.progmeth.project.sheriff.core.controllers.router.states.RouteState;
import com.progmeth.project.sheriff.core.utils.view.controllers.StateController;
import com.progmeth.project.sheriff.presentors.louge.controllers.states.LougeState;
import com.progmeth.project.sheriff.presentors.player.controllers.PlayerController;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;

import java.util.ArrayList;
import java.util.Objects;

public class LougeController extends StateController<LougeState> {
    final private MainController mainController;
    private String roomIP;
    private String userName;
    public LougeController(MainController mainController) {
        super(new LougeState());
        this.mainController = mainController;
    }
    
    public void joinGame() {
        PlayerController.getInstance().setPlayerName(userName);

        final Single<ArrayList<String>> com = mainController.getRoomRepository().joinGame(roomIP, userName);
        com.doOnSuccess(value -> {
            System.out.println("Room joined "+roomIP+" "+userName);
            for (String s : value) {
                if(Objects.equals(s, userName)){
                    mainController.setPlayerId(value.indexOf(s));
                }
                System.out.println("users : "+s);
            }
            mainController.getRouterController().navigateTo(RouteState.WAITING_ROOM);
        }).doOnError((e) -> {
            System.out.println("Room join failed");
        }).subscribe();
    }

    public void setIP(String ip) {
        roomIP = ip;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public MainController getMainController() {
        return mainController;
    }
}
