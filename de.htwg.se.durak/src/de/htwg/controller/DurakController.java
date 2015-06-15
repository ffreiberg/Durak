package de.htwg.controller;

import com.google.inject.Singleton;
import de.htwg.model.*;

import java.util.List;
import util.Observable;
import java.util.LinkedList;

/**
 * Created by jawaigel on 16.04.2015.
 */
@Singleton
public class DurakController extends Observable implements IDurakController {

    private static final int START_NUM_OF_CARDS = 6;
    private static final int MAX_CARDS_ON_FIELD = 12;
    private static final String SEPARATOR = "\n------------------------------\n";
    private static final char CMD_TAKE = 't';
    private static final int CMD_COMPUTER = 1;

    private Deck deck;
    private String statusLine = "Welcome to дурак!\n";

    private Player activePlayer;
    private List<Player> players;
    private Field field;
    private PlayingCard attackerCard;
    private PlayingCardColor trump;
    private Player defender, attacker;
    private Player winPlayer;
    private boolean invalidPlayerInput;

    /**
     * this is just a dummy for sonar
     */
    public DurakController() {
        this.deck = new Deck();
        this.players = new LinkedList<Player>();
        this.field = new Field();
    }

    @Override
    public void initGame() {

        players.add(new HumanPlayer());
        players.add(new ComputerPlayer());

        winPlayer = null;
        invalidPlayerInput = false;

        dealOutCards();
        setTrump();
        searchFirstAttacker();

        if (activePlayer instanceof ComputerPlayer) {
            this.playerMove("1");
        }
    }

    private void searchFirstAttacker() {
        //search lowest trump card and set first rightAttacker
        PlayingCard lowestTrumpCard = new PlayingCard(PlayingCardValue.ACE, trump);
        int i=0, lowestTrumpIndex=0;
        for(Player player: players){
            for(PlayingCard card: player.getPlayersHand()) {
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
        for(Player player: players) {
            player.setTrumpOnHand(trump);
        }
    }

    private void dealOutCards() {
        //deal out cards
        for(Player player: players){
            for(int i=0; i< START_NUM_OF_CARDS; ++i){
                player.drawCard(deck.drawCard());
            }
        }
    }

    @Override
    public void setNewPlayerRole(boolean skip) {

        //Karten ziehen
        while(attacker.getPlayersHand().size() < START_NUM_OF_CARDS && deck.getDeckSize() > 0){
            attacker.drawCard(deck.drawCard());
        }

        while(defender.getPlayersHand().size() < START_NUM_OF_CARDS && deck.getDeckSize() > 0){
            defender.drawCard(deck.drawCard());
        }

        if(!skip) {
            players.add(players.remove(0));
        }

        attacker = players.get(0);
        defender = players.get(1);

        activePlayer = attacker;

        field.clearField();
    }

    @Override
    public void getWinner(){
        if(deck.getDeckSize() != 0) {
            return;
        }

        if(attacker.getPlayersHand().isEmpty() && defender.getPlayersHand().isEmpty()){
            winPlayer = defender;
        } else if(attacker.getPlayersHand().isEmpty()){
            winPlayer = attacker;
        } else if(defender.getPlayersHand().isEmpty()) {
            winPlayer = defender;
        }

        notifyObservers();
    }

    @Override
    public void playerMove(String cmd) {

        invalidPlayerInput = false;

        if(cmd.toCharArray()[0] == CMD_TAKE && activePlayer.equals(defender)){

            takeCards();
            getWinner();
            if(winPlayer != null) {
                return;
            }

            if( activePlayer instanceof ComputerPlayer) {
                round(CMD_COMPUTER);
            }
        } else if(cmd.toCharArray()[0] == CMD_TAKE && activePlayer.equals(attacker)) {
            invalidPlayerInput = true;
        } else {
            round(Integer.parseInt(cmd));

            getWinner();
            if(winPlayer != null) {
                return;
            }

            while(!isHumanPlayer()){
                round(CMD_COMPUTER);

                getWinner();
                if(winPlayer != null) {
                    return;
                }
            }
        }

        notifyObservers();
    }

    @Override
    public void round(int cardIndex) {

        if(activePlayer.equals(attacker)){

            //TODO: Ausgabe dass zu viele Karten auf dem attackerField sind
            if(field.getFieldSize() >= MAX_CARDS_ON_FIELD) {
                return;
            }

            PlayingCard attackingCard = null;
            try{
                attackingCard = activePlayer.attack(field.getField(), cardIndex);
            } catch (IllegalArgumentException e) {
                invalidPlayerInput = true;
                return;
            }

            if(attackingCard == null) {
                setNewPlayerRole(false);
                return;
            }

            attackerCard = attackingCard;
            field.addCard(attackerCard);

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

            field.addCard(defenderCard);
            activePlayer = attacker;
        }
    }

    @Override
    public void takeCards() {
        int size = field.getFieldSize();

        for(int i=0; i<size; ++i) {
            defender.drawCard(field.getCard());
        }

        setNewPlayerRole(true);
    }

    @Override
    public List<PlayingCard> getPlayersHand(){
        if(attacker.getClass().equals(HumanPlayer.class)){
            return attacker.getPlayersHand();
        }
        else{
            return defender.getPlayersHand();
        }
    }

    @Override
    public List<PlayingCard> getComputerHand(){
        if(attacker.getClass().equals(ComputerPlayer.class)){
            return attacker.getPlayersHand();
        }
        else{
            return defender.getPlayersHand();
        }
    }

    @Override
    public String getStatus() {
        statusLine += "Trumpf [" + trump.toString() + "]\t Cards in Deck: [" + deck.getDeckSize() + "]";
        statusLine += SEPARATOR;
        statusLine += "Computer\t";

        for(int i = 1; i <= getComputerHand().size(); ++i) {
            statusLine += "[$]\t";
        }
        statusLine += SEPARATOR;
        statusLine += "Field\t\t";

        for(PlayingCard fieldCard: field.getField()) {
            statusLine += fieldCard.toString() + "\t";
        }
        statusLine += SEPARATOR;
        statusLine += "\t\t\t";

        for(int i = 1; i <= getPlayersHand().size(); ++i) {
            statusLine += "[" + i + "]\t";
        }
        statusLine += "\nPlayer\t\t";

        for(PlayingCard aCard: getPlayersHand()) {
            statusLine += aCard.toString() + "\t";
        }
        statusLine += SEPARATOR;

        return statusLine;
    }

    @Override
    public List<PlayingCard> getField(){
        return field.getField();
    }

    @Override
    public boolean isHumanPlayer() {
        return activePlayer instanceof HumanPlayer;
    }

    @Override
    public PlayingCardColor getTrump(){
        return trump;
    }

    @Override
    public int getDeckSize() { return deck.getDeckSize(); }

    @Override
    public boolean isInvalidPlayerInput() {
        return invalidPlayerInput;
    }

    @Override
    public Player getWinPlayer() { return winPlayer; }

    @Override
    public void setWinPlayer(Player p) { this.winPlayer = p; }

    @Override
    public void setActivePlayer(Player p) { this.activePlayer = p; }

    @Override
    public Player getActivePlayer() { return activePlayer; }

    @Override
    public void setAttacker(Player p) { attacker = p; }

    @Override
    public Player getAttacker() { return attacker; }

    @Override
    public void setPlayerInput(boolean input) { invalidPlayerInput = input; }

    @Override
    public Player getDefender() { return defender; }

    @Override
    public void setDefender(Player p) { defender = p; }

    @Override
    public void setField(PlayingCard p) { field.addCard(p); }

    @Override
    public void clearDeck() {
        int iter = getDeckSize();
        for (int i = 0; i < iter; ++i) {
            deck.drawCard();
        }
    }

    @Override
    public void setAttackerCard(PlayingCard p) { attackerCard = p; }
}
