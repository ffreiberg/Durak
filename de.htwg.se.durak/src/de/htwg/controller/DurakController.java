package de.htwg.controller;

import de.htwg.model.*;
import util.Observable;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by jawaigel on 16.04.2015.
 */
public class DurakController extends Observable {

    private Deck deck;
    private List<Player> players;
    private PlayingCardColor trump;

    private Player defender, attackerLeft, attackerRight;

    public DurakController(int numOfComputerPlayers) throws IllegalArgumentException {
        if(numOfComputerPlayers < 1){
            throw new IllegalArgumentException();
        }

        deck = new Deck();
        players = new LinkedList<>();

        //Add players
        players.add(new HumanPlayer());
        for(int i=0; i<numOfComputerPlayers; ++i){
            players.add(new ComputerPlayer());
        }

        //deal out cards
        for(Player player: players){
            for(int i=0; i<6; ++i){
                player.drawCard(deck.drawCard());
            }
        }

        //Set trump
        PlayingCard trumpCard = deck.drawCard();
        trump = trumpCard.getColor();
        deck.addCard(trumpCard);

        PlayingCard lowestTrumpCard = new PlayingCard(PlayingCardValue.ACE, trump);
        for(Player player: players){
            for(PlayingCard card: player.hand){
                //if(card.getColor() == trump && lowestTrumpCard.getValue() >= card.getValue()){}
            }
        }
    }



}
