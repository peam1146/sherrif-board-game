package com.progmeth.project.sheriff.presentors.sheriff.views;

        import com.progmeth.project.sheriff.presentors.player.controllers.PlayerController;
        import com.progmeth.project.sheriff.presentors.player.views.components.PlayerBoard;
        import com.progmeth.project.sheriff.presentors.player.views.components.SideBar;
        import com.progmeth.project.sheriff.presentors.sheriff.controllers.SheriffController;
        import com.progmeth.project.sheriff.presentors.sheriff.views.components.Inspect;
        import javafx.scene.layout.BorderPane;
        import javafx.scene.text.Text;

public class SheriffView extends BorderPane {
    private final SheriffController controller;
    public SheriffView(SheriffController controller){
        this.controller = controller;
        super.setStyle("-fx-background-color: #E6DCC2;");
        Text text = new Text("Player View");
//        SideBar sideBar = new SideBar(controller);
//        super.setLeft(sideBar);
        super.setCenter(new Inspect());
        getChildren().addAll(text);
    }
}
