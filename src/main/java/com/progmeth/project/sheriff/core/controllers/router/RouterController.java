package com.progmeth.project.sheriff.core.controllers.router;

import com.progmeth.project.sheriff.core.controllers.router.states.RouteState;
import com.progmeth.project.sheriff.core.utils.view.controllers.StateController;

public class RouterController extends StateController<RouteState> {
    public RouterController() {
        super(RouteState.HOME);
    }

    public void navigateTo(RouteState route) {
        setState(route);
    }
}
