package com.progmeth.project.sheriff.core.utils.view.controllers;

import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.subjects.PublishSubject;

/**
 * Controller that manages a state with events
 *
 * @param <E> Event type
 * @param <S> State type
 */
public abstract class StateWithEventController<E, S> extends StateController<S> {

    /**
     * Event stream
     */
    private final PublishSubject<E> eventStream;

    /**
     * Event subscription
     */
    private final Disposable eventSub;

    /**
     * Constructor
     *
     * @param initialState initial state
     */
    public StateWithEventController(S initialState) {
        super(initialState);
        eventStream = PublishSubject.create();
        this.eventSub = eventStream.subscribe(this::onEvent);
    }


    /**
     * Called when an event is received
     *
     * @param event event
     */
    protected abstract void onEvent(E event);

    /**
     * Emit an event
     *
     * @param event event
     */
    public void addEvent(E event) {
        eventStream.onNext(event);
    }

    /**
     * Get event stream
     *
     * @return event stream
     */
    public PublishSubject<E> getEventStream() {
        return eventStream;
    }

    /**
     * Dispose this controller
     */
    @Override
    public void dispose() {
        super.dispose();
        eventSub.dispose();
    }
}
