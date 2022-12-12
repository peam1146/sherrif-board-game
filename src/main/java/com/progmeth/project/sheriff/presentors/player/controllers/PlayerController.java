package com.progmeth.project.sheriff.presentors.player.controllers;

import com.progmeth.project.sheriff.core.controllers.main.MainController;
import com.progmeth.project.sheriff.core.utils.view.controllers.StateController;
import com.progmeth.project.sheriff.presentors.player.controllers.states.PlayerState;

public class PlayerController extends StateController<PlayerState> {
    final private MainController mainController;
    public PlayerController(MainController mainController) {
        super(new PlayerState());
        this.mainController = mainController;
    }
    // To Implement
}
