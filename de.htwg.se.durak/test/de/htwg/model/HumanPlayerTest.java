package de.htwg.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.Assert.*;

public class HumanPlayerTest {

    HumanPlayer player;

    @Before
    public void setUp() throws Exception {
        player = new HumanPlayer();
    }

    @After
    public void tearDown() throws Exception {
        player = null;
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAttackFailure() throws Exception {
        LinkedList<PlayingCard> cardsOnField = new LinkedList<>(Arrays.asList(
                new PlayingCard(PlayingCardValue.SIX, PlayingCardColor.HEARTS),
                new PlayingCard(PlayingCardValue.JACK, PlayingCardColor.HEARTS)
                )),
                cardsOnHand = new LinkedList<>(Arrays.asList(
                        new PlayingCard(PlayingCardValue.JACK, PlayingCardColor.SPADES),
                        new PlayingCard(PlayingCardValue.KING, PlayingCardColor.DIAMONDS)
                ));

        PlayingCard wrongCard = player.attack(cardsOnField, 1),
                wrongIndex = player.attack(cardsOnField, -1);

    }


    @Test
    public void testAttackSuccess() throws Exception {

        LinkedList<PlayingCard> cardsOnField = new LinkedList<>(Arrays.asList(
                new PlayingCard(PlayingCardValue.SIX, PlayingCardColor.HEARTS),
                new PlayingCard(PlayingCardValue.JACK, PlayingCardColor.HEARTS)
        )),
                cardsOnHand = new LinkedList<>(Arrays.asList(
                new PlayingCard(PlayingCardValue.JACK, PlayingCardColor.SPADES),
                new PlayingCard(PlayingCardValue.KING, PlayingCardColor.DIAMONDS)
        ));

        player.hand.addAll(cardsOnHand);

        PlayingCard card = player.attack(cardsOnField, 1);

        assertEquals(cardsOnHand.get(0).toString(),
                card.toString());
    }

    @Test
    public void testDefend() throws Exception {
        PlayingCard p = new PlayingCard(PlayingCardValue.SIX, PlayingCardColor.HEARTS);

    }
}