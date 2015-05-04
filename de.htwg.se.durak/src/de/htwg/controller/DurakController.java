package de.htwg.controller;

import de.htwg.model.*;

import java.util.Observable;
import java.util.LinkedList;

/**
 * Created by jawaigel on 16.04.2015.
 */
public class DurakController extends Observable {

    private static final int startNumOfCards = 6;
    private static final int maxCardsOnField = 12;

    private Deck deck;
    private Player activePlayer;
    private LinkedList<Player> players;
    private LinkedList<PlayingCard> field;
    private PlayingCard attackerCard;
    private PlayingCardColor trump;
    private Player defender, attacker;
    private boolean invalidPlayerInput;

    public DurakController() {
        deck = new Deck();
        players = new LinkedList<>();
        field = new LinkedList<>();

        players.add(new HumanPlayer());
        players.add(new ComputerPlayer());

        invalidPlayerInput = false;

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

        //Karten ziehen
        while(attacker.hand.size() < startNumOfCards && deck.getDeckSize() > 0){
            attacker.drawCard(deck.drawCard());
        }

        while(defender.hand.size() < startNumOfCards && deck.getDeckSize() > 0){
            defender.drawCard(deck.drawCard());
        }

        if(skip != true)
            players.add(players.remove(0));

        attacker = players.get(0);
        defender = players.get(1);

        activePlayer = attacker;

        field = new LinkedList<>();
    }

    public void playerMove(String cmd) {

        if(cmd.toCharArray()[0] == 't' && activePlayer.equals(defender)){
            takeCards();
        } else {
            round(Integer.parseInt(cmd));
        }

        setChanged();
        notifyObservers();
    }

    private void round(int cardIndex) {
        invalidPlayerInput = false;
        if(activePlayer.equals(attacker)){

            //TODO: Ausgabe dass zu viele Karten auf dem attackerField sind
            if(field.size() >= maxCardsOnField) return;

            PlayingCard attackingCard = null;
            try{
                attackingCard = activePlayer.attack(field, cardIndex);
            } catch (IllegalArgumentException e) {
                invalidPlayerInput = true;
                return;
            }

            if(attackingCard == null) {
                setNewPlayerRole(false);
                return;
            }

            attackerCard = attackingCard;
            field.add(attackerCard);

            activePlayer = defender;
        } else {
            PlayingCard defenderCard;

            try{
                defenderCard = activePlayer.defend(attackerCard, cardIndex);
            } catch (IllegalArgumentException e){
                invalidPlayerInput = true;
                return;
            }

            if(defenderCard == null){
                takeCards();
                return;
            }

            field.add(defenderCard);
            activePlayer = attacker;

            if(attacker.hand.isEmpty() && defender.hand.isEmpty())
                System.out.println("Unentschieden");
            else if(attacker.hand.isEmpty()){
                if(attacker.getClass().equals(HumanPlayer.class))
                    System.out.println("Вы дурак!");
                else
                    System.out.println("Computer hat gewonnen.");
            } else {
                if(attacker.getClass().equals(ComputerPlayer.class))
                    System.out.println("Вы дурак!");
                else
                    System.out.println("Spieler hat gewonnen.");
            }
        }
    }

    private void takeCards() {
        int size = field.size();

        for(int i=0; i<size; ++i)
            defender.drawCard(field.remove(0));

        setNewPlayerRole(true);
    }

    public LinkedList<PlayingCard> getPlayersHand(){
        if(attacker.getClass().equals(HumanPlayer.class)) return attacker.hand;
        else return defender.hand;
    }

    public LinkedList<PlayingCard> getComputerHand(){
        if(attacker.getClass().equals(ComputerPlayer.class)) return attacker.hand;
        else return defender.hand;
    }

    public LinkedList<PlayingCard> getField(){
        return field;
    }

    public boolean isHumanPlayer() {
        return activePlayer.getClass().equals(HumanPlayer.class);
    }

    public PlayingCardColor getTrump(){
        return trump;
    }

    public int getDeckSize() { return deck.getDeckSize(); }

    public boolean isInvalidPlayerInput() {
        return invalidPlayerInput;
    }
}
