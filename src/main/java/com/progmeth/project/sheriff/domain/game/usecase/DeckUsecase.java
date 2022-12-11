package com.progmeth.project.sheriff.domain.game.usecase;

import com.progmeth.project.sheriff.data.game.model.base.Item;
import com.progmeth.project.sheriff.data.game.model.derive.deck.MainCardDeck;

public class DeckUsecase {
    final private MainCardDeck deck = new MainCardDeck();

    public Item draw() {
        return deck.draw();
    }
}
