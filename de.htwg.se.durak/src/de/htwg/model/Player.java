package de.htwg.model;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by jawaigel on 16.04.2015.
 */
public abstract class Player implements IPlayer {

    /**
     * The Hand.
     */
    public List<PlayingCard> hand;
    /**
     * The Player name.
     */
    public String playerName;

    /**
     * Instantiates a new Player.
     */
    public Player(){
        hand = new LinkedList<>();
    }

    /**
     * Play card.
     *
     * @return the playing card [ ]
     */
    public abstract PlayingCard[] playCard(PlayingCard[] currentField);

    /**
     * Draw card.
     *
     * @param card the card
     */
    public void drawCard(PlayingCard card){
        hand.add(card);
    }

    /**
     * Gets player name.
     *
     * @return the player name
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString(){
        String str = playerName + "\t";
        for(PlayingCard card: hand){
            str += card.toString() + "\t";
        }
        return str;
    }
}
