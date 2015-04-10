package de.htwg.model;

/**
 * Created by fafreibe on 10.04.2015.
 */
public enum PlayingCardColor {

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
                return "\u2665";
            case DIAMONDS:
                return "\u2666";
            case SPADES:
                return "\u2660";
            case CLUBS:
                return "\u2663";
            default:
                return null;
        }
    }
}
