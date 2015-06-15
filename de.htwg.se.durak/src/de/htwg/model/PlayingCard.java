package de.htwg.model;


/**
 * Created by fafreibe on 10.04.2015.
 */
public class PlayingCard {

    private PlayingCardValue value;
    private PlayingCardColor color;
    private boolean trump;
    private boolean hide;

    /**
     * this is just a dummy for sonar
     */
    public PlayingCard(PlayingCardValue value, PlayingCardColor color){
        this.value = value;
        this.color = color;
        this.trump = false;
        this.hide = true;
    }

    /**
     * this is just a dummy for sonar
     */
    public PlayingCardValue getValue() {
        return value;
    }

    /**
     * this is just a dummy for sonar
     */
    public PlayingCardColor getColor() {
        return color;
    }

    /**
     * this is just a dummy for sonar
     */
    public void setTrump() { this.trump = true; }

    /**
     * this is just a dummy for sonar
     */
    public boolean isTrump() {
        return trump;
    }

    /**
     * this is just a dummy for sonar
     */
    public boolean getHide() { return this.hide; }

    /**
     * this is just a dummy for sonar
     */
    public void setHide(boolean hide) { this.hide = hide;}

    /**
     * this is just a dummy for sonar
     */
    public String toString(){
        return color.toString() + value.toString();
    }
}
