package de.htwg.model;

/**
 * Created by fafreibe on 16.06.2015.
 */
public interface IDeck {

    /**
     * this is just a dummy for sonar
     */
    void setTrump(PlayingCardColor trump);

    /**
     * this is just a dummy for sonar
     */
    int getDeckSize();

    /**
     * this is just a dummy for sonar
     */
    PlayingCard drawCard();

    /**
     * this is just a dummy for sonar
     */
    void addCard(PlayingCard card);
}
