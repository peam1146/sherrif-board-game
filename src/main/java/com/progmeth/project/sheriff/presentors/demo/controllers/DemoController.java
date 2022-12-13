package com.progmeth.project.sheriff.presentors.demo.controllers;

import com.progmeth.project.sheriff.core.utils.view.controllers.StateController;
import com.progmeth.project.sheriff.domain.game.repositories.RoomRepository;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;

import java.util.ArrayList;

public class DemoController extends StateController<Integer> {
    private final RoomRepository roomRepo;
    private String text;
    public DemoController(RoomRepository roomRepo) {
        super(0);
        this.roomRepo = roomRepo;
    }

    public void createRoom(String room) {
        setState(1);
        final Completable com = roomRepo.createRoom(room, 3000);
        com.doOnComplete(() -> {
            System.out.println("Room created");
            setState(2);
        }).doOnError((e) -> {
            System.out.println("Room creation failed");
            setState(3);
        }).subscribe();
    }

    public void joinRoom(String room) {
        System.out.println("Joining with  name" + text);
        final Single<ArrayList<String>> com = roomRepo.joinGame(room, text);
        com.doOnSuccess(value -> {
            System.out.println("Room joined");
            for (String s : value) {
                System.out.println(s);
            }
        }).doOnError((e) -> {
            System.out.println("Room join failed");
        }).subscribe();
    }

    public void startGame() {
        final Completable com = roomRepo.startGame();
        com.doOnComplete(() -> {
            System.out.println("Game started");
        }).doOnError((e) -> {
            System.out.println("Game start failed");
        }).subscribe();
    }

    public void getPlayers() {
        final Single<ArrayList<String>> players = roomRepo.getPlayers();
        players.doOnSuccess(value -> {
            for (String s : value) {
                System.out.println(s);
            }
        }).subscribe();
    }

    public void setText(String text) {
        this.text = text;
    }
}
