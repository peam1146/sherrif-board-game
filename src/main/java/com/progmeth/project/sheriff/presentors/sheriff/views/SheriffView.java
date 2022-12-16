package com.progmeth.project.sheriff.presentors.sheriff.views;

import com.progmeth.project.sheriff.core.utils.view.controllers.StreamBuilder;
import com.progmeth.project.sheriff.presentors.player.controllers.PlayerController;
import com.progmeth.project.sheriff.presentors.player.views.components.SideBar;
import com.progmeth.project.sheriff.presentors.sheriff.controllers.SheriffController;
import com.progmeth.project.sheriff.presentors.sheriff.controllers.states.SheriffState;
import com.progmeth.project.sheriff.presentors.sheriff.views.components.Inspect;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

/**
 * Sheriff view
 */
public class SheriffView extends BorderPane {
    /**
     * controller
     */
    private final SheriffController controller;

    /**
     * Constructor
     *
     * @param controller controller
     */
    public SheriffView(SheriffController controller, PlayerController playerController) {
        this.controller = controller;
        super.setStyle("-fx-background-color: #E6DCC2;");
        Text text = new Text("Player View");
        SideBar sideBar = new SideBar(playerController);
        super.setLeft(sideBar);
        Inspect inspect = new Inspect(controller);

        StreamBuilder<SheriffState,SheriffController> inspectStreamBuilder = new StreamBuilder<>(controller){
            @Override
            public Node builder(SheriffState state) {
                inspect.clear();
                for (String player : state.players) {
                    inspect.addPlayer(player, 0);
                }
                return inspect;
            }
        };

        super.setCenter(inspectStreamBuilder);
        getChildren().addAll(text);

    }
}
