package com.progmeth.project.sheriff.domain.game.repositories;

import com.progmeth.project.sheriff.data.game.model.base.Item;
import com.progmeth.project.sheriff.domain.game.entity.VerifyItemEntity;
import io.reactivex.rxjava3.core.Single;

public interface SheriffRepository {
    public Single<String> getSheriffName();
    public Single<Item[]> verifyPlayer(int player);
    public Single<VerifyItemEntity[]> getVerifyItems();
}
