package com.progmeth.project.sheriff.core.controllers.main;

import com.progmeth.project.sheriff.core.controllers.main.states.InitState;
import com.progmeth.project.sheriff.core.controllers.main.states.MainState;
import com.progmeth.project.sheriff.core.controllers.router.RouterController;
import com.progmeth.project.sheriff.core.utils.view.controllers.StateController;

/**
 * Main controller
 */
public class MainController extends StateController<MainState> {
    /**
     * router controller
     */
    private final RouterController routerController;

    /**
     * Constructor
     * @param routerController controller
     */
    public MainController(RouterController routerController) {
        super(new InitState());
        this.routerController = routerController;
    }

    /**
     * get router controller
     * @return router controller
     */
    public RouterController getRouterController() {
        return routerController;
    }
}
