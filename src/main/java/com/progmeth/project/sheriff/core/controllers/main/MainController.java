package com.progmeth.project.sheriff.core.controllers.main;

import com.progmeth.project.sheriff.core.controllers.main.states.InitState;
import com.progmeth.project.sheriff.core.controllers.main.states.MainState;
import com.progmeth.project.sheriff.core.controllers.router.RouterController;
import com.progmeth.project.sheriff.core.utils.controllers.StateController;

public class MainController extends StateController<MainState> {
    public final RouterController routerController;

    public MainController(RouterController routerController) {
        super(new InitState());
        this.routerController = routerController;
    }
}
