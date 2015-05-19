package de.htwg.model;

import java.util.List;

/**
 * Created by jawaigel on 10.04.2015.
 */
public interface IPlayer {

    PlayingCard attack(List<PlayingCard> cardsOnField, int cardIndex);

    PlayingCard defend(PlayingCard cardToBeat, int cardIndex);

    void drawCard(PlayingCard card);

    void setTrumpOnHand(PlayingCardColor trump);

    void sortHand();

    List<PlayingCard> getPlayersHand();

}