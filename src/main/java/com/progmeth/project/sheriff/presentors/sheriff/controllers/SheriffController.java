package com.progmeth.project.sheriff.presentors.sheriff.controllers;

import com.progmeth.project.sheriff.core.controllers.main.MainController;
import com.progmeth.project.sheriff.core.utils.view.controllers.StateController;
import com.progmeth.project.sheriff.presentors.player.controllers.states.PlayerState;
import com.progmeth.project.sheriff.presentors.sheriff.controllers.states.SheriffState;

public class SheriffController extends StateController<SheriffState> {
    final private MainController mainController;
    public SheriffController(MainController mainController) {
        super(new SheriffState());
        this.mainController = mainController;
    }
    // To Implement
}
