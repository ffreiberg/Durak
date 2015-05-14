package de.htwg.model;

/**
 * Created by fafreibe on 10.04.2015.
 */
public enum PlayingCardValue {
    SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13), ACE(14);

    private int value;

    public static final int SIX_ = 6, SEVEN_ = 7, EIGHT_ = 8, NINE_ = 9, TEN_ = 10, JACK_ = 11, QUEEN_ = 12, KING_ = 13, ACE_ = 14;

    PlayingCardValue(int value) {
        this.value = value;
    }

    @Override
    public String toString()
    {
        switch(value){
            case SIX_:
            case SEVEN_:
            case EIGHT_:
            case NINE_:
            case TEN_:
                return Integer.toString(value);
            case JACK_:
            case QUEEN_:
            case KING_:
            case ACE_:
                return this.name().substring(0,1);
            default:
                return null;
        }
    }
}
