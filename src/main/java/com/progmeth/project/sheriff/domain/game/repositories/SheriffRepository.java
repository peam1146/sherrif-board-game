package com.progmeth.project.sheriff.domain.game.repositories;

import com.progmeth.project.sheriff.domain.game.entity.VerifyItemEntity;
import io.reactivex.rxjava3.core.Single;

import java.util.ArrayList;

/**
 * Sheriff repository
 */
public interface SheriffRepository {
    /**
     * get sheriff name of a turn
     *
     * @return sheriff name
     */
    public Single<String> getSheriffName();

    /**
     * choose player to verify
     *
     * @param player player name
     * @return list of items
     */
    public Single<ArrayList<String>> verifyPlayer(int player);

    /**
     * get list of verify item
     * @return list of verify item
     */
    public Single<ArrayList<VerifyItemEntity>> getVerifyItems();
}
