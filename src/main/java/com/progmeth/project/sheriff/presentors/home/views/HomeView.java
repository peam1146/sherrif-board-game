package com.progmeth.project.sheriff.presentors.home.views;

import com.progmeth.project.sheriff.core.utils.view.controllers.StreamBuilder;
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

/**
 * Home view
 */
public class HomeView extends StackPane {
    /**
     * background img path
     */
    private final static String BG_IMG = HomeView.class.getResource("/com/progmeth/project/sheriff/images/bg.png").toString();
    /**
     * start button
     */
    private final Button startButton = new Button("Start");

    /**
     * controller
     */
    private final HomeController controller;

    /**
     * Constructor
     * @param controller controller
     */
    public HomeView(HomeController controller) {
        this.controller = controller;
        startButton.setFont(new Font(24));
        startButton.textFillProperty().setValue(Color.WHITE);
        startButton.setBackground(new Background(new BackgroundFill(Color.rgb(33,7,11), null, null)));
        super.setAlignment(CENTER);
        super.setBackground(new Background(new BackgroundFill(Color.BROWN, null, null)));
        VBox menu = new VBox();
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
        ImageView bgImage = new ImageView(BG_IMG);
        bgImage.setFitHeight(610);
        bgImage.setFitWidth(800);
        getChildren().addAll(bgImage, menu);
    }
}
