package de.htwg.controller;

import de.htwg.model.Deck;
import de.htwg.model.Player;
import util.Observable;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by jawaigel on 16.04.2015.
 */
public class DurakController extends Observable {

    private Deck deck;
    private List<Player> players;

    public DurakController() {
        deck = new Deck();
        players = new LinkedList<>();
    }
}
