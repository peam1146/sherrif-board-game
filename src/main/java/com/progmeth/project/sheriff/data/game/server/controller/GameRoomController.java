package com.progmeth.project.sheriff.data.game.server.controller;

import com.progmeth.project.sheriff.data.game.model.derive.deck.DroppedDeck;
import com.progmeth.project.sheriff.data.game.model.derive.deck.MainCardDeck;
import com.progmeth.project.sheriff.data.game.model.derive.hand.Hand;
import com.progmeth.project.sheriff.data.game.model.derive.market.Market;

public class GameRoomController {
    private final int playerCount;
    private final Hand[] hands;
    private final MainCardDeck deck;
    private final DroppedDeck[] droppedDecks;
    private final Market[] markets;

    private int turn = 0;

    public GameRoomController(int playerCount) {
        this.playerCount = playerCount;
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

}
