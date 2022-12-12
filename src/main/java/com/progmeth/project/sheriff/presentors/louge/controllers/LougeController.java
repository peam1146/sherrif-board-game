package com.progmeth.project.sheriff.presentors.louge.controllers;

import com.progmeth.project.sheriff.core.controllers.main.MainController;
import com.progmeth.project.sheriff.core.controllers.router.states.RouteState;
import com.progmeth.project.sheriff.core.utils.view.controllers.StateController;
import com.progmeth.project.sheriff.presentors.louge.controllers.states.LougeState;

public class LougeController extends StateController<LougeState> {
    final private MainController mainController;
    public LougeController(MainController mainController) {
        super(new LougeState());
        this.mainController = mainController;
    }
    
    public void joinGame() {
        mainController.getRouterController().navigateTo(RouteState.GAME_PLAYER); // Backend need to decide user role
    }

    public MainController getMainController() {
        return mainController;
    }
}
