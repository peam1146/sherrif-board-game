package com.progmeth.project.sheriff.domain.game.repositories;

import com.progmeth.project.sheriff.domain.game.entity.VerifyItemEntity;
import io.reactivex.rxjava3.core.Single;

import java.util.ArrayList;

public interface SheriffRepository {
    public Single<String> getSheriffName();
    public Single<ArrayList<String>> verifyPlayer(int player);

    public Single<ArrayList<VerifyItemEntity>> getVerifyItems();
}
