package de.htwg.model;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by jawaigel on 16.04.2015.
 */
public abstract class Player implements IPlayer {

    public List<PlayingCard> hand;

    public Player(){
        hand = new LinkedList<>();
    }

    public abstract PlayingCard playCard();

    public void drawCard(PlayingCard card){
        hand.add(card);
        //hand.sort(Comparator.<PlayingCard>naturalOrder());
    }
}
