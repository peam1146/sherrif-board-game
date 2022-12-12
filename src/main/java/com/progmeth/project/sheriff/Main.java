package com.progmeth.project.sheriff;

import com.progmeth.project.sheriff.core.controllers.main.MainController;
import com.progmeth.project.sheriff.core.controllers.router.RouterController;
import com.progmeth.project.sheriff.core.controllers.router.states.RouteState;
import com.progmeth.project.sheriff.core.utils.view.controllers.StreamBuilder;
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

        final RouterController routerController = new RouterController();
        final MainController mainController = new MainController(routerController);

        final HomeController controller = new HomeController(mainController);
        final HomeView homeView = new HomeView(controller);

        final GameController gameController = new GameController();
        final GameView gameView = new GameView(gameController);

        final LougeController lougeController = new LougeController(mainController);
        final LougeView lougeView = new LougeView(lougeController);

        final PlayerController playerController = new PlayerController(mainController);
        final PlayerView playerView = new PlayerView(playerController);

        final SheriffController sheriffController = new SheriffController(mainController);
        final SheriffView sheriffView = new SheriffView(sheriffController);

        final StreamBuilder<RouteState, RouterController> root = new StreamBuilder<>(routerController) {
            @Override
            protected Node builder(RouteState state) {
                return switch (state) {
                    case HOME -> sheriffView; //debug
                    case SECOND -> gameView;
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

    public static void main(String[] args) {
        launch(args);
    }
}