package com.progmeth.project.sheriff.data.game.server.controller;

import com.progmeth.project.sheriff.data.game.models.base.Item;
import com.progmeth.project.sheriff.data.game.models.derive.deck.DroppedDeck;
import com.progmeth.project.sheriff.data.game.models.derive.deck.MainCardDeck;
import com.progmeth.project.sheriff.data.game.models.derive.hand.Hand;
import com.progmeth.project.sheriff.data.game.models.derive.market.Market;

import java.util.ArrayList;
import java.util.Random;

/**
 * Game room controller
 */
public class GameRoomController {

    /**
     * Amount of players
     */
    private final int playerCount;

    /**
     * List of players name
     */
    private final ArrayList<String> playerNames;

    /**
     * List of players hand
     */
    private final ArrayList<Hand> hands;

    /**
     * game deck
     */
    private final MainCardDeck deck;

    /**
     * dropped deck
     */
    private final DroppedDeck[] droppedDecks;

    /**
     * player's market
     */
    private final ArrayList<Market> markets;

    /**
     * turn counter
     */
    private int turn = 0;

    /**
     * turn timer
     */
    private int timer = 0;

    /**
     * max turn time
     */
    private final int maxTimer = 60;

    /**
     * Constructor
     *
     * @param playerCount amount of players
     * @param playerNames list of player names
     */
    public GameRoomController(int playerCount, ArrayList<String> playerNames) {
        this.playerCount = playerCount;
        this.playerNames = playerNames;
        this.hands = new ArrayList<>();
        this.deck = new MainCardDeck();
        this.droppedDecks = new DroppedDeck[2];
        this.markets = new ArrayList<>();
    }


    /**
     * get sheriff
     *
     * @return player id
     */
    public int getCurrentSheriff() {
        return turn % playerCount;
    }

    /**
     * go to next turn
     */
    public void nextTurn() {
        turn++;
    }


    /**
     * get player hand
     *
     * @param player player id
     * @return player hand
     */
    public Hand getHand(int player) {
        return hands.get(player);
    }

    /**
     * get player market
     *
     * @param player player id
     * @return player market
     */
    public Market getMarket(int player) {
        return markets.get(player);
    }

    /**
     * get dropped deck
     *
     * @param pos deck position
     * @return dropped deck
     */
    public DroppedDeck getDroppedDeck(DroppedDeckPos pos) {
        return droppedDecks[pos.ordinal()];
    }

    /**
     * player draw a card
     *
     * @param player player id
     * @return card drawn
     */
    public Item playerDraw(int player) {
        if (player != getCurrentSheriff()) return null;
        Item i = deck.draw();
        hands.get(player).add(i);
        return i;
    }

    /**
     * player draw a card from dropped deck
     *
     * @param player player id
     * @param pos    dropped deck position
     * @return card drawn
     */
    public Item playerDrawFromDropped(int player, DroppedDeckPos pos) {
        if (player != getCurrentSheriff()) return null;
        Item i = droppedDecks[pos.ordinal()].draw();
        hands.get(player).add(i);
        return i;
    }

    /**
     * player drop a card
     *
     * @param player   player id
     * @param cardName card name
     * @return card dropped
     */
    public Item playerDrop(int player, String cardName) {
        Item card = null;
        if (player != getCurrentSheriff()) return null;
        for (var i : hands.get(player).getItems()) {
            if (i.getName().equals(cardName)) {
                card = i;
                hands.get(player).remove(i);
            }
        }
        if (card == null) return null;
        final int pos = new Random().nextInt(2);
        droppedDecks[pos].add(card);
        return card;
    }

    /**
     * place a card to market
     *
     * @param player player id
     * @param i      card to place
     */
    public void placeItem(int player, Item i) {
        if (player != getCurrentSheriff()) return;
        hands.get(player).remove(i);
        markets.get(player).add(i);
    }

    /**
     * player drop all cards
     *
     * @param player player id
     */
    public void playerDropAll(int player) {
        if (player != getCurrentSheriff()) return;
        for (Item i : hands.get(player).getItems()) {
            final int pos = new Random().nextInt(2);
            droppedDecks[pos].add(i);
        }
        hands.get(player).getItems().clear();
    }

    /**
     * class Builder
     */
    public static class GameControllerBuilder {
        /**
         * list of players
         */
        private final ArrayList<String> playerNames = new ArrayList<>();

        /**
         * Constructor
         */
        public GameControllerBuilder() {
        }


        /**
         * add player
         *
         * @param name player name
         * @return this
         */
        public GameControllerBuilder addPlayer(String name) {
            if (playerNames.size() < 5) playerNames.add(name);
            return this;
        }

        /**
         * get all players
         *
         * @return list of players
         */
        public ArrayList<String> getPlayerNames() {
            return playerNames;
        }

        /**
         * build
         *
         * @return game room controller
         */
        public GameRoomController build() {
            return new GameRoomController(playerNames.size(), playerNames);
        }
    }
}
