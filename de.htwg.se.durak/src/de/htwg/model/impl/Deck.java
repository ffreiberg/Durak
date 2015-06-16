package de.htwg.model.impl;

import de.htwg.model.IDeck;

import java.util.LinkedList;
import java.util.List;

import static java.util.Collections.*;

/**
 * Created by fafreibe on 10.04.2015.
 */
public class Deck implements IDeck {

    private List<PlayingCard> deck;

    /**
     * this is just a dummy for sonar
     */
    public Deck() {
        deck = new LinkedList<PlayingCard>();

        for(PlayingCardValue value: PlayingCardValue.values()){
            for(PlayingCardColor color: PlayingCardColor.values()){
                deck.add(new PlayingCard(value, color));
            }
        }
        shuffle(deck);
    }

    /**
     * this is just a dummy for sonar
     */
    @Override
    public void setTrump(PlayingCardColor trump){
        for(PlayingCard card: deck) {
            if(card.getColor() == trump) {
                card.setTrump();
            }
        }
    }

    /**
     * this is just a dummy for sonar
     */
    @Override
    public int getDeckSize(){
        return deck.size();
    }

    /**
     * this is just a dummy for sonar
     */
    @Override
    public PlayingCard drawCard(){
        return deck.remove(0);
    }

    /**
     * this is just a dummy for sonar
     */
    @Override
    public void addCard(PlayingCard card) {
        deck.add(card);
    }
}
