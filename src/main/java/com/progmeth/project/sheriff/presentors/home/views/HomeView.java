package com.progmeth.project.sheriff.presentors.home.views;

import com.progmeth.project.sheriff.core.utils.controllers.StreamBuilder;
import com.progmeth.project.sheriff.presentors.home.controllers.HomeController;
import com.progmeth.project.sheriff.presentors.home.controllers.states.HomeState;
import com.progmeth.project.sheriff.presentors.home.controllers.states.Idle;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import static javafx.geometry.Pos.CENTER;

public class HomeView extends StackPane {
    private final static String BG_IMG = HomeView.class.getResource("/com/progmeth/project/sheriff/images/bg.jpeg").toString();
    private final ImageView bgImage = new ImageView(BG_IMG);
    private final VBox menu = new VBox();
    private final Button startButton = new Button("Start");

    private final HomeController controller;

    public HomeView(HomeController controller) {
        this.controller = controller;
        startButton.setFont(new Font(24));
        super.setAlignment(CENTER);
        super.setBackground(new Background(new BackgroundFill(Color.BROWN, null, null)));
        menu.setAlignment(CENTER);
        startButton.setOnMouseClicked(event -> controller.startGame());
        StreamBuilder<HomeState, HomeController> streamBuilder = new StreamBuilder<>(controller) {
            @Override
            public Node builder(HomeState homeState) {
                if (!(homeState instanceof Idle)) return startButton;
                final int counter = ((Idle) homeState).getCount();
                startButton.setText("Start: " + counter);
                return startButton;
            }
        };

        menu.getChildren().add(streamBuilder);
        menu.translateYProperty().set(150);
        startButton.setPadding(new Insets(10, 20, 10, 20));
        getChildren().addAll(bgImage, menu);
    }
}
