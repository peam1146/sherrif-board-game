package com.progmeth.project.sheriff.core.utils.controllers;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.ReplaySubject;

import static io.reactivex.rxjava3.core.BackpressureStrategy.BUFFER;

public abstract class ViewControllers<E extends Event, S extends State> {
    private final PublishSubject<E> eventStream;
    private final ReplaySubject<S> stateStream;
    private final Disposable eventSub;
    private final Disposable stateSub;
    private S state;
    public ViewControllers(S initialState) {
        eventStream = PublishSubject.create();
        stateStream = ReplaySubject.create();
        this.eventSub = eventStream.subscribe(this::onEvent);
        this.stateSub = stateStream.subscribe(this::setCurrentState);
        setState(initialState);
    }
    protected abstract void onEvent(E e);

    public void setCurrentState(S state) {
        this.state = state;
    }

    public void setState(S state){
        stateStream.onNext(state);
    }

    public void addEvent(E event){
        eventStream.onNext(event);
    }

    public ReplaySubject<S> getStateStream() {
        return stateStream;
    }

    public PublishSubject<E> getEventStream() {
        return eventStream;
    }

    public void dispose() {
        eventSub.dispose();
        stateSub.dispose();
    }

    public S getState() {
        return state;
    }
}
