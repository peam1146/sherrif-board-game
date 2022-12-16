package com.progmeth.project.sheriff.presentors.home.views;

import com.progmeth.project.sheriff.core.utils.view.controllers.StreamBuilder;
import com.progmeth.project.sheriff.presentors.common.GameFont;
import com.progmeth.project.sheriff.presentors.home.controllers.HomeController;
import com.progmeth.project.sheriff.presentors.home.controllers.states.HomeState;
import com.progmeth.project.sheriff.presentors.home.controllers.states.Idle;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import static javafx.geometry.Pos.CENTER;

public class HomeView extends StackPane {
    private final static String BG_IMG = HomeView.class.getResource("/com/progmeth/project/sheriff/images/bg.png").toString();
    private final Button joinButton = new Button("Join");
    private final Button createRoomButton = new Button("Create Room");

    private final HomeController controller;


    public HomeView(HomeController controller) {
        this.controller = controller;
        joinButton.setFont(new Font(24));
        joinButton.textFillProperty().setValue(Color.WHITE);
        joinButton.setBackground(new Background(new BackgroundFill(Color.rgb(33,7,11), null, null)));
        super.setAlignment(CENTER);
        super.setBackground(new Background(new BackgroundFill(Color.BROWN, null, null)));
        VBox menu = new VBox();
        menu.setAlignment(CENTER);
        StreamBuilder<HomeState, HomeController> streamBuilder = new StreamBuilder<>(controller) {
            @Override
            public Node builder(HomeState homeState) {
                if (!(homeState instanceof Idle)) return joinButton;
                final int counter = ((Idle) homeState).getCount();
                joinButton.setText("Start: " + counter);
                return joinButton;
            }
        };

        menu.getChildren().addAll(streamBuilder);
        joinButton.setPadding(new Insets(10, 20, 10, 20));
        ImageView bgImage = new ImageView(BG_IMG);
        bgImage.setFitHeight(610);
        bgImage.setFitWidth(800);

        //////
        Font font = new GameFont(18).getBold();

        Button createRoom = new Button("Create Room");
        Button joinRoom = new Button("Join Game");

        createRoom.setFont(font);
        createRoom.setTextFill(Color.WHITE);
        joinRoom.setFont(font);
        joinRoom.setTextFill(Color.WHITE);

        String buttonStyle = "-fx-background-color: #603A33;-fx-padding: 10px 20px 10px 20px;";

        createRoom.setStyle(buttonStyle);
        joinRoom.setStyle(buttonStyle);

        createRoom.setOnMouseClicked(event -> controller.createRoom());
        joinRoom.setOnMouseClicked(event -> controller.joinRoom());

        HBox buttonBox = new HBox();
        buttonBox.setSpacing(20);
        buttonBox.getChildren().addAll(createRoom, joinRoom);
        buttonBox.setAlignment(CENTER);
        buttonBox.setTranslateY(150);
        getChildren().addAll(bgImage,buttonBox);
    }
}
