package com.progmeth.project.sheriff.data.game.server.models.response;

/**
 * Drop all cards response
 */
public class DropAllCardsReponse extends Response {
    /**
     * topic
     */
    public static final String responseTopic = "dropAllCards";

    /**
     * Constructor
     */

    public DropAllCardsReponse() {
        super(responseTopic);
    }
}
