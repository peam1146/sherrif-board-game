package com.progmeth.project.sheriff.presentors.common;

import javafx.scene.text.Font;

/**
 * All fonts
 */
public class GameFont {

    /**
     * font size
     */
    private final double size;

    /**
     * Constructor
     *
     * @param size font size
     */
    public GameFont(double size) {
        this.size = size;
    }

    /**
     * Get Inter-Back font
     *
     * @return font
     */
    public Font getBlack() {
        return Font.loadFont(getClass().getResourceAsStream("/com/progmeth/project/sheriff/fonts/Inter-Black.ttf"), this.size);
    }

    /**
     * Get Inter-Bold font
     *
     * @return font
     */
    public Font getBold() {
        return Font.loadFont(getClass().getResourceAsStream("/com/progmeth/project/sheriff/fonts/Inter-Bold.ttf"), this.size);
    }

    /**
     * Get Inter-ExtraBold font
     *
     * @return font
     */
    public Font getExtraBold() {
        return Font.loadFont(getClass().getResourceAsStream("/com/progmeth/project/sheriff/fonts/Inter-ExtraBold.ttf"), this.size);
    }

    /**
     * Get Inter-ExtraLight font
     *
     * @return font
     */
    public Font getExtraLight() {
        return Font.loadFont(getClass().getResourceAsStream("/com/progmeth/project/sheriff/fonts/Inter-ExtraLight.ttf"), this.size);
    }
}
