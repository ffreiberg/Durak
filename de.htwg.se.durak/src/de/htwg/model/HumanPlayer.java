package de.htwg.model;

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
     */
    @Override
    public PlayingCard[] playCard() {
        return null;
    }
}
