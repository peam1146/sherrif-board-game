package com.progmeth.project.sheriff.presentors.player.controllers;

import com.progmeth.project.sheriff.core.controllers.main.MainController;
import com.progmeth.project.sheriff.core.utils.view.controllers.StateController;
import com.progmeth.project.sheriff.data.game.models.derive.hand.Hand;
import com.progmeth.project.sheriff.data.game.server.models.DTO.ItemDTO;
import com.progmeth.project.sheriff.domain.game.entity.ItemEntity;
import com.progmeth.project.sheriff.presentors.common.ItemImg;
import com.progmeth.project.sheriff.presentors.player.controllers.states.PlayerState;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class PlayerController extends StateController<PlayerState> {
    final private MainController mainController;
    private static PlayerController playerController;
    private String playerName;

    private Disposable droppedDeckDisposable;

    public PlayerController(MainController mainController) {
        super(new PlayerState(new ArrayList<>(),"",new ItemEntity(0,"Chicken",false,0, 0,ItemImg.CHICKEN),new ItemEntity(0,"Chicken",false,0, 0,ItemImg.CHICKEN)));
        this.mainController = mainController;
        playerController = this;
//        getDroppedDeckPolling();
    }

    public void getDroppedDeckPolling(){
        droppedDeckDisposable = Observable.interval(1, TimeUnit.SECONDS).subscribe((l)->{
            mainController.getDroppedDeckRepository().getTop().doOnSuccess((items) -> {
                setState(new PlayerState(getState().hand,getState().playerName, ItemDTO.toEntity(items[0]),ItemDTO.toEntity(items[1])));
            }).subscribe();
        });
    }

    public void drawFullHand() {
//        mainController.getHandRepository().getHand().doOnSuccess((hand) -> setState(new PlayerState(hand))).subscribe();
        if(getState().hand.size() == 0) {
            mainController.getHandRepository().draw(6).doOnSuccess((hand) -> {
                setState(new PlayerState(hand,getState().playerName,getState().topDroppedDeck,getState().bottomDroppedDeck));
            }).subscribe();
        }
    }

    public static PlayerController getInstance(){
        return playerController;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        System.out.println("Set player name "+playerName);
        setState(new PlayerState(getState().hand, playerName,getState().topDroppedDeck,getState().bottomDroppedDeck));
        this.playerName = playerName;
    }
}
