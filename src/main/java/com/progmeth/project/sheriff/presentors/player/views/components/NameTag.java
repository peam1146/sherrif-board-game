package com.progmeth.project.sheriff.presentors.player.views.components;

import com.progmeth.project.sheriff.presentors.common.GameFont;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class NameTag extends StackPane {
    private final Text name;
    public NameTag() {
        name = new Text("");
        name.setFont(new GameFont(12).getBlack());
        name.setFill(Color.rgb(96,58,51));
        name.setStyle("-fx-font-style: italic; ");

        getChildren().add(name);
        setMaxHeight(35);
        setMinWidth(100);
        setPadding(new Insets(5, 5, 5, 5));
        setAlignment(Pos.CENTER);
        setStyle("-fx-background-color: #DACAA6;");

    }

    public void setName(String name) {
        this.name.setText(name);
    }
}
