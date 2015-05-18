package de.htwg.model;

/**
 * Created by fafreibe on 10.04.2015.
 */
public class PlayingCard {

    private PlayingCardValue value;
    private PlayingCardColor color;
    private boolean trump;
    private boolean hide;

    public PlayingCard(PlayingCardValue value, PlayingCardColor color){
        this.value = value;
        this.color = color;
        this.trump = false;
        this.hide = true;
    }

    public PlayingCardValue getValue() {
        return value;
    }

    public PlayingCardColor getColor() {
        return color;
    }

    public void setTrump() { this.trump = true; }

    public boolean isTrump() {
        return trump;
    }

    public boolean getHide() { return this.hide; }

    public void setHide(boolean hide) { this.hide = hide;}

    public String toString(){
        return color.toString() + value.toString();
    }
}
