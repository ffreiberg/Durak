package de.htwg.model;

/**
 * Created by fafreibe on 16.06.2015.
 */
public interface IPlayingCard {
    PlayingCardValue getValue();

    PlayingCardColor getColor();

    void setTrump();

    boolean isTrump();

    boolean getHide();

    void setHide(boolean hide);

    String toString();
}
