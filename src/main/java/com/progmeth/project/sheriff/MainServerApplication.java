package com.progmeth.project.sheriff;

import com.progmeth.project.sheriff.data.game.server.MainServer;

public class MainServerApplication {
    public static void main(String[] args) {
        MainServer.getInstance().start();
    }
}
