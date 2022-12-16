package com.progmeth.project.sheriff.data.game.models.derive.hand;

import com.progmeth.project.sheriff.data.game.models.base.Illegal;
import com.progmeth.project.sheriff.data.game.models.base.Item;
import com.progmeth.project.sheriff.data.game.models.base.Legal;
import com.progmeth.project.sheriff.data.game.server.models.DTO.ItemDTO;

import java.util.ArrayList;

/**
 * Hand
 */
public class Hand {
    /**
     * list of card
     */
    private final ArrayList<Item> items = new ArrayList<>();
    /**
     * amount of card
     */
    private int amount = 0;

    /**
     * Constructor
     */
    public Hand() {
    }

    /**
     * add card to hand
     * @param i card
     */
    public void add(Item i) {
        if (amount > 6) return;
        items.add(i);
        amount++;
    }

    /**
     * remove card from hand
     * @param i card
     */
    public void remove(Item i) {
        if (amount < 1) return;
        items.remove(i);
        amount--;
    }

    /**
     * get cards
     * @return cards
     */
    public ArrayList<Item> getItems() {
        return items;
    }

    /**
     * convert to DTO
     * @return DTO
     */
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
