package com.progmeth.project.sheriff.presentors.player.views.components;
        import com.progmeth.project.sheriff.core.utils.view.controllers.StreamBuilder;
        import com.progmeth.project.sheriff.domain.game.entity.ItemEntity;
        import com.progmeth.project.sheriff.presentors.common.GameFont;
        import com.progmeth.project.sheriff.presentors.common.ItemImg;
        import com.progmeth.project.sheriff.presentors.common.components.BackCard;
        import com.progmeth.project.sheriff.presentors.common.components.Card;
        import com.progmeth.project.sheriff.presentors.player.controllers.PlayerController;
        import com.progmeth.project.sheriff.presentors.player.controllers.states.PlayerState;
        import javafx.geometry.Insets;
        import javafx.geometry.Pos;
        import javafx.scene.Node;
        import javafx.scene.layout.*;
        import javafx.scene.paint.Color;
        import javafx.scene.text.Text;

public class SideBar extends VBox {
    public SideBar(PlayerController controller) {
        super.setStyle("-fx-background-color: #603A33;");
        super.setMinWidth(150);
        super.setHeight(536);
        super.setSpacing(10);
        super.setAlignment(Pos.CENTER);
        super.setPadding(new Insets(10, 10, 10, 10));
        Text text = new Text("Goods Deck");
        text.setFont(new GameFont(14).getBlack());
        text.setFill(Color.rgb(96,58,51));
        text.setStyle("-fx-font-style: italic; ");

        StackPane goodsDeckBadge = new StackPane();
        goodsDeckBadge.getChildren().add(text);
        goodsDeckBadge.setMinHeight(35);
        goodsDeckBadge.setPadding(new Insets(5, 5, 5, 5));
        goodsDeckBadge.setAlignment(Pos.CENTER);
        goodsDeckBadge.setStyle("-fx-background-color: #DACAA6;");

        ItemEntity item = new ItemEntity(8, "test", false, 4,10, ItemImg.CHICKEN);
        ItemEntity item2 = new ItemEntity(8, "test", true, 4,10, ItemImg.CHICKEN);

        Card card = new BackCard(item);
        Card topDrop = new Card(item);
        Card bottomDrop = new Card(item2);

        StreamBuilder<PlayerState, PlayerController> topDropStreamBuilder = new StreamBuilder<>(controller){
            @Override
            public Node builder(PlayerState state) {
                topDrop.setItem(state.topDroppedDeck);
                return topDrop;
            }
        };

        StreamBuilder<PlayerState, PlayerController> bottomDropStreamBuilder = new StreamBuilder<>(controller){
            @Override
            public Node builder(PlayerState state) {
                bottomDrop.setItem(state.bottomDroppedDeck);
                return bottomDrop;
            }
        };

        getChildren().addAll(goodsDeckBadge,topDropStreamBuilder,card,bottomDropStreamBuilder);
    }
}