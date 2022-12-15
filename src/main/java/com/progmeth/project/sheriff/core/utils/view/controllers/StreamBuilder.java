package com.progmeth.project.sheriff.core.utils.view.controllers;

import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * UI controller that builds a node from a state
 * @param <S> State type
 * @param <T> Controller type
 */
public abstract class StreamBuilder<S, T extends StateController<S>> extends StackPane {
    /**
     * State controller
     */
    private final T controller;

    /**
     * Executor service
     */
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    /**
     * Constructor
     * @param controller controller
     */
    public StreamBuilder(T controller) {
        this.controller = controller;
        controller.addDisposable(controller.getStateStream().subscribe(this::onState));
    }

    /**
     * Called when a new state is received
     * @param state
     */
    private void onState(S state) {
        executor.execute(() -> Platform.runLater(() -> onNode(builder(state))));
    }

    /**
     * Called when a new state is emitted then update the node to display
     *
     * @param state newState
     * @return node to display
     */
    protected abstract Node builder(S state);

    /**
     * Called when a new node is built
     * @param node
     */
    private void onNode(Node node) {
        getChildren().clear();
        getChildren().add(node);
    }

    /**
     * Get the state from controller
     * @return state
     */
    public S getState() {
        return controller.getState();
    }
}
