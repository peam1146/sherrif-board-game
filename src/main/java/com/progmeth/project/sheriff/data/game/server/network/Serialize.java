package com.progmeth.project.sheriff.data.game.server.network;

import com.esotericsoftware.kryo.Kryo;
import com.progmeth.project.sheriff.data.game.server.models.DTO.ItemDTO;
import com.progmeth.project.sheriff.data.game.server.models.request.*;
import com.progmeth.project.sheriff.data.game.server.models.response.*;
import com.progmeth.project.sheriff.data.game.server.models.type.Type;

import java.util.ArrayList;
import java.util.List;

/**
 * Serializer for network
 */
public class Serialize {
    /**
     * Constructor
     */
    public Serialize() {
    }

    /**
     * Register classes
     *
     * @param kryo kryo
     */
    public static void register(Kryo kryo) {
        //TODO: Add more classes here
        List<Class> classes = List.of(
                ItemDTO.class,
                ArrayList.class,
                GetPlayersRequest.class,
                GetPlayersResponse.class,
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
