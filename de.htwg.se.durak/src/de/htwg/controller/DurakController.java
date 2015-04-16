package de.htwg.controller;

import de.htwg.model.Deck;
import de.htwg.model.Player;
import util.Observable;

/**
 * Created by jawaigel on 16.04.2015.
 */
public class DurakController extends Observable {

    private Deck deck;
    private Player players;

    public DurakController() {
        deck = new Deck();
    }
}
