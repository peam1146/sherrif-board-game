package com.progmeth.project.sheriff.presentors.player.views.components;
        import com.progmeth.project.sheriff.presentors.common.GameFont;
        import com.progmeth.project.sheriff.presentors.common.components.BackCard;
        import com.progmeth.project.sheriff.presentors.common.components.Card;
        import com.progmeth.project.sheriff.presentors.common.components.IllegalCard;
        import com.progmeth.project.sheriff.presentors.common.components.LegalCard;
        import javafx.geometry.Insets;
        import javafx.geometry.Pos;
        import javafx.scene.layout.*;
        import javafx.scene.paint.Color;
        import javafx.scene.text.Font;
        import javafx.scene.text.FontWeight;
        import javafx.scene.text.Text;

public class SideBar extends VBox {
    public SideBar() {
        super.setStyle("-fx-background-color: #603A33;");
        super.setMinWidth(150);
        super.setHeight(536);
        super.setSpacing(10);
        super.setAlignment(Pos.CENTER);
        super.setPadding(new Insets(10, 10, 10, 10));
        Text text = new Text("Goods Deck");
        text.setFont(new GameFont(20).getBlack());
        text.setStyle("-fx-font-style: italic; ");

        StackPane goodsDeckBadge = new StackPane();
        goodsDeckBadge.getChildren().add(text);
        goodsDeckBadge.setMaxHeight(35);
        goodsDeckBadge.setPadding(new Insets(5, 5, 5, 5));
        goodsDeckBadge.setAlignment(Pos.CENTER);
        goodsDeckBadge.setStyle("-fx-background-color: #DACAA6;");

        Card card = new BackCard();
        Card card2 = new IllegalCard();
        Card card3 = new LegalCard();

        getChildren().addAll(goodsDeckBadge,card2,card,card3);
    }
}