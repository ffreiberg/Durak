package de.htwg.controller;

import de.htwg.model.*;
import java.util.Observable;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by jawaigel on 16.04.2015.
 */
public class DurakController extends Observable {

    private static final int startNumOfCards = 6;
    private static final int minNumOfComputerPlayers = 2;
    private static final int maxNumOfComputerPlayers = 4;

    private Deck deck;
    private List<Player> players;
    private List<PlayingCard> currentField;
    private PlayingCardColor trump;

    private Player defender, attackerLeft, attackerRight;

    public DurakController(int numOfComputerPlayers) throws IllegalArgumentException {
        if(numOfComputerPlayers < minNumOfComputerPlayers && numOfComputerPlayers > maxNumOfComputerPlayers){
            throw new IllegalArgumentException();
        }

        deck = new Deck();
        players = new LinkedList<>();
        currentField = new LinkedList<>();

        addPlayers(numOfComputerPlayers);
        dealOutCards();
        setTrump();
        searchFirstAttacker();
    }

    private void searchFirstAttacker() {
        //search lowest trump card and set first rightAttacker
        PlayingCard lowestTrumpCard = new PlayingCard(PlayingCardValue.ACE, trump);
        int i=0, lowestTrumpIndex=0;
        for(Player player: players){
            for(PlayingCard card: player.hand) {
                if (card.getColor() == trump &&
                        lowestTrumpCard.getValue().ordinal() >= card.getValue().ordinal()) {
                    lowestTrumpCard = card;
                    lowestTrumpIndex = i;
                }
            }
            ++i;
        }

        //handle List and set right attacker on top
        while(lowestTrumpIndex > 0){
            Player p = players.remove(0);
            players.add(p);
            --lowestTrumpIndex;
        }

        //set player roles
        attackerRight = players.get(0);
        defender = players.get(1);
        attackerLeft = players.get(2);
    }

    private void setTrump() {
        //Set trump
        PlayingCard trumpCard = deck.drawCard();
        trump = trumpCard.getColor();
        deck.addCard(trumpCard);
    }

    private void dealOutCards() {
        //deal out cards
        for(Player player: players){
            for(int i=0; i<startNumOfCards; ++i){
                player.drawCard(deck.drawCard());
            }
        }
    }

    private void addPlayers(int numOfComputerPlayers) {
        //Add players
        players.add(new HumanPlayer());
        for(int i=0; i<numOfComputerPlayers; ++i){
            players.add(new ComputerPlayer());
        }
    }

    private void setNewPlayerRole(boolean skip) {
        Player p = players.remove(0);
        players.add(p);

        if(skip == true){
            p = players.remove(0);
            players.add(p);
        }

        attackerRight = players.get(0);
        defender = players.get(1);
        attackerLeft = players.get(2);
    }

    public void playRound() {




        setNewPlayerRole(false);
        setChanged();
        notifyObservers();
    }

    //DEBUG
    public String getPlayersHand(){
        String str = "";
        for(Player p: players){
            str += (p.getPlayerName() + "\t" + p.toString() + "\n");
        }
        return str;
    }

    //DEBUG
    public String getPlayerRoles(){
        String str = "";
        str += "Right:\t\t" + attackerRight.toString() + "\n";
        str += "Defender:\t"  + defender.toString() + "\n";
        str += "Left:\t\t" + attackerLeft.toString() + "\n";
        return str;
    }

}
