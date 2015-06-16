package de.htwg.model;

import de.htwg.model.impl.PlayingCard;

import java.util.List;

/**
 * Created by fafreibe on 16.06.2015.
 */
public interface IField {
    void addCard(PlayingCard card);

    PlayingCard getCard();

    List<PlayingCard> getField();

    void clearField();

    int getFieldSize();

    String toString();
}
