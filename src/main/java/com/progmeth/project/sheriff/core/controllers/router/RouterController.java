package com.progmeth.project.sheriff.core.controllers.router;

import com.progmeth.project.sheriff.core.controllers.router.states.RouteState;
import com.progmeth.project.sheriff.core.utils.view.controllers.StateController;

/**
 * Router controller
 */
public class RouterController extends StateController<RouteState> {
    /**
     * Constructor
     */
    public RouterController() {
        super(RouteState.HOME);
    }

    /**
     * navigation
     *
     * @param route target route
     */
    public void navigateTo(RouteState route) {
        setState(route);
    }
}
