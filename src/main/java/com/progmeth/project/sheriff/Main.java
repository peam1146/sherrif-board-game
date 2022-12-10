package com.progmeth.project.sheriff;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private void setUpStage(Stage primaryStage) throws IOException {
        final Pane root = new Pane();
        final Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Sheriff");
        primaryStage.setMaxHeight(600);
        primaryStage.setMaxWidth(800);
        primaryStage.setMinHeight(600);
        primaryStage.setMinWidth(800);
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        setUpStage(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}