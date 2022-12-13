package com.progmeth.project.sheriff;

import com.progmeth.project.sheriff.core.controllers.main.MainController;
import com.progmeth.project.sheriff.core.controllers.router.RouterController;
import com.progmeth.project.sheriff.core.controllers.router.states.RouteState;
import com.progmeth.project.sheriff.core.utils.view.controllers.StreamBuilder;
import com.progmeth.project.sheriff.data.game.server.network.RoomClient;
import com.progmeth.project.sheriff.data.game.server.network.RoomServer;
import com.progmeth.project.sheriff.data.game.server.repositories.RoomRepositoryImpl;
import com.progmeth.project.sheriff.presentors.demo.controllers.DemoController;
import com.progmeth.project.sheriff.presentors.demo.views.DemoView;
import com.progmeth.project.sheriff.presentors.game.controllers.GameController;
import com.progmeth.project.sheriff.presentors.game.views.GameView;
import com.progmeth.project.sheriff.presentors.home.controllers.HomeController;
import com.progmeth.project.sheriff.presentors.home.views.HomeView;
import com.progmeth.project.sheriff.presentors.louge.controllers.LougeController;
import com.progmeth.project.sheriff.presentors.louge.views.LougeView;
import com.progmeth.project.sheriff.presentors.player.controllers.PlayerController;
import com.progmeth.project.sheriff.presentors.player.views.PlayerView;
import com.progmeth.project.sheriff.presentors.sheriff.controllers.SheriffController;
import com.progmeth.project.sheriff.presentors.sheriff.views.SheriffView;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
    private final RouterController routerController = new RouterController();
    private final MainController mainController = new MainController(routerController);
    private final HomeController homeController = new HomeController(mainController);
    private final LougeController lougeController = new LougeController(mainController);
    private final PlayerController playerController = new PlayerController(mainController);
    private final SheriffController sheriffController = new SheriffController(mainController);
    private final GameController gameController = new GameController();
    private final DemoController demoController = new DemoController(new RoomRepositoryImpl());
    private void setUpStage(Stage primaryStage) {
        primaryStage.setTitle("Sheriff");
        primaryStage.setMaxHeight(600);
        primaryStage.setMaxWidth(800);
        primaryStage.setMinHeight(600);
        primaryStage.setMinWidth(800);
        primaryStage.setResizable(false);
    }

    @Override
    public void start(Stage primaryStage) {

        final HomeView homeView = new HomeView(homeController);
        final GameView gameView = new GameView(gameController);
        final LougeView lougeView = new LougeView(lougeController);
        final PlayerView playerView = new PlayerView(playerController);

        //demo
        final DemoView demoView = new DemoView(demoController);

        final SheriffView sheriffView = new SheriffView(sheriffController);

        final StreamBuilder<RouteState, RouterController> root = new StreamBuilder<>(routerController) {
            @Override
            protected Node builder(RouteState state) {
                return switch (state) {
                    case HOME -> demoView;
                    case LOUGE -> lougeView;
                    case GAME_PLAYER -> playerView;
                    case GAME_SHERIFF -> sheriffView;
                };
            }
        };
        final Scene scene = new Scene(root, 597, 600);
        primaryStage.setScene(scene);
        setUpStage(primaryStage);
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        System.out.println("Stopping");
        homeController.dispose();
        lougeController.dispose();
        playerController.dispose();
        sheriffController.dispose();
        gameController.dispose();
        demoController.dispose();
        RoomServer.getInstance().close();
        RoomClient.getInstance().stop();
        super.stop();
        System.exit(0);
    }
}