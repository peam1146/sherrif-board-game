package com.progmeth.project.sheriff.presentors.sheriff.views.components;

import com.progmeth.project.sheriff.presentors.common.GameFont;
import com.progmeth.project.sheriff.presentors.player.views.components.Money;
import io.reactivex.rxjava3.functions.Consumer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * Card pocket component
 */
public class CardPocket extends StackPane {

    /**
     * image path
     */
    private final static String IMG_CARD_POCKET = CardPocket.class.getResource("/com/progmeth/project/sheriff/images/card_back_pocket.png").toString();

    /**
     * name text
     */
    private Text name;

    /**
     * Constructor
     */
    public CardPocket() {
        setAlignment(Pos.CENTER_LEFT);
        ImageView cardPocket = new ImageView(IMG_CARD_POCKET);
        cardPocket.setFitHeight(84);
        cardPocket.setFitWidth(135);
        StackPane pocketOwnerNameTag = new StackPane();
        name = new Text("");
        name.setFont(new GameFont(12).getBlack());
        name.setFill(Color.rgb(96,58,51));
        name.setStyle("-fx-font-style: italic; ");

        pocketOwnerNameTag.getChildren().add(name);
        pocketOwnerNameTag.setMaxHeight(35);
        pocketOwnerNameTag.setMaxWidth(100);
        pocketOwnerNameTag.setPadding(new Insets(5, 5, 5, 5));
        pocketOwnerNameTag.setStyle("-fx-background-color: #DACAA6;");

        pocketOwnerNameTag.setTranslateY(65);
        pocketOwnerNameTag.setTranslateX(14);

        setMinHeight(84+65);

        Money bride = new Money();
        bride.setAmount(0);
        bride.setAlignment(Pos.CENTER_LEFT);
        bride.setTranslateX(165);
        setPadding(new Insets(10, 10, 10, 20));

        Button checkButton = new Button("Check");
        checkButton.setFont(new Font(16));
        checkButton.textFillProperty().setValue(Color.WHITE);
        checkButton.setStyle("-fx-background-color: #21070B;-fx-border-radius: 0;");
        checkButton.setTranslateX(300);
        checkButton.setOnAction(e -> {
            new Alert(Alert.AlertType.INFORMATION, "This pocket contains illegal goods!!! You can collect $6 fine!").show();
        });

        getChildren().addAll(cardPocket,pocketOwnerNameTag,bride,checkButton);


    }

    /**
     * Set name
     * @param name name
     */
    public void setName(String name) {
        this.name.setText(name);
    }
}
