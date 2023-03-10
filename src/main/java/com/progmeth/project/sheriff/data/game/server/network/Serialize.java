package com.progmeth.project.sheriff.data.game.server.network;

import com.esotericsoftware.kryo.Kryo;
import com.progmeth.project.sheriff.data.game.server.controller.DroppedDeckPos;
import com.progmeth.project.sheriff.data.game.server.models.DTO.ItemDTO;
import com.progmeth.project.sheriff.data.game.server.models.request.*;
import com.progmeth.project.sheriff.data.game.server.models.response.*;
import com.progmeth.project.sheriff.data.game.server.models.type.Type;
import com.progmeth.project.sheriff.domain.game.entity.ItemEntity;

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
                GetIsGameStartedRequest.class,
                GetIsGameStartedResponse.class,
                GetCurrentSheriffRequest.class,
                GetCurrentSheriffResponse.class,
                DrawCardResponse.class,
                DropCardRequest.class,
                DropCardResponse.class,
                DrawCardRequest.class,
                GetDroppedDeckTopResponse.class,
                GetDroppedDeckTopRequest.class,
                DrawFromDroppedRequest.class,
                DrawFromDroppedResponse.class,
                DroppedDeckPos.class,
//                ItemEntity.class,
                Type.class
        );
        for (var c : classes) {
            kryo.register(c);
        }
    }
}
