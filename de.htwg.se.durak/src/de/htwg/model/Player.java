package de.htwg.model;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by jawaigel on 16.04.2015.
 */
public abstract class Player implements IPlayer {

    public List<PlayingCard> hand;
    public String playerName;

    public Player(){
        hand = new LinkedList<>();
    }

    public abstract PlayingCard playCard();

    public void drawCard(PlayingCard card){
        hand.add(card);
    }

    public String getPlayerName() {
        return playerName;
    }

    @Override
    public String toString(){
        String str = "";
        for(PlayingCard card: hand){
            str += card.toString() + "\t";
        }
        return str;
    }
}
