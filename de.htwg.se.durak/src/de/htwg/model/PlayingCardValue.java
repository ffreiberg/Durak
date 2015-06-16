package de.htwg.model;

import de.htwg.model.IPlayingCardValue;

/**
 * Created by fafreibe on 10.04.2015.
 */
public enum PlayingCardValue implements IPlayingCardValue {
    SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13), ACE(14);

    private int value;

    public static final int E_SIX = 6, E_SEVEN = 7, E_EIGHT = 8, E_NINE = 9, E_TEN = 10, E_JACK = 11, E_QUEEN = 12, E_KING = 13, E_ACE = 14;

    PlayingCardValue(int value) {
        this.value = value;
    }

    @Override
    public String toString()
    {
        switch(value){
            case E_SIX:
            case E_SEVEN:
            case E_EIGHT:
            case E_NINE:
            case E_TEN:
                return Integer.toString(value);
            case E_JACK:
            case E_QUEEN:
            case E_KING:
            case E_ACE:
                return this.name().substring(0,1);
            default:
                return null;
        }
    }
}
