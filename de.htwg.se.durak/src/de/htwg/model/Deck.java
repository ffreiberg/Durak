package de.htwg.model;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import static java.util.Collections.*;

/**
 * Created by fafreibe on 10.04.2015.
 */
public class Deck {

    private List<PlayingCard> deck;

    /**
     * Instantiates a new Deck.
     */
    public Deck() {
        deck = new LinkedList<>();

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

    /**
     * Get deck size.
     *
     * @return the int
     */
    public int getDeckSize(){
        return deck.size();
    }

    /**
     * Draw card.
     *
     * @return the playing card
     * @throws NoSuchElementException the no such element exception
     */
    public PlayingCard drawCard() throws NoSuchElementException{
        return deck.remove(0);
    }

    /**
     * Add card.
     *
     * @param card the card
     */
    public void addCard(PlayingCard card) {
        deck.add(card);
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString(){
        String str = "";
        for( PlayingCard card: deck){
            str += card.toString() + "\n";
        }
        return str;
    }
}
