package de.htwg.model;

/**
 * Created by fafreibe on 10.04.2015.
 */
public class PlayingCard {

    private PlayingCardValue value;
    private PlayingCardColor color;

    public PlayingCard(PlayingCardValue value, PlayingCardColor color){
        this.value = value;
        this.color = color;
    }

    public PlayingCardValue getValue() {
        return value;
    }

    public PlayingCardColor getColor() {
        return color;
    }

    public String toString(){
        return color.toString() + value.toString();
    }
}
