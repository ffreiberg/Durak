package de.htwg.model;

/**
 * Created by fafreibe on 10.04.2015.
 */
public class PlayingCard {

    private PlayingCardValue value;
    private PlayingCardColor color;

    /**
     * Instantiates a new Playing card.
     *
     * @param value the value
     * @param color the color
     */
    public PlayingCard(PlayingCardValue value, PlayingCardColor color){
        this.value = value;
        this.color = color;
    }

    /**
     * Gets value.
     *
     * @return the value
     */
    public PlayingCardValue getValue() {
        return value;
    }

    /**
     * Gets color.
     *
     * @return the color
     */
    public PlayingCardColor getColor() {
        return color;
    }

    /**
     * To string.
     *
     * @return the string
     */
    public String toString(){
        return color.toString() + value.toString();
    }
}
