package de.htwg.controller;

import de.htwg.model.*;
import org.hamcrest.CoreMatchers;
import de.htwg.controller.DurakController;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class DurakControllerTest {

    DurakController controller;

    @Before
    public void setUp() throws Exception {
        controller = new DurakController();
        controller.initGame();
    }

    @After
    public void tearDown() throws Exception {
        controller = null;
    }

    @Test
    public void testPlayerMove() throws Exception {
        controller.playerMove("t");
    }

    @Test
    public void testGetPlayersHand() throws Exception {
        controller.setAttacker(new HumanPlayer());
        assertTrue(controller.getPlayersHand().isEmpty());
        controller.setAttacker(new ComputerPlayer());
        controller.setDefender(new HumanPlayer());
        assertTrue(controller.getPlayersHand().isEmpty());
    }

    @Test
    public void testGetComputerHand() throws Exception {
        controller.setAttacker(new ComputerPlayer());
        assertTrue(controller.getComputerHand().isEmpty());
        controller.setAttacker(new HumanPlayer());
        controller.setDefender(new ComputerPlayer());
        assertTrue(controller.getComputerHand().isEmpty());
    }

    @Test
    public void testGetField() throws Exception {
        List<PlayingCard> actual = controller.getField();
//        assertTrue(actual.isEmpty());
    }

    @Test
    public void testIsHumanPlayer() throws Exception {

    }

    @Test
    public void testGetTrump() throws Exception {
        PlayingCardColor actual = controller.getTrump();
        assertEquals(PlayingCardColor.class, actual.getClass());
    }

    @Test
    public void testGetDeckSize() throws Exception {
        int size = controller.getDeckSize();
        assertEquals(24, size);
    }

    @Test
    public void testTakeCards() throws Exception {
        controller.setField(new PlayingCard(PlayingCardValue.SIX,
                PlayingCardColor.HEARTS));
        controller.takeCards();
        assertTrue(controller.getField().isEmpty());
    }

    @Test
    public void testGetStatus() throws Exception {
        controller.setField(new PlayingCard(PlayingCardValue.SIX,
                PlayingCardColor.HEARTS));
        String actual = controller.getStatus();
        String expected = "Welcome to дурак!";
        assertThat(actual, CoreMatchers.containsString(expected));
    }

    @Test
    public void testGetWinPlayer() throws Exception {
        Player p = new HumanPlayer();
        controller.setWinPlayer(p);
        Player winPlayer = controller.getWinPlayer();
        assertEquals(p, winPlayer);
    }

    @Test
    public void testSetNewPlayerRole() throws Exception {

    }

    @Test
    public void testGetActivePlayer() throws Exception {
        controller.setActivePlayer(new HumanPlayer());
        assertTrue(controller.getActivePlayer() instanceof HumanPlayer);
    }

    @Test
    public void testGetAttacker() throws Exception {
        controller.setAttacker(new HumanPlayer());
        assertTrue(controller.getAttacker() instanceof HumanPlayer);
    }

    @Test
    public void testPlayerInput() throws Exception {
        controller.setPlayerInput(true);
        assertTrue(controller.isInvalidPlayerInput());
    }

    @Test
    public void testGetDefender() throws Exception {
        controller.setDefender(new HumanPlayer());
        assertTrue(controller.getDefender() instanceof HumanPlayer);
    }

    @Test
    public void testGetWinner() throws Exception {
        controller.clearDeck();
        controller.setDefender(new HumanPlayer());
        controller.getWinner();
        assertTrue(controller.getWinPlayer() instanceof HumanPlayer);
        controller.setAttacker(new ComputerPlayer());
        controller.getWinner();
        assertTrue(controller.getWinPlayer() instanceof HumanPlayer);
    }

    @Test
    public void testGetWinnerA() throws Exception {
        controller.clearDeck();
        controller.setAttacker(new HumanPlayer());
        controller.getWinner();
        assertTrue(controller.getWinPlayer() instanceof HumanPlayer);
    }

}