package de.htwg.model;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import static java.util.Collections.*;

/**
 * Created by fafreibe on 10.04.2015.
 */
public class Deck {

    private LinkedList<PlayingCard> deck;

    public Deck() {
        deck = new LinkedList<PlayingCard>();

        for(PlayingCardValue value: PlayingCardValue.values()){
            for(PlayingCardColor color: PlayingCardColor.values()){
                deck.add(new PlayingCard(value, color));
            }
        }
        shuffle(deck);
    }

    public void setTrump(PlayingCardColor trump){
        for(PlayingCard card: deck) {
            if(card.getColor() == trump) card.setTrump();
        }
    }

    public int getDeckSize(){
        return deck.size();
    }

    public PlayingCard drawCard() throws NoSuchElementException{
        return deck.remove(0);
    }

    public void addCard(PlayingCard card) {
        deck.add(card);
    }

    //for debugging purpose only
/*    @Override
    public String toString(){
        String str = "";
        for( PlayingCard card: deck){
            str += card.toString() + "\n";
        }
        return str;
    }*/
}
