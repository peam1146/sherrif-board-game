package com.progmeth.project.sheriff.domain.game.usecase;

import com.progmeth.project.sheriff.data.game.entity.base.Item;
import com.progmeth.project.sheriff.data.game.entity.derive.deck.MainCardDeck;

public class DeckUsecase {
    final private MainCardDeck deck = new MainCardDeck();

    public Item draw() {
        return deck.draw();
    }
}
