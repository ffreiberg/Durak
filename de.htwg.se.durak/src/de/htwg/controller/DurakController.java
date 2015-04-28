package de.htwg.controller;

import de.htwg.model.*;

import java.util.Observable;
import java.util.LinkedList;

import static de.htwg.controller.DurakCommands.*;

/**
 * Created by jawaigel on 16.04.2015.
 */
public class DurakController extends Observable {

    private static final int startNumOfCards = 6;
    private static final int maxNumOfCards = 12;

    private Deck deck;
    private Player activePlayer;
    private LinkedList<Player> players;
    private LinkedList<PlayingCard> field;
    private PlayingCard attackerCard;
    private PlayingCardColor trump;

    private Player defender, attacker;

    /**
     * Instantiates a new Durak controller.
     *
     * @throws IllegalArgumentException the illegal argument exception
     */
    public DurakController() throws IllegalArgumentException {
        /*if(numOfComputerPlayers < minNumOfComputerPlayers && numOfComputerPlayers > maxNumOfComputerPlayers){
            throw new IllegalArgumentException();
        }*/

        deck = new Deck();
        players = new LinkedList<>();
        field = new LinkedList<>();

        players.add(new HumanPlayer());
        players.add(new ComputerPlayer());

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
        attacker = players.get(0);
        defender = players.get(1);

        activePlayer = attacker;
    }

    private void setTrump() {
        //Set trump
        PlayingCard trumpCard = deck.drawCard();
        trump = trumpCard.getColor();
        deck.addCard(trumpCard);

        deck.setTrump(trump);
        for(Player player: players) player.setTrumpOnHand(trump);
    }

    private void dealOutCards() {
        //deal out cards
        for(Player player: players){
            for(int i=0; i<startNumOfCards; ++i){
                player.drawCard(deck.drawCard());
            }
        }
    }

    private void setNewPlayerRole(boolean skip) {
        //TODO: TUI neue Runde kennzeichnen

        Player p = players.remove(0);
        players.add(p);

        if(skip == true){
            p = players.remove(0);
            players.add(p);
        }

        attacker = players.get(0);
        defender = players.get(1);
    }

    /**
     * Player move.
     *
     * @param cmd the command
     * @throws IllegalArgumentException the illegal argument exception
     */
    public void playerMove(DurakCommands cmd) throws IllegalArgumentException{

        if(activePlayer.equals(attacker)){
            if(activePlayer.getClass().equals(ComputerPlayer.class))
                attack(ATTACK);
            else
                attack(cmd);
            activePlayer = defender;
        }
        else {
            if(activePlayer.getClass().equals(ComputerPlayer.class))
               defend(BEAT);
            else
                defend(cmd);
            activePlayer = attacker;
        }

        setChanged();
        notifyObservers();
    }

    private void defend(DurakCommands cmd) {
        if(cmd == TAKE){
            for(PlayingCard card: field) activePlayer.drawCard(card);
            setNewPlayerRole(true);
        }

        PlayingCard defenderCard = activePlayer.defend(attackerCard);

        if(defenderCard == null){
            for(PlayingCard card: field) activePlayer.drawCard(card);
            return;
        }

        field.add(defenderCard);
    }

    private void attack(DurakCommands cmd) {

        //TODO: Ausgabe dass zu viele Karten auf dem attackerField sind
        if(field.size() >= maxNumOfCards) return;

        if (activePlayer.equals(attacker) && field.isEmpty())
            cmd = ATTACK;

        if(cmd != ATTACK) return;

        PlayingCard attackingCard = activePlayer.attack(field);
        if(attackingCard == null) {
            setNewPlayerRole(false);
            return;
        }
        field.add(attackingCard);
    }

    /**
     * Get players hand.
     * (DEBUG)
     *
     * @return the string
     */
    public String getPlayersHand(){
        String str = "";
        for(Player p: players){
            str += (p.getPlayerName() + "\t" + p.toString() + "\n");
        }
        return str;
    }

}
