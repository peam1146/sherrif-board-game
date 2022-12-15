package com.progmeth.project.sheriff.domain.game.repositories;

import com.progmeth.project.sheriff.data.game.models.base.Item;
import io.reactivex.rxjava3.core.Single;


/**
 * Dropped deck repository
 */
public interface DroppedDeckRepository {
    /**
     * Get card from the top of the deck
     *
     * @return card
     */
    public Single<Item> getTop();

    /**
     * Draw a card from the top of the deck
     *
     * @return card
     */
    public Single<Item> draw();
}
