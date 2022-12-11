package com.progmeth.project.sheriff.data.game.server;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;
import com.progmeth.project.sheriff.data.game.server.models.request.Request;
import com.progmeth.project.sheriff.data.game.server.models.response.ItemResponse;

import java.io.IOException;

public class MainServer {
    private final Server server;
    private static MainServer serverInstance;

    private MainServer() {
        server = new Server();
    }

    public static MainServer getInstance() {
        if (serverInstance == null) {
            serverInstance = new MainServer();
        }
        return serverInstance;
    }

    private void setup() {
        final var kryo = server.getKryo();
        kryo.register(ItemResponse.class);
        kryo.register(Request.class);
    }

    public void start() {
        server.start();
        server.addListener(new Listener() {
            public void received(Connection connection, Object object) {
                if (object instanceof Request) {
                    ItemResponse response = new ItemResponse();
                    response.imgURL = 1;
                    connection.sendTCP(response);
                }
            }
        });
        setup();
    }

    public void bind(int tcpPort) throws IOException {
        server.bind(tcpPort);
    }

    public void close() {
        server.close();
    }


}
