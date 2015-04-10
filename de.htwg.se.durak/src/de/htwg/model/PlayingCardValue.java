package de.htwg.model;

/**
 * Created by fafreibe on 10.04.2015.
 */
public enum PlayingCardValue {
    SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13), ACE(14);

    private int value;

    PlayingCardValue(int value) {
        this.value = value;
    }

    @Override
    public String toString()
    {
        switch(value){
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                return Integer.toString(value);
            case 11:
            case 12:
            case 13:
            case 14:
                return this.name().substring(0,1);
            default:
                return null;
        }
    }
}
