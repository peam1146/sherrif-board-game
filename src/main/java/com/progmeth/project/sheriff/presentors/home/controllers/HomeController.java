package com.progmeth.project.sheriff.presentors.home.controllers;

import com.progmeth.project.sheriff.core.controllers.main.MainController;
import com.progmeth.project.sheriff.core.controllers.router.states.RouteState;
import com.progmeth.project.sheriff.core.utils.view.controllers.StateController;
import com.progmeth.project.sheriff.presentors.home.controllers.states.HomeState;
import com.progmeth.project.sheriff.presentors.home.controllers.states.Init;
import io.reactivex.rxjava3.core.Completable;

public class HomeController extends StateController<HomeState> {

    final private MainController mainController;
    public HomeController(MainController mainController) {
        super(new Init());
        this.mainController = mainController;
    }
    public void joinRoom() {
//        mainController.getRoomRepository().joinGame("test", "test").subscribe();
        mainController.getRouterController().navigateTo(RouteState.LOUGE);
    }
    public void createRoom() {
        final Completable com = mainController.getRoomRepository().createRoom("localhost", 3000);
        com.doOnComplete(() -> {
            System.out.println("Room created");
            mainController.getRouterController().navigateTo(RouteState.LOUGE);
        }).doOnError((e) -> {
            System.out.println("Room creation failed");
        }).subscribe();
    }

    public MainController getMainController() {
        return mainController;
    }
}
