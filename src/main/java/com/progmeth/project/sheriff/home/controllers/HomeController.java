package com.progmeth.project.sheriff.home.controllers;

import com.progmeth.project.sheriff.core.controllers.main.MainController;
import com.progmeth.project.sheriff.core.utils.controllers.StateWithEventController;
import com.progmeth.project.sheriff.home.controllers.events.HomeEvent;
import com.progmeth.project.sheriff.home.controllers.states.HomeState;
import com.progmeth.project.sheriff.home.controllers.states.Init;

public class HomeController extends StateWithEventController<HomeEvent, HomeState> {
    final public MainController mainController;
    public HomeController(MainController mainController) {
        super(new Init());
        this.mainController = mainController;
    }

    @Override
    protected void onEvent(HomeEvent homeEvent) {

    }
}
