package de.htwg.model;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by jawaigel on 16.04.2015.
 */
public abstract class Player implements IPlayer {

    /**
     * The Hand.
     */
    public LinkedList<PlayingCard> hand;
    /**
     * The Player name.
     */
    public String playerName;

    /**
     * Play card.
     *
     * @return the playing card [ ]
     * @param cardsOnField
     */
    public abstract PlayingCard attack(LinkedList<PlayingCard> cardsOnField, int cardIndex);

    public abstract PlayingCard defend(PlayingCard cardToBeat, int cardIndex);

    /**
     * Instantiates a new Player.
     */
    public Player(){
        hand = new LinkedList<>();
    }

    /**
     * Draw card.
     *
     * @param card the card
     */
    public void drawCard(PlayingCard card){
        hand.add(card);
        this.sortHand();
    }

    /**
     * Gets player name.
     *
     * @return the player name
     */
    public String getPlayerName() {
        return playerName;
    }

    @Override
    public LinkedList<PlayingCard> getPlayersHand() {
        return hand;
    }

    public void setTrumpOnHand(PlayingCardColor trump){
        for (PlayingCard cardOnHand : hand) {
            if (cardOnHand.getColor() == trump) {
                cardOnHand.setTrump();
            }

        }
    }

    @Override
    public void sortHand() {
        Collections.sort(hand, new CardComparator());
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

    private class CardComparator implements Comparator<PlayingCard> {
        @Override
        public int compare(PlayingCard card1, PlayingCard card2)
        {
            return card1.getValue().ordinal() - card2.getValue().ordinal();
        }
    }
}
