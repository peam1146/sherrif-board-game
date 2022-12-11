package com.progmeth.project.sheriff.core.controllers.main;

import com.progmeth.project.sheriff.core.controllers.main.states.InitState;
import com.progmeth.project.sheriff.core.controllers.main.states.MainState;
import com.progmeth.project.sheriff.core.controllers.router.RouterController;
import com.progmeth.project.sheriff.core.utils.view.controllers.StateController;

public class MainController extends StateController<MainState> {
    private final RouterController routerController;
    public MainController(RouterController routerController) {
        super(new InitState());
        this.routerController = routerController;
    }
    public RouterController getRouterController() {
        return routerController;
    }
}
