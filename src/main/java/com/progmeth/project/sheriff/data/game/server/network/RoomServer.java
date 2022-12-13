package com.progmeth.project.sheriff.data.game.server.network;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;
import com.progmeth.project.sheriff.data.game.server.controller.GameRoomController;
import com.progmeth.project.sheriff.data.game.server.models.request.JoinRoomRequest;
import com.progmeth.project.sheriff.data.game.server.models.request.StartGameRequest;
import com.progmeth.project.sheriff.data.game.server.models.response.JoinRoomResponse;
import com.progmeth.project.sheriff.data.game.server.models.response.StartGameResponse;

import java.io.IOException;

public class RoomServer {
    private String roomName;
    private boolean isRunning = false;
    private final Server server;
    private static RoomServer serverInstance;
    private GameRoomController.GameControllerBuilder gameControllerBuilder;

    private GameRoomController gameRoomController;

    private class ServerListener extends Listener {

        @Override
        public void connected(Connection connection) {
            super.connected(connection);
        }

        @Override
        public void disconnected(Connection connection) {
            super.disconnected(connection);
        }

        @Override
        public void received(Connection connection, Object object) {
            System.out.println("Received");
            if (object instanceof StartGameRequest) {
                System.out.println("Received start game request");
                gameRoomController = gameControllerBuilder.build();
                connection.sendTCP(new StartGameResponse.Builder().setSuccess().build());
                return;
            }

            if (object instanceof JoinRoomRequest) {
                final JoinRoomRequest req = (JoinRoomRequest) object;
                System.out.println("Received join room request");
                gameControllerBuilder.addPlayer(req.playerName);
                connection.sendTCP(new JoinRoomResponse.Builder().setRoom("test").setPlayerID(1).build());
                return;
            }
        }
    }

    private RoomServer() {
        server = new Server();
    }

    public static RoomServer getInstance() {
        if (serverInstance == null) {
            serverInstance = new RoomServer();
        }
        return serverInstance;
    }

    private void register() {
        final Kryo kryo = server.getKryo();
        Serialize.register(kryo);
    }

    public void start() {
        gameControllerBuilder = new GameRoomController.GameControllerBuilder();
        server.start();
        server.addListener(new ServerListener());
        register();
    }


    public void bind(int tcpPort) throws IOException {
        server.bind(tcpPort);
    }

    public void close() {
        setRunning(false);
        server.close();
        server.stop();
    }

    public String getRoomName() {
        return roomName;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }
}
