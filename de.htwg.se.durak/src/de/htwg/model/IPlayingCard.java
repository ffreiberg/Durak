package de.htwg.model;

import de.htwg.model.impl.PlayingCardColor;
import de.htwg.model.impl.PlayingCardValue;

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
