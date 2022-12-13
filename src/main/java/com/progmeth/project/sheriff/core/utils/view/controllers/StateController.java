package com.progmeth.project.sheriff.core.utils.view.controllers;

import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.subjects.BehaviorSubject;

import java.util.ArrayList;

public abstract class StateController<S> implements Disposable {
    private final BehaviorSubject<S> stateStream;
    private final Disposable stateSub;
    private S state;
    private final ArrayList<Disposable> disposables = new ArrayList<>();
    private boolean disposed = false;
    public StateController(S initialState) {
        stateStream = BehaviorSubject.create();
        this.stateSub = stateStream.subscribe(this::setCurrentState);
        setState(initialState);
    }
    private void setCurrentState(S state) {
        this.state = state;
    }
    public void setState(S initialState) {
        stateStream.onNext(initialState);
    }
    public BehaviorSubject<S> getStateStream() {
        return stateStream;
    }
    public S getState() {
        return state;
    }
    public void addDisposable(Disposable disposable) {
        disposables.add(disposable);
    }
    public void dispose() {
        if (disposed) return;
        for (Disposable d : disposables) {
            d.dispose();
        }
        stateSub.dispose();
        disposed = true;
    }

    @Override
    public boolean isDisposed() {
        return disposed;
    }
}
