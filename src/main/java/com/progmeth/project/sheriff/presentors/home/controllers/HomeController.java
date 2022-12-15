package com.progmeth.project.sheriff.presentors.home.controllers;

import com.progmeth.project.sheriff.core.controllers.main.MainController;
import com.progmeth.project.sheriff.core.controllers.router.states.RouteState;
import com.progmeth.project.sheriff.core.utils.view.controllers.StateController;
import com.progmeth.project.sheriff.presentors.home.controllers.states.HomeState;
import com.progmeth.project.sheriff.presentors.home.controllers.states.Init;

/**
 * Home controller
 */
public class HomeController extends StateController<HomeState> {

    /**
     * main controller
     */
    final private MainController mainController;

    /**
     * Constructor
     * @param mainController main controller
     */
    public HomeController(MainController mainController) {
        super(new Init());
        this.mainController = mainController;
    }

    /**
     * start game
     */
    public void startGame() {
        mainController.getRouterController().navigateTo(RouteState.LOUGE);
    }

    /**
     * get main controller
     * @return main controller
     */
    public MainController getMainController() {
        return mainController;
    }
}
