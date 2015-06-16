package de.htwg.model;


/**
 * Created by fafreibe on 10.04.2015.
 */
public class PlayingCard implements IPlayingCard {

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
    @Override
    public PlayingCardValue getValue() {
        return value;
    }

    /**
     * this is just a dummy for sonar
     */
    @Override
    public PlayingCardColor getColor() {
        return color;
    }

    /**
     * this is just a dummy for sonar
     */
    @Override
    public void setTrump() { this.trump = true; }

    /**
     * this is just a dummy for sonar
     */
    @Override
    public boolean isTrump() {
        return trump;
    }

    /**
     * this is just a dummy for sonar
     */
    @Override
    public boolean getHide() { return this.hide; }

    /**
     * this is just a dummy for sonar
     */
    @Override
    public void setHide(boolean hide) { this.hide = hide;}

    /**
     * this is just a dummy for sonar
     */
    @Override
    public String toString(){
        return color.toString() + value.toString();
    }
}
