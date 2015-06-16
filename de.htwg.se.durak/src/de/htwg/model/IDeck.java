package de.htwg.model;

/**
 * Created by fafreibe on 16.06.2015.
 */
public interface IDeck {
    void setTrump(PlayingCardColor trump);

    int getDeckSize();

    PlayingCard drawCard();

    void addCard(PlayingCard card);
}
