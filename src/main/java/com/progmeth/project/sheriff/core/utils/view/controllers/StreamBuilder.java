package com.progmeth.project.sheriff.core.utils.view.controllers;

import io.reactivex.rxjava3.disposables.Disposable;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class StreamBuilder<S, T extends StateController<S>> extends StackPane {
    private final T controller;
    private final Disposable stateSub;
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    public StreamBuilder(T controller) {
        this.controller = controller;
        this.stateSub = controller.getStateStream().subscribe(this::onState);
    }

    private void onState(S state) {
        executor.execute(() -> Platform.runLater(() -> onNode(builder(state))));
    }

    protected abstract Node builder(S state);

    private void onNode(Node node) {
        getChildren().clear();
        getChildren().add(node);
    }

    public void dispose() {
        stateSub.dispose();
        executor.shutdown();
    }

    public S getState() {
        return controller.getState();
    }
}
