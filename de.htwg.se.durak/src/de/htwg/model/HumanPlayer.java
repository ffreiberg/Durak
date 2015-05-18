package de.htwg.model;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by jan-erikwaigel on 16.04.15.
 */
public class HumanPlayer extends Player {

    /**
     * Instantiates a new Human player.
     */
    public HumanPlayer(){
    }

    @Override
    public PlayingCard attack(List<PlayingCard> cardsOnField, int cardIndex) throws IllegalArgumentException {

        this.sortHand();

        if (cardIndex == 0) {
            return null;
        }
        else if(cardIndex < 0 || cardIndex > getPlayersHand().size()) {
            throw new IllegalArgumentException("Index out of range!");
        }

        if (cardsOnField.isEmpty()) {
            return getPlayersHand().remove(cardIndex - 1);
        }
        else if (cardValid(cardsOnField, getPlayersHand().get(cardIndex - 1))) {
            return getPlayersHand().remove(cardIndex - 1);
        }
        else {
            throw new IllegalArgumentException("Invalid playing card");
        }
    }

    @Override
    public PlayingCard defend(PlayingCard cardToBeat, int cardIndex) throws IllegalArgumentException {
        this.sortHand();
        if(cardIndex < 1 || cardIndex > getPlayersHand().size()) {
            throw new IllegalArgumentException("Index out of range!");
        }

        //TODO: Prüfen ob Karte gültig
        if (getPlayersHand().get(cardIndex - 1).getColor() == cardToBeat.getColor() &&
                getPlayersHand().get(cardIndex - 1).getValue().ordinal() > cardToBeat.getValue().ordinal()) {
            return getPlayersHand().remove(cardIndex - 1);
        }
        else if (getPlayersHand().get(cardIndex - 1).isTrump() && !cardToBeat.isTrump()) {
            return getPlayersHand().remove(cardIndex - 1);
        }
        else {
            throw new IllegalArgumentException("Invalid playing card");
        }
    }

    private boolean cardValid(List<PlayingCard> cardsOnField, PlayingCard cardToPlay){

        for (PlayingCard card : cardsOnField){
            if (cardToPlay.getValue().ordinal() == card.getValue().ordinal()) {
                return true;
            }
        }

        return false;
    }
}
