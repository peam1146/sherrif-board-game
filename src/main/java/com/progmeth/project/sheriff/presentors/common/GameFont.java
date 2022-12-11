package com.progmeth.project.sheriff.presentors.common;

import javafx.scene.text.Font;

public class GameFont {
    private final double size;
    public GameFont(double size) {
        this.size = size;
    }

    public Font getBlack() {
        return Font.loadFont(getClass().getResourceAsStream("/com/progmeth/project/sheriff/fonts/Inter-Black.ttf"), this.size);
    }

    public Font getBold() {
        return Font.loadFont(getClass().getResourceAsStream("/com/progmeth/project/sheriff/fonts/Inter-Bold.ttf"), this.size);
    }

    public Font getExtraBold() {
        return Font.loadFont(getClass().getResourceAsStream("/com/progmeth/project/sheriff/fonts/Inter-ExtraBold.ttf"), this.size);
    }

    public Font getExtraLight() {
        return Font.loadFont(getClass().getResourceAsStream("/com/progmeth/project/sheriff/fonts/Inter-ExtraLight.ttf"), this.size);
    }
}
