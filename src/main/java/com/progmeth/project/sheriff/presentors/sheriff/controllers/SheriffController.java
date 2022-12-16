package com.progmeth.project.sheriff.presentors.sheriff.controllers;

import com.progmeth.project.sheriff.core.controllers.main.MainController;
import com.progmeth.project.sheriff.core.utils.view.controllers.StateController;
import com.progmeth.project.sheriff.presentors.sheriff.controllers.states.SheriffState;
import io.reactivex.rxjava3.core.Observable;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

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
        super(new SheriffState(new ArrayList<>()));
        this.mainController = mainController;

        Observable.interval(1, TimeUnit.SECONDS).subscribe((l) -> {
            getPlayers();
        });
    }

    private void getPlayers() {
        mainController.getRoomRepository().getPlayers().subscribe(players -> {
                setState(new SheriffState(players));
        });
    }
}
