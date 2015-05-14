package de.htwg.model;

/**
 * Created by fafreibe on 10.04.2015.
 */
public enum PlayingCardValue {
    SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13), ACE(14);

    private int value;

    public static final int _SIX_ = 6, _SEVEN_ = 7, _EIGHT_ = 8, _NINE_ = 9, _TEN_ = 10, _JACK_ = 11, _QUEEN_ = 12, _KING_ = 13, _ACE_ = 14;

    PlayingCardValue(int value) {
        this.value = value;
    }

    @Override
    public String toString()
    {
        switch(value){
            case _SIX_:
            case _SEVEN_:
            case _EIGHT_:
            case _NINE_:
            case _TEN_:
                return Integer.toString(value);
            case _JACK_:
            case _QUEEN_:
            case _KING_:
            case _ACE_:
                return this.name().substring(0,1);
            default:
                return null;
        }
    }
}
