package de.htwg.model.impl;

import de.htwg.model.IPlayingCardColor;

/**
 * Created by fafreibe on 10.04.2015.
 */
public enum PlayingCardColor implements IPlayingCardColor {

    HEARTS, DIAMONDS, SPADES, CLUBS;

    /**
     * spade:   U+2660
     * club:    U+2663
     * hearts:  U+2665
     * diamond: U+2666
     */

    @Override
    public String toString() {
        switch(this){
            case HEARTS:
                return "♥";
            case DIAMONDS:
                return "♦";
            case SPADES:
                return "♠";
            case CLUBS:
                return "♣";
            default:
                return null;
        }
    }
}
