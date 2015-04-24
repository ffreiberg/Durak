package de.htwg.model;

import java.util.LinkedList;

/**
 * Created by jawaigel on 10.04.2015.
 */
public interface IPlayer {

    /**
     * Play card.
     *
     * @return the playing card [ ]
     */
    public LinkedList<PlayingCard> playCard(LinkedList<PlayingCard> currentField);

    /**
     * Draw card.
     *
     * @param card the card
     */
    public void drawCard(PlayingCard card);

    /**
     * Gets player name.
     *
     * @return the player name
     */
    public String getPlayerName();
}
