package com.progmeth.project.sheriff;

import com.progmeth.project.sheriff.core.controllers.main.MainController;
import com.progmeth.project.sheriff.core.controllers.router.RouterController;
import com.progmeth.project.sheriff.core.controllers.router.states.RouteState;
import com.progmeth.project.sheriff.core.utils.controllers.StreamBuilder;
import com.progmeth.project.sheriff.presentors.game.controllers.GameController;
import com.progmeth.project.sheriff.presentors.game.views.GameView;
import com.progmeth.project.sheriff.presentors.home.controllers.HomeController;
import com.progmeth.project.sheriff.presentors.home.views.HomeView;
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
        final StreamBuilder<RouteState, RouterController> root = new StreamBuilder<>(routerController) {
            @Override
            protected Node builder(RouteState state) {
                return switch (state) {
                    case HOME -> homeView;
                    case SECOND -> gameView;
                };
            }
        };
        final Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        setUpStage(primaryStage);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}