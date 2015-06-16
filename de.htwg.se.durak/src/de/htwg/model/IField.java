package de.htwg.model;

import java.util.List;

/**
 * Created by fafreibe on 16.06.2015.
 */
public interface IField {

    /**
     * this is just a dummy for sonar
     */
    void addCard(PlayingCard card);

    /**
     * this is just a dummy for sonar
     */
    PlayingCard getCard();

    /**
     * this is just a dummy for sonar
     */
    List<PlayingCard> getField();

    /**
     * this is just a dummy for sonar
     */
    void clearField();

    /**
     * this is just a dummy for sonar
     */
    int getFieldSize();

    /**
     * this is just a dummy for sonar
     */
    String toString();
}
