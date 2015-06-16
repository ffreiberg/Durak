package de.htwg.controller;

import de.htwg.model.Player;
import de.htwg.model.PlayingCard;
import de.htwg.model.PlayingCardColor;

import java.util.List;
import util.*;

/**
 * Created by fafreibe on 10.06.2015.
 */
public interface IDurakController extends IObservable {
    /**
     * this is just a dummy for sonar
     */
    void initGame();

    /**
     * this is just a dummy for sonar
     */
    void setNewPlayerRole(boolean skip);

    /**
     * this is just a dummy for sonar
     */
    void getWinner();

    /**
     * this is just a dummy for sonar
     */
    void playerMove(String cmd);

    /**
     * this is just a dummy for sonar
     */
    void round(int cardIndex);

    /**
     * this is just a dummy for sonar
     */
    void takeCards();

    /**
     * this is just a dummy for sonar
     */
    List<PlayingCard> getPlayersHand();

    /**
     * this is just a dummy for sonar
     */
    List<PlayingCard> getComputerHand();

    /**
     * this is just a dummy for sonar
     */
    String getStatus();

    /**
     * this is just a dummy for sonar
     */
    List<PlayingCard> getField();

    /**
     * this is just a dummy for sonar
     */
    boolean isHumanPlayer();

    /**
     * this is just a dummy for sonar
     */
    PlayingCardColor getTrump();

    /**
     * this is just a dummy for sonar
     */
    int getDeckSize();

    /**
     * this is just a dummy for sonar
     */
    boolean isInvalidPlayerInput();

    /**
     * this is just a dummy for sonar
     */
    Player getWinPlayer();

    /**
     * this is just a dummy for sonar
     */
    void setWinPlayer(Player p);

    /**
     * this is just a dummy for sonar
     */
    void setActivePlayer(Player p);

    /**
     * this is just a dummy for sonar
     */
    Player getActivePlayer();

    /**
     * this is just a dummy for sonar
     */
    void setAttacker(Player p);

    /**
     * this is just a dummy for sonar
     */
    Player getAttacker();

    /**
     * this is just a dummy for sonar
     */
    void setPlayerInput(boolean input);

    /**
     * this is just a dummy for sonar
     */
    Player getDefender();

    /**
     * this is just a dummy for sonar
     */
    void setDefender(Player p);

    /**
     * this is just a dummy for sonar
     */
    void setField(PlayingCard p);

    /**
     * this is just a dummy for sonar
     */
    void clearDeck();

    /**
     * this is just a dummy for sonar
     */
    void setAttackerCard(PlayingCard p);
}
