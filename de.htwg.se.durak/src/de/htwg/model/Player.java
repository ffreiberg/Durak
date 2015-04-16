package de.htwg.model;

import de.htwg.model.PlayingCard;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by jawaigel on 10.04.2015.
 */
public class Player {

    private List<PlayingCard> hand;

    public Player(){
        hand = new LinkedList<>();
    }

    public PlayingCard playCard(){
        throw new NotImplementedException();
    }

    public void drawCard(PlayingCard card){
        hand.add(card);
        throw new NotImplementedException();
    }
}
