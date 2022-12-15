package com.progmeth.project.sheriff.presentors.sheriff.controllers;

import com.progmeth.project.sheriff.core.controllers.main.MainController;
import com.progmeth.project.sheriff.core.utils.view.controllers.StateController;
import com.progmeth.project.sheriff.presentors.sheriff.controllers.states.SheriffState;

/**
 * Sheriff controller
 */
public class SheriffController extends StateController<SheriffState> {
    /**
     * main controller
     */
    final private MainController mainController;

    /**
     * Constructor
     *
     * @param mainController main controller
     */
    public SheriffController(MainController mainController) {
        super(new SheriffState());
        this.mainController = mainController;
    }
    // To Implement
}
