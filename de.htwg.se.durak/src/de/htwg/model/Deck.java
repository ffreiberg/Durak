package de.htwg.model;

import java.util.LinkedList;
import java.util.List;
import static java.util.Collections.*;

/**
 * Created by fafreibe on 10.04.2015.
 */
public class Deck {

    private List<PlayingCard> deck;

    public Deck() {
        deck = new LinkedList<>();

        for(PlayingCardValue value: PlayingCardValue.values()){
            for(PlayingCardColor color: PlayingCardColor.values()){
                deck.add(new PlayingCard(value, color));
            }
        }
        shuffle(deck);
    }

    public int getDeckSize(){
        return deck.size();
    }

    @Override
    public String toString(){
        String str = "";
        for( PlayingCard card: deck){
            str += card.toString() + "\n";
        }
        return str;
    }
}
