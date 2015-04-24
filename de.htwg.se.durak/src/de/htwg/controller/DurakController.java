package de.htwg.controller;

import com.sun.xml.internal.bind.v2.runtime.AttributeAccessor;
import de.htwg.model.*;

import java.text.AttributedCharacterIterator;
import java.util.Observable;
import java.util.LinkedList;
import java.util.List;

import static de.htwg.controller.DurakCommands.*;

/**
 * Created by jawaigel on 16.04.2015.
 */
public class DurakController extends Observable {

    private static final int startNumOfCards = 6;
    private static final int minNumOfComputerPlayers = 2;
    private static final int maxNumOfComputerPlayers = 4;
    private static final int maxNumOfAttackerCards = 6;

    private Deck deck;
    private Player activePlayer;
    private LinkedList<Player> players;
    private LinkedList<PlayingCard> attackerField, defenderField;
    private PlayingCardColor trump;
    private boolean attackerRightFirstMove;

    private Player defender, attackerLeft, attackerRight;

    /**
     * Instantiates a new Durak controller.
     *
     * @param numOfComputerPlayers the num of computer players
     * @throws IllegalArgumentException the illegal argument exception
     */
    public DurakController(int numOfComputerPlayers) throws IllegalArgumentException {
        if(numOfComputerPlayers < minNumOfComputerPlayers && numOfComputerPlayers > maxNumOfComputerPlayers){
            throw new IllegalArgumentException();
        }

        deck = new Deck();
        players = new LinkedList<>();
        attackerField = new LinkedList<>();
        defenderField = new LinkedList<>();
        attackerRightFirstMove = true;

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

        activePlayer = attackerRight;
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

    /**
     * Player move.
     *
     * @param cmd the command
     * @throws IllegalArgumentException the illegal argument exception
     */
    public void playerMove(DurakCommands cmd) throws IllegalArgumentException{

        /**
         * Rundenablauf:
         * attackerRight muss angreifen,
         * attackerLeft kann angreifen oder skippen
         * defender kann schlagen, aufnehmen oder skippen
         * attackerRight kann angreifen oder skippen
         * attackerLeft ...
         * ...
         * runde endet wenn defender aufgenommen oder alle karten auf dem feld (max. 6) gestochen hat
         */

        //TODO: setNewPlayerRole benutzen
        //TODO: unterscheiden ob HumanPlayer an der Reihe ist -> Übergabe welche Karten gespielt werden sollen

        if(activePlayer.equals(attackerRight)){
            attack(cmd);
            activePlayer = attackerLeft;
        } else if (activePlayer.equals(attackerLeft)) {
            attack(cmd);
            activePlayer = defender;
        } else if (activePlayer.equals(defender)) {
            defend(cmd);
            activePlayer = attackerRight;
        } else {
            throw new IllegalArgumentException();
        }

        setChanged();
        notifyObservers();
    }

    private void defend(DurakCommands cmd) {
        LinkedList<PlayingCard> defenderCards = activePlayer.defend(attackerField);

        if(defenderCards == null){
            for(PlayingCard card: defenderField) activePlayer.drawCard(card);
            for(PlayingCard card: attackerField) activePlayer.drawCard(card);
            defenderField.clear();
            attackerField.clear();
            return;
        }

        for(PlayingCard card: attackerField) defenderField.add(card);
        for(PlayingCard card: defenderCards) defenderField.add(card);
    }

    private void attack(DurakCommands cmd) {

        //TODO: Ausgabe dass zu viele Karten auf dem attackerField sind
        if(attackerField.size() >= maxNumOfAttackerCards) return;

        if (activePlayer.equals(attackerRight) && attackerRightFirstMove){
            cmd = ATTACK;
            attackerRightFirstMove = false;
         }

        if(cmd != ATTACK) return;

        LinkedList<PlayingCard> cards = activePlayer.attack(attackerField);
        for(PlayingCard card: cards) attackerField.add(card);
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

    /**
     * Get player roles.
     *(DEBUG)
     *
     * @return the string
     */
    public String getPlayerRoles(){
        String str = "";
        str += "Right:\t\t" + attackerRight.toString() + "\n";
        str += "Defender:\t"  + defender.toString() + "\n";
        str += "Left:\t\t" + attackerLeft.toString() + "\n";
        return str;
    }

}
