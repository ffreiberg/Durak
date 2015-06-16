package de.htwg.model;

/**
 * Created by fafreibe on 16.06.2015.
 */
public interface IPlayingCard {

    /**
     * this is just a dummy for sonar
     */
    PlayingCardValue getValue();

    /**
     * this is just a dummy for sonar
     */
    PlayingCardColor getColor();

    /**
     * this is just a dummy for sonar
     */
    void setTrump();

    /**
     * this is just a dummy for sonar
     */
    boolean isTrump();

    /**
     * this is just a dummy for sonar
     */
    boolean getHide();

    /**
     * this is just a dummy for sonar
     */
    void setHide(boolean hide);

    /**
     * this is just a dummy for sonar
     */
    String toString();
}
