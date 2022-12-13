package com.progmeth.project.sheriff.data.game.server.controller;

import com.progmeth.project.sheriff.data.game.models.base.Item;
import com.progmeth.project.sheriff.data.game.models.derive.deck.DroppedDeck;
import com.progmeth.project.sheriff.data.game.models.derive.deck.MainCardDeck;
import com.progmeth.project.sheriff.data.game.models.derive.hand.Hand;
import com.progmeth.project.sheriff.data.game.models.derive.market.Market;

import java.util.ArrayList;
import java.util.Random;

public class GameRoomController {
    private final int playerCount;
    private final String[] playerNames;
    private final Hand[] hands;
    private final MainCardDeck deck;
    private final DroppedDeck[] droppedDecks;
    private final Market[] markets;

    private int turn = 0;

    private int timer = 0;
    private final int maxTimer = 60;

    public GameRoomController(int playerCount, String[] playerNames) {
        this.playerCount = playerCount;
        this.playerNames = playerNames;
        this.hands = new Hand[playerCount];
        this.deck = new MainCardDeck();
        this.droppedDecks = new DroppedDeck[2];
        this.markets = new Market[playerCount];
    }

    public int getCurrentSheriff() {
        return turn % playerCount;
    }

    public void nextTurn() {
        turn++;
    }

    public Hand getHand(int player) {
        return hands[player];
    }

    public Market getMarket(int player) {
        return markets[player];
    }

    public DroppedDeck getDroppedDeck(DroppedDeckPos pos) {
        return droppedDecks[pos.ordinal()];
    }

    public Item playerDraw(int player) {
        if (player != getCurrentSheriff()) return null;
        Item i = deck.draw();
        hands[player].add(i);
        return i;
    }

    public Item playerDrawFromDropped(int player, DroppedDeckPos pos) {
        if (player != getCurrentSheriff()) return null;
        Item i = droppedDecks[pos.ordinal()].draw();
        hands[player].add(i);
        return i;
    }

    public Item playerDrop(int player, Item i) {
        if (player != getCurrentSheriff()) return null;
        hands[player].remove(i);
        final int pos = new Random().nextInt(2);
        droppedDecks[pos].add(i);
        return i;
    }

    public void placeItem(int player, Item i) {
        if (player != getCurrentSheriff()) return;
        hands[player].remove(i);
        markets[player].add(i);
    }

    public static class GameControllerBuilder {
        private final ArrayList<String> playerNames = new ArrayList<>();


        public GameControllerBuilder addPlayer(String name) {
            if (playerNames.size() < 5) playerNames.add(name);
            return this;
        }

        public GameRoomController build() {
            final var arr = playerNames.toArray(new String[0]);
            return new GameRoomController(playerNames.size(), arr);
        }
    }
}
