package de.htwg.controller;

import de.htwg.model.*;
import org.hamcrest.CoreMatchers;
import org.hamcrest.core.StringContains;
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

    }

    @Test
    public void testGetPlayersHand() throws Exception {

    }

    @Test
    public void testGetComputerHand() throws Exception {

    }

    @Test
    public void testGetField() throws Exception {
        List<PlayingCard> actual = controller.getField();
        assertTrue(actual.isEmpty());
    }

    @Test
    public void testIsHumanPlayer() throws Exception {

    }

    @Test
    public void testGetTrump() throws Exception {
        PlayingCardColor actual = controller.getTrump();
        assertTrue(actual instanceof PlayingCardColor);
    }

    @Test
    public void testGetDeckSize() throws Exception {
        int size = controller.getDeckSize();
        assertEquals(24, size);
    }

    @Test
    public void testIsInvalidPlayerInput() throws Exception {

    }

    @Test
    public void testGetStatus() throws Exception {
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
}