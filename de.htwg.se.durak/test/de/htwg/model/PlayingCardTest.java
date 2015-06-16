package de.htwg.model;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayingCardTest {

    PlayingCard p;

    @Before
    public void setUp() throws Exception {
        p = new PlayingCard(PlayingCardValue.SIX, PlayingCardColor.HEARTS);
    }

    @After
    public void tearDown() throws Exception {
        p = null;
    }

    @Test
    public void testGetValue() throws Exception {
        assertEquals(PlayingCardValue.SIX, p.getValue());
    }

    @Test
    public void testGetColor() throws Exception {
        assertEquals(PlayingCardColor.HEARTS, p.getColor());
    }

    @Test
    public void testGetHide() throws Exception {
        assertTrue(p.getHide());
    }

    @Test
    public void testSetTrump() throws Exception {
        assertFalse(p.isTrump());
        p.setTrump();
        assertTrue(p.isTrump());
        assertFalse(new PlayingCard(PlayingCardValue.ACE, PlayingCardColor.CLUBS).isTrump());
    }

    @Test
    public void testToString() throws Exception {
        assertEquals("♥6", p.toString());
        assertEquals("♣A", new PlayingCard(PlayingCardValue.ACE, PlayingCardColor.CLUBS).toString());
        assertEquals("♦K", new PlayingCard(PlayingCardValue.KING, PlayingCardColor.DIAMONDS).toString());
        assertEquals("♠Q", new PlayingCard(PlayingCardValue.QUEEN, PlayingCardColor.SPADES).toString());
    }
}