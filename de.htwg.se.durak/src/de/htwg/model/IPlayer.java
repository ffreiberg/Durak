package de.htwg.model;

import de.htwg.model.impl.PlayingCard;
import de.htwg.model.impl.PlayingCardColor;

import java.util.List;

/**
 * Created by jawaigel on 10.04.2015.
 */
public interface IPlayer {

    /**
     * this is just a dummy for sonar
     */
    PlayingCard attack(List<PlayingCard> cardsOnField, int cardIndex);

    /**
     * this is just a dummy for sonar
     */
    PlayingCard defend(PlayingCard cardToBeat, int cardIndex);

    /**
     * this is just a dummy for sonar
     */
    void drawCard(PlayingCard card);

    /**
     * this is just a dummy for sonar
     */
    void setTrumpOnHand(PlayingCardColor trump);

    /**
     * this is just a dummy for sonar
     */
    void sortHand();

    /**
     * this is just a dummy for sonar
     */
    List<PlayingCard> getPlayersHand();

}