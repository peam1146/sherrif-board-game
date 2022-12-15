package com.progmeth.project.sheriff.core.utils.view.controllers;

import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.subjects.BehaviorSubject;

import java.util.ArrayList;

/**
 * Controller that manages a state
 *
 * @param <S> State type
 */
public abstract class StateController<S> implements Disposable {

    /**
     * State stream
     */
    private final BehaviorSubject<S> stateStream;

    /**
     * State subscription
     */
    private final Disposable stateSub;

    /**
     * Current state
     */
    private S state;

    /**
     * List of disposable to dispose when this controller is disposed
     */
    private final ArrayList<Disposable> disposables = new ArrayList<>();

    /**
     * is this controller disposed
     */
    private boolean disposed = false;

    /**
     * Constructor
     *
     * @param initialState Initial state
     */
    public StateController(S initialState) {
        stateStream = BehaviorSubject.create();
        this.stateSub = stateStream.subscribe(this::setCurrentState);
        setState(initialState);
    }

    /**
     * Set the current state
     *
     * @param state New state
     */
    private void setCurrentState(S state) {
        this.state = state;
    }

    /**
     * Set and publish the state
     *
     * @param initialState New state
     */
    public void setState(S initialState) {
        stateStream.onNext(initialState);
    }

    /**
     * Get the current state
     *
     * @return Current state
     */
    public BehaviorSubject<S> getStateStream() {
        return stateStream;
    }

    /**
     * Get the current state
     *
     * @return Current state
     */
    public S getState() {
        return state;
    }

    /**
     * Add a disposable to dispose when this controller is disposed
     *
     * @param disposable Disposable to add
     */
    public void addDisposable(Disposable disposable) {
        disposables.add(disposable);
    }

    /**
     * Dispose this controller
     */
    public void dispose() {
        if (disposed) return;
        for (Disposable d : disposables) {
            d.dispose();
        }
        stateSub.dispose();
        disposed = true;
    }

    /**
     * Check if this controller is disposed
     *
     * @return true if this controller is disposed
     */
    @Override
    public boolean isDisposed() {
        return disposed;
    }
}
