package com.progmeth.project.sheriff.core.utils.controllers;

import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.subjects.BehaviorSubject;

public class StateController<S> {
    private final BehaviorSubject<S> stateStream;
    private final Disposable stateSub;
    private S state;
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
    public void dispose() {
        stateSub.dispose();
    }
}
