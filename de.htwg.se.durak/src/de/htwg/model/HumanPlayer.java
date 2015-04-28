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

    /**
     * Play card.
     *
     * @return the playing card [ ]
     * @param cardsOnField
     */
    @Override
    public LinkedList<PlayingCard> attack(LinkedList<PlayingCard> cardsOnField) {
        return null;
    }

    @Override
    public LinkedList<PlayingCard> defend(LinkedList<PlayingCard> currentField) {
        return null;
    }
}
