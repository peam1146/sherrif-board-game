package com.progmeth.project.sheriff.presentors.player.controllers;

import com.progmeth.project.sheriff.core.controllers.main.MainController;
import com.progmeth.project.sheriff.core.utils.view.controllers.StateController;
import com.progmeth.project.sheriff.presentors.player.controllers.states.PlayerState;

/**
 * Player controller
 */
public class PlayerController extends StateController<PlayerState> {
    /**
     * main controller
     */
    final private MainController mainController;

    /**
     * Constructor
     * @param mainController controller
     */
    public PlayerController(MainController mainController) {
        super(new PlayerState());
        this.mainController = mainController;
    }
    // To Implement
}
