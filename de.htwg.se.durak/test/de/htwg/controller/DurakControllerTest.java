package de.htwg.controller;

import de.htwg.model.*;
import org.hamcrest.CoreMatchers;
import de.htwg.controller.DurakController;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
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
    public void testPlayerMoveHumanDefender() throws Exception {
        controller.setDefender(new HumanPlayer());
        controller.setActivePlayer(controller.getDefender());
        controller.playerMove("t");
        assertFalse(controller.isInvalidPlayerInput());
    }

    @Test
    public void testPlayerMoveBotDefender() throws Exception {
        controller.setDefender(new ComputerPlayer());
        controller.setActivePlayer(controller.getDefender());
        controller.playerMove("t");
        assertFalse(controller.isInvalidPlayerInput());
    }

    @Test
    public void testPlayerMoveWinPlayerSet() throws Exception {
        controller.setActivePlayer(controller.getDefender());
        controller.setWinPlayer(new HumanPlayer());
        controller.playerMove("t");
        assertFalse(controller.isInvalidPlayerInput());
    }

    @Test
    public void testPlayerMoveX() throws Exception {
        controller.setDefender(new HumanPlayer());
        controller.setActivePlayer(controller.getDefender());
    }

    @Test
    public void testPlayerMoveInvalid() throws Exception {
        controller.setActivePlayer(controller.getAttacker());
        controller.playerMove("t");
        assertTrue(controller.isInvalidPlayerInput());
    }

    @Test
    public void testPlayerMoveElse() throws Exception {
        controller.setActivePlayer(controller.getAttacker());
        controller.setWinPlayer(new HumanPlayer());
        controller.playerMove("1");
        assertFalse(controller.isInvalidPlayerInput());
    }

    @Test
    public void testPlayerMoveBot() throws Exception {
        controller.setActivePlayer(new ComputerPlayer());
        controller.playerMove("1");
        assertFalse(controller.isInvalidPlayerInput());
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
        assertNotNull(actual);
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
        controller.setAttacker(new HumanPlayer());
        controller.setDefender(new ComputerPlayer());
        controller.setNewPlayerRole(true);
    }

    @Test
    public void testSetNewPlayerRoleA() throws Exception {
        controller.clearDeck();
        controller.setAttacker(new HumanPlayer());
        controller.setDefender(new ComputerPlayer());
        controller.setNewPlayerRole(false);
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
        controller.getWinner();
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

    @Test
    public void testRoundMaxField() throws Exception {
        LinkedList<PlayingCard> p = new LinkedList<PlayingCard>(Arrays.asList(
                new PlayingCard(PlayingCardValue.SIX, PlayingCardColor.HEARTS),
                new PlayingCard(PlayingCardValue.SEVEN, PlayingCardColor.HEARTS),
                new PlayingCard(PlayingCardValue.EIGHT, PlayingCardColor.HEARTS),
                new PlayingCard(PlayingCardValue.NINE, PlayingCardColor.HEARTS),
                new PlayingCard(PlayingCardValue.TEN, PlayingCardColor.HEARTS),
                new PlayingCard(PlayingCardValue.JACK, PlayingCardColor.HEARTS),
                new PlayingCard(PlayingCardValue.QUEEN, PlayingCardColor.HEARTS),
                new PlayingCard(PlayingCardValue.KING, PlayingCardColor.HEARTS),
                new PlayingCard(PlayingCardValue.ACE, PlayingCardColor.HEARTS),
                new PlayingCard(PlayingCardValue.SIX, PlayingCardColor.SPADES),
                new PlayingCard(PlayingCardValue.SEVEN, PlayingCardColor.SPADES),
                new PlayingCard(PlayingCardValue.EIGHT, PlayingCardColor.SPADES),
                new PlayingCard(PlayingCardValue.NINE, PlayingCardColor.SPADES)));
        controller.getField().addAll(p);
        controller.setActivePlayer(controller.getAttacker());
        controller.round(0);
    }

    @Test
    public void testRoundAttackerInvalid() throws Exception {
        controller.setAttacker(new HumanPlayer());
        controller.setActivePlayer(controller.getAttacker());
        controller.round(99);
        assertTrue(controller.isInvalidPlayerInput());
        controller.setDefender(new HumanPlayer());
        controller.setActivePlayer(controller.getDefender());
        controller.round(99);
        assertTrue(controller.isInvalidPlayerInput());
    }

    @Test
    public void testRound() throws Exception {
        Player bot = new ComputerPlayer(),
            p = new HumanPlayer();

        controller.setAttacker(p);
        controller.setActivePlayer(p);
        controller.setDefender(bot);
        controller.round(1);
        assertTrue(controller.isInvalidPlayerInput());
    }

    @Test
    public void testRoundX() throws Exception {
        Player bot = new ComputerPlayer(),
                p = new HumanPlayer();

        p.getPlayersHand().add(new PlayingCard(PlayingCardValue.ACE, PlayingCardColor.HEARTS));

        controller.setDefender(p);
        controller.setActivePlayer(p);
        controller.setAttackerCard(new PlayingCard(PlayingCardValue.SIX, PlayingCardColor.HEARTS));
        controller.round(1);
        assertTrue(!controller.getField().isEmpty());
    }
}