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
     * @param cardsOnField
     */
    public PlayingCard attack(LinkedList<PlayingCard> cardsOnField);

    public PlayingCard defend(PlayingCard cardToBeat);

    /**
     * Draw card.
     *
     * @param card the card
     */
    public void drawCard(PlayingCard card);

    public void setTrumpOnHand(PlayingCardColor trump);

    public void sortHand();

    /**
     * Gets player name.
     *
     * @return the player name
     */
    public String getPlayerName();
}