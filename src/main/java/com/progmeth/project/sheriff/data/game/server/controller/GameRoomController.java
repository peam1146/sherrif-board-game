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
    private final ArrayList<String> playerNames;
    private final ArrayList<Hand> hands;
    private final MainCardDeck deck;
    private final DroppedDeck[] droppedDecks = new DroppedDeck[2];
    private final ArrayList<Market> markets;

    private int turn = 0;

    private int timer = 0;
    private final int maxTimer = 60;

    public GameRoomController(int playerCount, ArrayList<String> playerNames) {
        this.playerCount = playerCount;
        this.playerNames = playerNames;
        this.hands = new ArrayList<>();
        for (int i = 0; i < playerCount; i++) {
            this.hands.add(new Hand());
        }
        this.deck = new MainCardDeck();
//        this.droppedDecks = new DroppedDeck[2];
        this.droppedDecks[DroppedDeckPos.TOP.ordinal()]= new DroppedDeck();
        this.droppedDecks[DroppedDeckPos.BOTTOM.ordinal()] = new DroppedDeck();

        this.markets = new ArrayList<>();
    }

    public int getCurrentSheriff() {
        return turn % playerCount;
    }

    public void nextTurn() {
        turn++;
    }

    public Hand getHand(int player) {
        return hands.get(player);
    }

    public Market getMarket(int player) {
        return markets.get(player);
    }

    public DroppedDeck getDroppedDeck(DroppedDeckPos pos) {
        return droppedDecks[pos.ordinal()];
    }

    public Hand playerDraw(int player,int amount) {
        if (player != getCurrentSheriff()) return null;
        for (int i = 0; i < amount; i++) {
            Item item = deck.draw();
            hands.get(player).add(item);
        }
        return hands.get(player);
    }

    public Item playerDrawFromDropped(int player, DroppedDeckPos pos) {
        if (player != getCurrentSheriff()) return null;
        Item i = droppedDecks[pos.ordinal()].draw();
        hands.get(player).add(i);
        return i;
    }

    public Item playerDrop(int player, String cardName) {
        Item card = null;
        if (player != getCurrentSheriff()) return null;
        for (var i : hands.get(player).getItems()) {
            if (i.getName().equals(cardName)) {
                card = i;
            }
        }
        hands.get(player).remove(card);
        if (card == null) return null;
        final int pos = new Random().nextInt(2);
        droppedDecks[pos].add(card);
        return card;
    }

    public void placeItem(int player, Item i) {
        if (player != getCurrentSheriff()) return;
        hands.get(player).remove(i);
        markets.get(player).add(i);
    }

    public void playerDropAll(int player) {
        if (player != getCurrentSheriff()) return;
        for (Item i : hands.get(player).getItems()) {
            final int pos = new Random().nextInt(2);
            droppedDecks[pos].add(i);
        }
        hands.get(player).getItems().clear();
    }

    public static class GameControllerBuilder {
        private final ArrayList<String> playerNames = new ArrayList<>();


        public GameControllerBuilder addPlayer(String name) {
            if (playerNames.size() < 5) playerNames.add(name);
            return this;
        }

        public ArrayList<String> getPlayerNames() {
            return playerNames;
        }

        public GameRoomController build() {
            return new GameRoomController(playerNames.size(), playerNames);
        }
    }
}
