package com.progmeth.project.sheriff.data.game.server.network;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.progmeth.project.sheriff.data.game.server.models.request.GetHandRequest;
import com.progmeth.project.sheriff.data.game.server.models.request.JoinRoomRequest;
import com.progmeth.project.sheriff.data.game.server.models.request.StartGameRequest;
import com.progmeth.project.sheriff.data.game.server.models.response.GetHandResponse;
import com.progmeth.project.sheriff.data.game.server.models.response.JoinRoomResponse;
import com.progmeth.project.sheriff.data.game.server.models.response.Response;
import com.progmeth.project.sheriff.data.game.server.models.response.StartGameResponse;
import io.reactivex.rxjava3.subjects.PublishSubject;

import java.io.IOException;

public class RoomClient {
    private int PlayerID;
    private Client client;
    private boolean isRunning = false;
    private static RoomClient clientInstance;
    private PublishSubject<Response> responseSubject = PublishSubject.create();


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
        }

        @Override
        public void disconnected(Connection connection) {
            super.disconnected(connection);
        }
    }

    private RoomClient() {
        client = new Client();
    }

    public static RoomClient getInstance() {
        if (clientInstance == null) {
            clientInstance = new RoomClient();
        }
        return clientInstance;
    }

    private void register() {
        final Kryo kryo = client.getKryo();
        Serialize.register(kryo);
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    public boolean getRunning() {
        return isRunning;
    }

    public void start() {
        setRunning(true);
        client.start();
        client.addListener(new ClientListener());
        register();
    }
    public void setup() {
        start();
        try {
            connecct("localhost", 3000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void connecct(String host, int tcpPort) throws IOException {
        client.connect(5000, host, tcpPort);
    }

    public void joinRoom(String roomName) {
        JoinRoomRequest request = new JoinRoomRequest.Builder().setRoom(roomName).build();
        client.sendTCP(request);
    }

    public void stop() {
        setRunning(false);
        client.stop();
    }

    public void startGame() {
        final StartGameRequest request = new StartGameRequest();
        client.sendTCP(request);
    }

    public void setPlayerID(int playerID) {
        PlayerID = playerID;
    }

    public void getHand(int playerID) {
        final GetHandRequest request = new GetHandRequest.Builder().setPlayerID(playerID).build();
        client.sendTCP(request);
    }

    public PublishSubject<Response> getResponseSubject() {
        return responseSubject;
    }

}
