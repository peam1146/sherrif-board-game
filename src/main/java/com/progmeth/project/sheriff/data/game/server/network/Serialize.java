package com.progmeth.project.sheriff.data.game.server.network;

import com.esotericsoftware.kryo.Kryo;
import com.progmeth.project.sheriff.data.game.server.models.DTO.ItemDTO;
import com.progmeth.project.sheriff.data.game.server.models.request.GetDrawFromDeckRequest;
import com.progmeth.project.sheriff.data.game.server.models.request.GetHandRequest;
import com.progmeth.project.sheriff.data.game.server.models.request.JoinRoomRequest;
import com.progmeth.project.sheriff.data.game.server.models.request.StartGameRequest;
import com.progmeth.project.sheriff.data.game.server.models.response.GetDrawFromDeckResponse;
import com.progmeth.project.sheriff.data.game.server.models.response.GetHandResponse;
import com.progmeth.project.sheriff.data.game.server.models.response.JoinRoomResponse;
import com.progmeth.project.sheriff.data.game.server.models.response.StartGameResponse;
import com.progmeth.project.sheriff.data.game.server.models.type.Type;

import java.util.List;

public class Serialize {
    public static void register(Kryo kryo) {
        //TODO: Add more classes here
        List<Class> classes = List.of(
                ItemDTO.class,
                GetDrawFromDeckRequest.class,
                GetDrawFromDeckResponse.class,
                StartGameRequest.class,
                StartGameResponse.class,
                GetHandRequest.class,
                GetHandResponse.class,
                JoinRoomRequest.class,
                JoinRoomResponse.class,
                Type.class
        );
        for (var c : classes) {
            kryo.register(c);
        }
    }
}
