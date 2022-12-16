package com.progmeth.project.sheriff.data.game.server.network;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;
import com.progmeth.project.sheriff.data.game.models.base.Illegal;
import com.progmeth.project.sheriff.data.game.models.base.Item;
import com.progmeth.project.sheriff.data.game.models.base.Legal;
import com.progmeth.project.sheriff.data.game.server.controller.DroppedDeckPos;
import com.progmeth.project.sheriff.data.game.server.controller.GameRoomController;
import com.progmeth.project.sheriff.data.game.server.models.DTO.ItemDTO;
import com.progmeth.project.sheriff.data.game.server.models.request.*;
import com.progmeth.project.sheriff.data.game.server.models.response.*;
import com.progmeth.project.sheriff.domain.game.entity.ItemEntity;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Room server
 */
public class RoomServer {

    /**
     * room name
     */
    private String roomName;
    /**
     * is server running
     */
    private boolean isRunning = false;
    /**
     * network server
     */
    private final Server server;
    /**
     * instance of this class
     */
    private static RoomServer serverInstance;
    /**
     * game builder
     */
    private GameRoomController.GameControllerBuilder gameControllerBuilder;

    /**
     * game controller
     */
    private GameRoomController gameRoomController;

    /**
     * Listener for server
     */
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
            System.out.println("Received " + object.getClass().getName());
            if (!(object instanceof Request)) return;
            if (object instanceof StartGameRequest) {
                System.out.println("Received start game request");
                gameRoomController = gameControllerBuilder.build();
                connection.sendTCP(new StartGameResponse.Builder().setSuccess().build());
                return;
            }

            if (object instanceof final JoinRoomRequest req) {
                System.out.println("Received join room request");
                System.out.println("Player ID: " + req.playerName);
                gameControllerBuilder.addPlayer(req.playerName);
                connection.sendTCP(new JoinRoomResponse.Builder().setPlayerName(req.playerName).setPlayerNames(gameControllerBuilder.getPlayerNames()).setPlayerID(gameControllerBuilder.getPlayerNames().size()-1).build());
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
                connection.sendTCP(new DropCardResponse.Builder().setHand(handDTO).build());
            }

            if(object instanceof GetIsGameStartedRequest){
                System.out.println("Received getIsGameStarted request");
                connection.sendTCP(new GetIsGameStartedResponse.Builder().isGameStarted(gameRoomController != null).build());
            }

            if(object instanceof GetCurrentSheriffRequest){
                System.out.println("Received GetCurrentSheriff Request");
                connection.sendTCP(new GetCurrentSheriffResponse.Builder().setCurrentSheriff(gameRoomController.getCurrentSheriff()).build());
            }

            if (object instanceof final DrawCardRequest req) {
                System.out.println("Received draw card request");
                gameRoomController.playerDraw(req.playerID,req.amount);
                final ArrayList<ItemDTO> hand = gameRoomController.getHand(req.playerID).getItemsDTO();
                connection.sendTCP(new DrawCardResponse.Builder().setHand(hand).build());
            }

            if( object instanceof GetDroppedDeckTopRequest ){
                System.out.println("Received get dropped deck top request");
                int fine = 0;
                int timeCost = 0;
                final Item topDeck = gameRoomController.getDroppedDeck(DroppedDeckPos.TOP).top();
                if (topDeck instanceof final Legal legal)
                    fine = legal.getTimeCost();
                if (topDeck instanceof final Illegal illegal)
                    fine = illegal.getFine();
                ItemDTO topDeckEntity =  new ItemDTO.Builder().setName(topDeck.getName()).setFine(fine).setTimeCost(timeCost).setIsLegal(topDeck instanceof Legal).build();
                final Item bottomDeck = gameRoomController.getDroppedDeck(DroppedDeckPos.BOTTOM).top();
                if (bottomDeck instanceof final Legal legal)
                    fine = legal.getTimeCost();
                if (bottomDeck instanceof final Illegal illegal)
                    fine = illegal.getFine();
                ItemDTO bottomDeckEntity = new ItemDTO.Builder().setName(bottomDeck.getName()).setFine(fine).setTimeCost(timeCost).setIsLegal(bottomDeck instanceof Legal).build();
                connection.sendTCP(new GetDroppedDeckTopResponse.Builder().setDroppedDeckTop(topDeckEntity,bottomDeckEntity).build());
            }

            if(object instanceof final DrawFromDroppedRequest req){
                System.out.println("Received draw from dropped request");
                gameRoomController.playerDrawFromDropped(req.playerID,req.pos);
                connection.sendTCP(new DrawFromDroppedResponse());
            }
        }
    }

    /**
     * Constructor
     */
    private RoomServer() {
        server = new Server();
    }

    /**
     * get instance of this class
     *
     * @return instance
     */
    public static RoomServer getInstance() {
        if (serverInstance == null) {
            serverInstance = new RoomServer();
        }
        return serverInstance;
    }

    /**
     * register classes
     */
    private void register() {
        final Kryo kryo = server.getKryo();
        Serialize.register(kryo);
    }

    /**
     * start server
     */
    public void start() {
        gameControllerBuilder = new GameRoomController.GameControllerBuilder();
        server.start();
        server.addListener(new ServerListener());
        register();
    }


    /**
     * bind server to port
     *
     * @param tcpPort port
     * @throws IOException if port is already in use
     */
    public void bind(int tcpPort) throws IOException {
        server.bind(tcpPort);
    }

    /**
     * stop server
     */
    public void close() {
        setRunning(false);
        server.close();
        server.stop();
    }

    /**
     * get room name
     *
     * @return room name
     */
    public String getRoomName() {
        return roomName;
    }

    /**
     * is server running
     *
     * @return is server running
     */
    public boolean isRunning() {
        return isRunning;
    }

    /**
     * set room name
     *
     * @param roomName room name
     */
    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    /**
     * set is server running
     *
     * @param running is server running
     */
    public void setRunning(boolean running) {
        isRunning = running;
    }
}
