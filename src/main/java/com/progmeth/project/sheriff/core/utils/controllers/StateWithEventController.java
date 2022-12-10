package com.progmeth.project.sheriff.core.utils.controllers;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.subjects.PublishSubject;

public abstract class StateWithEventController<E, S> extends StateController<S> {
    private final PublishSubject<E> eventStream;
    private final Disposable eventSub;
    public StateWithEventController(S initialState) {
        super(initialState);
        eventStream = PublishSubject.create();
        this.eventSub = eventStream.subscribe(this::onEvent);
    }


    protected abstract void onEvent(E e);

    public void addEvent(E event){
        eventStream.onNext(event);
    }

    public PublishSubject<E> getEventStream() {
        return eventStream;
    }

    @Override
    public void dispose() {
        eventSub.dispose();
        super.dispose();
    }
}
