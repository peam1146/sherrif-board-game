package com.progmeth.project.sheriff.data.game.server.network;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;
import com.progmeth.project.sheriff.data.game.server.controller.GameRoomController;
import com.progmeth.project.sheriff.data.game.server.models.DTO.ItemDTO;
import com.progmeth.project.sheriff.data.game.server.models.request.*;
import com.progmeth.project.sheriff.data.game.server.models.response.*;

import java.io.IOException;
import java.util.ArrayList;

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
            if (!(object instanceof Request)) return;
            if (object instanceof  StartGameRequest ) {
                System.out.println("Received start game request");
                gameRoomController = gameControllerBuilder.build();
                connection.sendTCP(new StartGameResponse.Builder().setSuccess().build());
                return;
            }

            if (object instanceof final JoinRoomRequest req) {
                System.out.println("Received join room request");
                System.out.println("Player ID: " + req.playerName);
                gameControllerBuilder.addPlayer(req.playerName);
                connection.sendTCP(new JoinRoomResponse.Builder().setPlayerName(req.playerName).setPlayerNames(gameControllerBuilder.getPlayerNames()).setPlayerID(1).build());
                return;
            }

            if (object instanceof final GetHandRequest req) {
                System.out.println("Received get hand request");
                final var hand = gameRoomController.getHand(req.playerID);
                final ArrayList<ItemDTO> handDTO = gameRoomController.getHand(req.playerID).getItemsDTO();
                GetHandResponse resp = new GetHandResponse.Builder().setHand(handDTO).build();
                connection.sendTCP(resp);
                return;
            }

            if (object instanceof GetPlayersRequest) {
                System.out.println("Received get players request");
                final ArrayList<String> players = gameControllerBuilder.getPlayerNames();
                connection.sendTCP(new GetPlayersResponse.Builder().players(players).build());
                return;
            }

            if (object instanceof final DropAllCardsRequest req) {
                System.out.println("Received drop card request");
                gameRoomController.playerDropAll(req.playerID);
                connection.sendTCP(new DropAllCardsReponse());
                return;
            }

            if (object instanceof final DropCardRequest req) {
                System.out.println("Received drop card request");
                final var r = gameRoomController.playerDrop(req.playerID, req.cardName);

                if (r == null) {
                    connection.sendTCP(new DropCardResponse());
                    return;
                }

                final ArrayList<ItemDTO> handDTO = gameRoomController.getHand(req.playerID).getItemsDTO();
                connection.sendTCP(new DropCardResponse.Builder().setHand(handDTO));
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
