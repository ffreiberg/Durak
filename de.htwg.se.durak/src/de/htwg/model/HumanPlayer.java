package de.htwg.model;

import java.util.LinkedList;

/**
 * Created by jan-erikwaigel on 16.04.15.
 */
public class HumanPlayer extends Player {

    /**
     * Instantiates a new Human player.
     */
    public HumanPlayer(){
        playerName = "HumanPlayer";
    }

    @Override
    public PlayingCard attack(LinkedList<PlayingCard> cardsOnField, int cardIndex) throws IllegalArgumentException {

        this.sortHand();

        if (cardIndex == 0) {
            return null;
        }
        else if(cardIndex < 0 || cardIndex > hand.size()) {
            throw new IllegalArgumentException("Index out of range!");
        }

        if (cardsOnField.isEmpty()) {
            return hand.remove(cardIndex - 1);
        }
        else if (cardValid(cardsOnField, hand.get(cardIndex-1))) {
            return hand.remove(cardIndex - 1);
        }
        else {
            throw new IllegalArgumentException("Invalid playing card");
        }
    }

    @Override
    public PlayingCard defend(PlayingCard cardToBeat, int cardIndex) throws IllegalArgumentException {
        this.sortHand();
        if(cardIndex < 1 || cardIndex > hand.size()) {
            throw new IllegalArgumentException("Index out of range!");
        }

        //TODO: Prüfen ob Karte gültig
        if (hand.get(cardIndex-1).getColor() == cardToBeat.getColor() &&
                hand.get(cardIndex-1).getValue().ordinal() > cardToBeat.getValue().ordinal()) {
            return hand.remove(cardIndex - 1);
        }
        else if (hand.get(cardIndex-1).isTrump() && !cardToBeat.isTrump()) {
            return hand.remove(cardIndex - 1);
        }
        else {
            throw new IllegalArgumentException("Invalid playing card");
        }
    }

    private boolean cardValid(LinkedList<PlayingCard> cardsOnField, PlayingCard cardToPlay){

        for (PlayingCard card : cardsOnField){
            if (cardToPlay.getValue().ordinal() == card.getValue().ordinal()) {
                return true;
            }
        }

        return false;
    }
}
