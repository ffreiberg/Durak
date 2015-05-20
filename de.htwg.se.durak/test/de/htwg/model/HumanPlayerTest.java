package de.htwg.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.Assert.*;

public class HumanPlayerTest {

    HumanPlayer player;
    PlayingCard cardToBeat, successCard, trumpCard;
    LinkedList<PlayingCard> cardsOnField, cardsOnHand, emptyField;

    @Before
    public void setUp() throws Exception {
        player = new HumanPlayer();
        cardsOnField = new LinkedList<PlayingCard>(Arrays.asList(
                new PlayingCard(PlayingCardValue.SIX, PlayingCardColor.HEARTS),
                new PlayingCard(PlayingCardValue.JACK, PlayingCardColor.HEARTS)
        ));
        cardsOnHand = new LinkedList<PlayingCard>(Arrays.asList(
                        new PlayingCard(PlayingCardValue.SIX, PlayingCardColor.HEARTS),
                        new PlayingCard(PlayingCardValue.JACK, PlayingCardColor.SPADES),
                        new PlayingCard(PlayingCardValue.QUEEN, PlayingCardColor.DIAMONDS),
                        new PlayingCard(PlayingCardValue.KING, PlayingCardColor.HEARTS),
                        new PlayingCard(PlayingCardValue.ACE, PlayingCardColor.CLUBS)
        ));
        emptyField = new LinkedList<PlayingCard>();
        cardToBeat = new PlayingCard(PlayingCardValue.SEVEN, PlayingCardColor.HEARTS);
        successCard = new PlayingCard(PlayingCardValue.KING, PlayingCardColor.HEARTS);
        trumpCard = new PlayingCard(PlayingCardValue.ACE, PlayingCardColor.CLUBS);
        player.getPlayersHand().addAll(cardsOnHand);
        player.getPlayersHand().get(4).setTrump();
    }

    @After
    public void tearDown() throws Exception {
        player = null;
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAttackWrongCard() throws Exception {
        PlayingCard wrongCard = player.attack(cardsOnField, 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAttackLowerIndex() throws Exception {
        PlayingCard wrongIndex = player.attack(cardsOnField, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAttackGreaterIndex() throws Exception {
        PlayingCard wrongIndex = player.attack(cardsOnField, player.getPlayersHand().size()+1);
    }

    @Test
    public void testAttackEndTurn() throws Exception {
        PlayingCard endTurn = player.attack(cardsOnField, 0);
        assertNull(endTurn);
    }

    @Test
    public void testAttackEmptyField() throws Exception {
        PlayingCard cardToPlay = player.attack(emptyField, 2),
            pc = new PlayingCard(PlayingCardValue.JACK, PlayingCardColor.SPADES);
        assertEquals(pc.toString(), cardToPlay.toString());
    }

    @Test
    public void testAttackSuccess() throws Exception {
        PlayingCard card = player.attack(cardsOnField, 2);

        assertEquals(cardsOnHand.get(1).toString(),
                card.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDefendLowerIndex() throws Exception {
        PlayingCard wrondIndex = player.defend(cardToBeat, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDefendGreaterIndex() throws Exception {
        PlayingCard wrondIndex = player.defend(cardToBeat, player.getPlayersHand().size()+1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDefendWrongCard() throws Exception {
        PlayingCard wrongCard = player.defend(cardToBeat, 2);
    }

    @Test
    public void testDefendBeatWithHigherCard() throws Exception {
        PlayingCard p = player.defend(cardToBeat, 4);
        assertEquals(successCard.toString(), p.toString());
    }

    @Test
    public void testDefendBeathWithTrump() throws Exception {
        PlayingCard p = player.defend(cardToBeat, 5);
        assertEquals(trumpCard.toString(), p.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDefendTryToBeatLowerCard() throws Exception {
        cardToBeat.setTrump();
        PlayingCard p = player.defend(cardToBeat, 1);
    }

}