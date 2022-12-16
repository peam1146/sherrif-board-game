package com.progmeth.project.sheriff.core.controllers.main;

import com.progmeth.project.sheriff.core.controllers.main.states.InitState;
import com.progmeth.project.sheriff.core.controllers.main.states.MainState;
import com.progmeth.project.sheriff.core.controllers.router.RouterController;
import com.progmeth.project.sheriff.core.utils.view.controllers.StateController;
import com.progmeth.project.sheriff.domain.game.repositories.DroppedDeckRepository;
import com.progmeth.project.sheriff.domain.game.repositories.HandRepository;
import com.progmeth.project.sheriff.domain.game.repositories.RoomRepository;

public class MainController extends StateController<MainState> {
    private final RouterController routerController;
    private final RoomRepository roomRepository;
    private final HandRepository handRepository;
    private final DroppedDeckRepository droppedDeckRepository;

    private int playerId = -1;

    public MainController(RouterController routerController, RoomRepository roomRepository,HandRepository handRepository,DroppedDeckRepository droppedDeckRepository) {
        super(new InitState());
        this.routerController = routerController;
        this.roomRepository = roomRepository;
        this.handRepository = handRepository;
        this.droppedDeckRepository = droppedDeckRepository;
    }
    public RouterController getRouterController() {
        return routerController;
    }
    public RoomRepository getRoomRepository() {
        return roomRepository;
    }

    public HandRepository getHandRepository() {
        return handRepository;
    }

    public DroppedDeckRepository getDroppedDeckRepository() {
        return droppedDeckRepository;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public int getPlayerId() {
        return playerId;
    }
}
