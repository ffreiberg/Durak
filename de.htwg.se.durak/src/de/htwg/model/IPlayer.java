package de.htwg.model;

import java.util.LinkedList;

/**
 * Created by jawaigel on 10.04.2015.
 */
public interface IPlayer {

    public PlayingCard attack(LinkedList<PlayingCard> cardsOnField, int cardIndex) throws IllegalArgumentException;

    public PlayingCard defend(PlayingCard cardToBeat, int cardIndex) throws IllegalArgumentException;

    public void drawCard(PlayingCard card);

    public void setTrumpOnHand(PlayingCardColor trump);

    public void sortHand();

    public String getPlayerName();

    public LinkedList<PlayingCard> getPlayersHand();

}