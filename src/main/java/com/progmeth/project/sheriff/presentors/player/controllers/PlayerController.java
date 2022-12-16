package com.progmeth.project.sheriff.presentors.player.controllers;

import com.progmeth.project.sheriff.core.controllers.main.MainController;
import com.progmeth.project.sheriff.core.utils.view.controllers.StateController;
import com.progmeth.project.sheriff.data.game.models.derive.hand.Hand;
import com.progmeth.project.sheriff.data.game.server.controller.DroppedDeckPos;
import com.progmeth.project.sheriff.data.game.server.models.DTO.ItemDTO;
import com.progmeth.project.sheriff.domain.game.entity.ItemEntity;
import com.progmeth.project.sheriff.presentors.common.ItemImg;
import com.progmeth.project.sheriff.presentors.common.components.Card;
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
        super(new PlayerState(new ArrayList<>(),"",new ItemEntity(0,"Chicken",false,0, 0,ItemImg.CHICKEN),new ItemEntity(0,"Chicken",false,0, 0,ItemImg.CHICKEN),false, false));
        this.mainController = mainController;
        playerController = this;
//        getDroppedDeckPolling();
    }

    public void getDroppedDeckPolling(){
        droppedDeckDisposable = Observable.interval(1, TimeUnit.SECONDS).subscribe((l)->{
            mainController.getDroppedDeckRepository().getTop().doOnSuccess((items) -> {
                setState(new PlayerState(getState().hand,getState().playerName, ItemDTO.toEntity(items[0]),ItemDTO.toEntity(items[1]),getState().showSelectBox,getState().isLockedHand));
            }).subscribe();
        });
    }

    public void drawFullHand() {
//        mainController.getHandRepository().getHand().doOnSuccess((hand) -> setState(new PlayerState(hand))).subscribe();
        if(getState().hand.size() == 0) {
            mainController.getHandRepository().draw(6).doOnSuccess((hand) -> {
                setState(new PlayerState(hand,getState().playerName,getState().topDroppedDeck,getState().bottomDroppedDeck,getState().showSelectBox,getState().isLockedHand));
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
        setState(new PlayerState(getState().hand, playerName,getState().topDroppedDeck,getState().bottomDroppedDeck,getState().showSelectBox,getState().isLockedHand));
        this.playerName = playerName;
    }
    private int dropCount = 0;
    public void dropItem(ItemEntity item, Card card){
            if(dropCount > 2){
                card.setTranslateY(60);
                setState(new PlayerState(getState().hand,getState().playerName, getState().topDroppedDeck, getState().bottomDroppedDeck,getState().showSelectBox,true));
                return;
            }
            dropCount++;
            mainController.getHandRepository().drop(item).doOnSuccess((hand) -> {
                setState(new PlayerState(hand, getState().playerName, getState().topDroppedDeck, getState().bottomDroppedDeck, getState().showSelectBox,getState().isLockedHand));
            }).subscribe();
    }

    public void drawFrom(DroppedDeckPos pos){
        mainController.getDroppedDeckRepository().draw(pos).doOnSuccess((e) -> {
           System.out.println("Draw from "+pos);
           if(e){
               mainController.getHandRepository().getHand().doOnSuccess((hand) -> {
                   setState(new PlayerState(hand,getState().playerName,getState().topDroppedDeck,getState().bottomDroppedDeck,getState().showSelectBox,getState().isLockedHand));
                   mainController.getDroppedDeckRepository().getTop().doOnSuccess((items) -> {
                       setState(new PlayerState(getState().hand,getState().playerName, ItemDTO.toEntity(items[0]),ItemDTO.toEntity(items[1]),getState().showSelectBox,getState().isLockedHand));
                   }).subscribe();
               }).subscribe();
           }
        }).subscribe();
    }

    public void showSelectBox(){
        setState(new PlayerState(getState().hand,getState().playerName,getState().topDroppedDeck,getState().bottomDroppedDeck,true,getState().isLockedHand));
    }

    public void clearSelectBox(){
        setState(new PlayerState(getState().hand,getState().playerName,getState().topDroppedDeck,getState().bottomDroppedDeck,false,getState().isLockedHand));
    }
}
