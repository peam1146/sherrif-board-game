package com.progmeth.project.sheriff.data.game.models.derive.hand;

import com.progmeth.project.sheriff.data.game.models.base.Illegal;
import com.progmeth.project.sheriff.data.game.models.base.Item;
import com.progmeth.project.sheriff.data.game.models.base.Legal;
import com.progmeth.project.sheriff.data.game.server.models.DTO.ItemDTO;

import java.util.ArrayList;

public class Hand {
    private final ArrayList<Item> items = new ArrayList<>();
    private int amount = 0;

    public void add(Item i) {
        if (amount > 6) return;
        items.add(i);
        amount++;
    }

    public void remove(Item i) {
        if (amount < 1) return;
        items.remove(i);
        amount--;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public ArrayList<ItemDTO> getItemsDTO() {
        ArrayList<ItemDTO> res = new ArrayList<>();
        for (Item item : items) {

            int fine = 0;
            int timeCost = 0;
            if (item instanceof final Legal legal)
                fine = legal.getTimeCost();
            if (item instanceof final Illegal illegal)
                fine = illegal.getFine();
            res.add(new ItemDTO.Builder().setIsLegal(item instanceof Legal).setFine(fine).setName(item.getName()).setImgURL(item.getImgURL()).setPrice(item.getPrice()).setTimeCost(timeCost).build());
        }
        return res;
    }
}
