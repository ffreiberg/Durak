package de.htwg.model;

import java.util.LinkedList;

/**
 * Created by jawaigel on 10.04.2015.
 */
public interface IPlayer {

    PlayingCard attack(LinkedList<PlayingCard> cardsOnField, int cardIndex) throws IllegalArgumentException;

    PlayingCard defend(PlayingCard cardToBeat, int cardIndex) throws IllegalArgumentException;

    void drawCard(PlayingCard card);

    void setTrumpOnHand(PlayingCardColor trump);

    void sortHand();

    String getPlayerName();

    LinkedList<PlayingCard> getPlayersHand();

}