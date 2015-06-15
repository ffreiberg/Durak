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
    void initGame();

    void setNewPlayerRole(boolean skip);

    void getWinner();

    void playerMove(String cmd);

    void round(int cardIndex);

    void takeCards();

    List<PlayingCard> getPlayersHand();

    List<PlayingCard> getComputerHand();

    String getStatus();

    List<PlayingCard> getField();

    boolean isHumanPlayer();

    PlayingCardColor getTrump();

    int getDeckSize();

    boolean isInvalidPlayerInput();

    Player getWinPlayer();

    void setWinPlayer(Player p);

    void setActivePlayer(Player p);

    Player getActivePlayer();

    void setAttacker(Player p);

    Player getAttacker();

    void setPlayerInput(boolean input);

    Player getDefender();

    void setDefender(Player p);

    void setField(PlayingCard p);

    void clearDeck();

    void setAttackerCard(PlayingCard p);
}
