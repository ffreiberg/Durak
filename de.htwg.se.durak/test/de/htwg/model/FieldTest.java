package de.htwg.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.Assert.*;

public class FieldTest {

    Field field;

    @Before
    public void setUp() throws Exception {
        field = new Field();
    }

    @After
    public void tearDown() throws Exception {
        field = null;
    }

    @Test
    public void testGetCard() throws Exception {
        field.addCard(new PlayingCard(PlayingCardValue.SIX, PlayingCardColor.HEARTS));
        PlayingCard pc = field.getCard();
        assertEquals(pc.getColor().ordinal(), new PlayingCard(PlayingCardValue.SIX, PlayingCardColor.HEARTS).getColor().ordinal());
        assertEquals(pc.getValue().ordinal(), new PlayingCard(PlayingCardValue.SIX, PlayingCardColor.HEARTS).getValue().ordinal());
    }

    @Test
    public void testGetField() throws Exception {
        LinkedList<PlayingCard> expected = new LinkedList<PlayingCard>(Arrays.asList(new PlayingCard(PlayingCardValue.SIX, PlayingCardColor.HEARTS),
                new PlayingCard(PlayingCardValue.SIX, PlayingCardColor.CLUBS)));
        field.addCard(new PlayingCard(PlayingCardValue.SIX, PlayingCardColor.HEARTS));
        field.addCard(new PlayingCard(PlayingCardValue.SIX, PlayingCardColor.CLUBS));

        for (int i = 0; i < expected.size(); ++i) {
            assertEquals(expected.get(i).getColor().ordinal(), field.getField().get(i).getColor().ordinal());
            assertEquals(expected.get(i).getValue().ordinal(), field.getField().get(i).getValue().ordinal());
        }
    }

    @Test
    public void testClearField() throws Exception {
        field.addCard(new PlayingCard(PlayingCardValue.SIX, PlayingCardColor.HEARTS));
        field.clearField();
        assertEquals(0, field.getFieldSize());
    }

    @Test
    public void testGetFieldSize() throws Exception {
        field.addCard(new PlayingCard(PlayingCardValue.SIX, PlayingCardColor.HEARTS));
        field.addCard(new PlayingCard(PlayingCardValue.SIX, PlayingCardColor.CLUBS));
        assertEquals(2, field.getFieldSize());
    }

    @Test
    public void testToString() throws Exception {
        field.addCard(new PlayingCard(PlayingCardValue.SIX, PlayingCardColor.HEARTS));
        assertEquals("♥6", field.toString());
    }
}