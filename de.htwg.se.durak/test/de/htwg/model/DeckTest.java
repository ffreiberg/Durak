package de.htwg.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DeckTest {

    Deck deck;

    @Before
    public void setUp() throws Exception {
        deck = new Deck();
    }

    @After
    public void tearDown() throws Exception {
        deck = null;
    }

    @Test
    public void testSetTrump() throws Exception {
        deck.setTrump(PlayingCardColor.HEARTS);
        int size = deck.getDeckSize();
        PlayingCard p;
        for (int i = 0; i < size; ++i){
            p = deck.drawCard();
            if (p.getColor() == PlayingCardColor.HEARTS)
                assertTrue(p.isTrump());
        }
    }

    @Test
    public void testGetDeckSize() throws Exception {
        assertEquals(36, deck.getDeckSize());
    }

    @Test
    public void testDrawCard() throws Exception {
        PlayingCard p;
        p = deck.drawCard();
        assertEquals(35, deck.getDeckSize());
        assertEquals(p.getClass(), PlayingCard.class);
    }

    @Test
    public void testAddCard() throws Exception {
        deck.addCard(new PlayingCard(PlayingCardValue.SIX, PlayingCardColor.HEARTS));
        assertEquals(37, deck.getDeckSize());
    }
}