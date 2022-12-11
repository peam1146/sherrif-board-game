package com.progmeth.project.sheriff.presentors.home.controllers;

import com.progmeth.project.sheriff.core.controllers.main.MainController;
import com.progmeth.project.sheriff.core.controllers.router.states.RouteState;
import com.progmeth.project.sheriff.core.utils.view.controllers.StateController;
import com.progmeth.project.sheriff.presentors.home.controllers.states.HomeState;
import com.progmeth.project.sheriff.presentors.home.controllers.states.Init;

public class HomeController extends StateController<HomeState> {

    final private MainController mainController;
    public HomeController(MainController mainController) {
        super(new Init());
        this.mainController = mainController;
    }
    public void startGame() {
        mainController.getRouterController().navigateTo(RouteState.LOUGE);
    }
    public MainController getMainController() {
        return mainController;
    }
}
