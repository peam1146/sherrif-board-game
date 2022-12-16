package com.progmeth.project.sheriff.presentors.player.views.components;

import com.progmeth.project.sheriff.presentors.common.GameFont;
import io.reactivex.rxjava3.functions.Consumer;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

/**
 * Money
 */
public class Money extends HBox {
    /**
     * amount of money
     */
    private int amount = 0;
    /**
     * chip image
     */
    private final static String IMG_CARD_CHIP = Money.class.getResource("/com/progmeth/project/sheriff/images/money_chip.png").toString();
    private Text amountText;
    /**
     * Constructor
     */
    public Money() {
        ImageView chip = new ImageView(IMG_CARD_CHIP);
        chip.setFitHeight(39);
        chip.setFitWidth(39);
        super.setPadding(new javafx.geometry.Insets(10, 10, 10, 10));
        amountText = new Text("x " + amount);
        amountText.setFont(new GameFont(20).getBlack());
        amountText.setTranslateY(8);
        super.setSpacing(10);
        getChildren().addAll(chip,amountText);
    }

    public void setAmount(int amount) {
        this.amount = amount;
        amountText = new Text("x " + amount);
    }
}
