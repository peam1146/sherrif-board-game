package com.progmeth.project.sheriff.presentors.louge.controllers;

import com.progmeth.project.sheriff.core.controllers.main.MainController;
import com.progmeth.project.sheriff.core.controllers.router.states.RouteState;
import com.progmeth.project.sheriff.core.utils.view.controllers.StateController;
import com.progmeth.project.sheriff.presentors.louge.controllers.states.LougeState;

/**
 * Louge controller
 */
public class LougeController extends StateController<LougeState> {
    /**
     * main controller
     */
    final private MainController mainController;

    /**
     * Constructor
     *
     * @param mainController main controller
     */
    public LougeController(MainController mainController) {
        super(new LougeState());
        this.mainController = mainController;
    }

    /**
     * join game
     */
    public void joinGame() {
        mainController.getRouterController().navigateTo(RouteState.GAME_PLAYER); // Backend need to decide user role
    }

    /**
     * get main controller
     *
     * @return main controller
     */
    public MainController getMainController() {
        return mainController;
    }
}
