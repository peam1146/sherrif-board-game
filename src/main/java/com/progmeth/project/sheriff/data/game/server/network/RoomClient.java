package com.progmeth.project.sheriff.data.game.server.network;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.progmeth.project.sheriff.data.game.server.models.request.*;
import com.progmeth.project.sheriff.data.game.server.models.response.*;
import io.reactivex.rxjava3.subjects.PublishSubject;

import java.io.IOException;

/**
 * Room client
 */
public class RoomClient {
    /**
     * player id
     */
    private int playerID;
    /**
     * network client
     */
    private Client client;
    /**
     * is client running
     */
    private boolean isRunning = false;
    /**
     * instance of this class
     */
    private static RoomClient clientInstance;
    /**
     * response publisher
     */
    private PublishSubject<Response> responseSubject = PublishSubject.create();


    /**
     * Listener for client
     */
    private class ClientListener extends Listener {

        @Override
        public void connected(Connection connection) {
            super.connected(connection);
        }

        @Override
        public void received(Connection connection, Object object) {
            if (!(object instanceof Response)) return;
            if (object instanceof GetHandResponse) {
                System.out.println("Received GetHandResponse");
                clientInstance.responseSubject.onNext((Response) object);
                return;
            }

            if (object instanceof JoinRoomResponse) {
                System.out.println("Received JoinRoomResponse");
                clientInstance.responseSubject.onNext((Response) object);
                return;
            }

            if (object instanceof StartGameResponse) {
                System.out.println("Received StartGameResponse");
                clientInstance.responseSubject.onNext((Response) object);
                return;
            }

            if (object instanceof GetPlayersResponse) {
                System.out.println("Received GetPlayersResponse");
                clientInstance.responseSubject.onNext((Response) object);
                return;
            }

            if (object instanceof DropCardResponse) {
                System.out.println("Received DropCardResponse");
                clientInstance.responseSubject.onNext((Response) object);
                return;
            }
        }

        @Override
        public void disconnected(Connection connection) {
            super.disconnected(connection);
        }
    }

    /**
     * Constructor
     */
    private RoomClient() {
        client = new Client();
    }

    /**
     * Get instance of this class
     * @return instance of this class
     */
    public static RoomClient getInstance() {
        if (clientInstance == null) {
            clientInstance = new RoomClient();
        }
        return clientInstance;
    }

    /**
     * register class
     */
    private void register() {
        final Kryo kryo = client.getKryo();
        Serialize.register(kryo);
    }

    /**
     * set is running
     * @param running is running
     */
    public void setRunning(boolean running) {
        isRunning = running;
    }

    /**
     * get is running
     * @return is running
     */
    public boolean getRunning() {
        return isRunning;
    }

    /**
     * start client
     */
    public void start() {
        setRunning(true);
        client.start();
        client.addListener(new ClientListener());
        register();
    }

    /**
     * setup client
     */
    public void setup() {
        start();
        try {
            connect("localhost", 3000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * connect to server
     * @param host host
     * @param tcpPort port
     * @throws IOException exception
     */
    public void connect(String host, int tcpPort) throws IOException {
        client.connect(5000, host, tcpPort);
    }

    /**
     * join room server
     * @param roomName room name
     */
    public void joinRoom(String roomName) {
        final JoinRoomRequest request = new JoinRoomRequest.Builder().setPlayerName(roomName).build();
        client.sendTCP(request);
    }

    /**
     * stop client
     */
    public void stop() {
        setRunning(false);
        client.close();
        client.stop();
    }

    /**
     * get players in room
     */
    public void getPlayers() {
        final GetPlayersRequest request = new GetPlayersRequest();
        client.sendTCP(request);
    }

    /**
     * start game
     */
    public void startGame() {
        final StartGameRequest request = new StartGameRequest();
        client.sendTCP(request);
    }

    /**
     * set player id
     * @param playerID player id
     */
    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    /**
     * get card in player hand
     */
    public void getHand() {
        final GetHandRequest request = new GetHandRequest.Builder().setPlayerID(playerID).build();
        client.sendTCP(request);
    }

    /**
     * drop all cards in hand
     */
    public void dropAllCards() {
        final DropAllCardsRequest request = new DropAllCardsRequest.Builder().setPlayerID(playerID).build();
        client.sendTCP(request);
    }

    /**
     * drop card in hand
     * @param cardName card name
     */
    public void dropCard(String cardName) {
        final DropCardRequest request = new DropCardRequest.Builder().setPlayerID(playerID).setCardName(cardName).build();
        client.sendTCP(request);
    }

    /**
     * get response publisher
     * @return response publisher
     */
    public PublishSubject<Response> getResponseSubject() {
        return responseSubject;
    }

}
