package com.progmeth.project.sheriff.data.game.server;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;
import com.progmeth.project.sheriff.data.game.server.models.request.JoinRoomRequest;
import com.progmeth.project.sheriff.data.game.server.models.request.Request;
import com.progmeth.project.sheriff.data.game.server.models.response.JoinRoomResponse;
import com.progmeth.project.sheriff.data.game.server.models.type.Type;

import java.io.IOException;

public class RoomServer {
    private String roomName;
    private boolean isRunning = false;
    private final Server server;
    private static RoomServer serverInstance;

    private static class ServerListener extends Listener {

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
            if (object instanceof Request) {
                System.out.println(((Request) object).getTopic());
                System.out.println("Sending");
                connection.sendTCP(new JoinRoomResponse.Builder().setRoom("test").build());
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
        final var kryo = server.getKryo();
        //TODO: Register all classes
        kryo.register(JoinRoomRequest.class);
        kryo.register(JoinRoomResponse.class);
        kryo.register(Type.class);
    }

    public void start() {
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
