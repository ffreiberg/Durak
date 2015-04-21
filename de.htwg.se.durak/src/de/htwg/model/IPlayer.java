package de.htwg.model;

/**
 * Created by jawaigel on 10.04.2015.
 */
public interface IPlayer {

    public PlayingCard[] playCard();

    public void drawCard(PlayingCard card);
    public String getPlayerName();
}
