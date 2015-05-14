package de.htwg.model;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * Created by jawaigel on 16.04.2015.
 */
public abstract class Player implements IPlayer {

    private LinkedList<PlayingCard> getPlayersHand;
    private String playerName;

    public abstract PlayingCard attack(LinkedList<PlayingCard> cardsOnField, int cardIndex);

    public abstract PlayingCard defend(PlayingCard cardToBeat, int cardIndex);

    public Player(){
        getPlayersHand = new LinkedList<PlayingCard>();
    }

    public void drawCard(PlayingCard card){
        getPlayersHand.add(card);
        this.sortHand();
    }

    public String getPlayerName() {
        return playerName;
    }

    @Override
    public LinkedList<PlayingCard> getPlayersHand() {
        return getPlayersHand;
    }

    public void setTrumpOnHand(PlayingCardColor trump){
        for (PlayingCard cardOnHand : getPlayersHand) {
            if (cardOnHand.getColor() == trump) {
                cardOnHand.setTrump();
            }

        }
    }

    @Override
    public void sortHand() {
        Collections.sort(getPlayersHand, new CardComparator());
    }

    @Override
    public String toString(){
        String str = playerName + "\t";
        for(PlayingCard card: getPlayersHand){
            str += card.toString() + "\t";
        }
        return str;
    }

    private class CardComparator implements Comparator<PlayingCard> {
        @Override
        public int compare(PlayingCard card1, PlayingCard card2)
        {
            return card1.getValue().ordinal() - card2.getValue().ordinal();
        }
    }
}
