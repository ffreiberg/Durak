package de.htwg.model;

/**
 * Created by fafreibe on 10.04.2015.
 */
public class PlayingCard {

    private PlayingCardValue value;
    private PlayingCardColor color;
    private boolean trump;

    /**
     * Instantiates a new Playing card.
     *
     * @param value the value
     * @param color the color
     */
    public PlayingCard(PlayingCardValue value, PlayingCardColor color){
        this.value = value;
        this.color = color;
        this.trump = false;
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

    public void setTrump() { this.trump = true; }

    public boolean isTrump() {
        return trump;
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
