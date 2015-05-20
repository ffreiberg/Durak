package de.htwg.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class ComputerPlayerTest {

    ComputerPlayer bot, botDummy;
    PlayingCard cardToBeat, successCard, trumpCard;
    List<PlayingCard> cardsOnField, cardsOnHand, emptyField, noValidCards, singleCard;

    @Before
    public void setUp() throws Exception {
        bot = new ComputerPlayer();
        botDummy = new ComputerPlayer();
        cardsOnField = new LinkedList<PlayingCard>(Arrays.asList(
                new PlayingCard(PlayingCardValue.SIX, PlayingCardColor.HEARTS),
                new PlayingCard(PlayingCardValue.JACK, PlayingCardColor.HEARTS)
        ));
        cardsOnHand = new LinkedList<PlayingCard>(Arrays.asList(
                new PlayingCard(PlayingCardValue.SIX, PlayingCardColor.SPADES),
                new PlayingCard(PlayingCardValue.JACK, PlayingCardColor.SPADES),
                new PlayingCard(PlayingCardValue.QUEEN, PlayingCardColor.DIAMONDS),
                new PlayingCard(PlayingCardValue.KING, PlayingCardColor.HEARTS),
                new PlayingCard(PlayingCardValue.ACE, PlayingCardColor.CLUBS)
        ));
        noValidCards = new LinkedList<PlayingCard>(Arrays.asList(
                        new PlayingCard(PlayingCardValue.QUEEN, PlayingCardColor.DIAMONDS),
                        new PlayingCard(PlayingCardValue.ACE, PlayingCardColor.CLUBS)
                ));
        singleCard = new LinkedList<PlayingCard>(Arrays.asList(
                new PlayingCard(PlayingCardValue.NINE, PlayingCardColor.DIAMONDS)
        ));
        emptyField = new LinkedList<PlayingCard>();
        cardToBeat = new PlayingCard(PlayingCardValue.SEVEN, PlayingCardColor.HEARTS);
        successCard = new PlayingCard(PlayingCardValue.KING, PlayingCardColor.HEARTS);
        trumpCard = new PlayingCard(PlayingCardValue.ACE, PlayingCardColor.CLUBS);
        bot.getPlayersHand().addAll(cardsOnHand);
        bot.setTrumpOnHand(PlayingCardColor.CLUBS);
    }

    @After
    public void tearDown() throws Exception {
        this.bot = null;
    }

    @Test
    public void testFirstAttack() throws Exception {
        PlayingCard p = bot.attack(emptyField, 0);
        assertEquals(new PlayingCard(PlayingCardValue.SIX, PlayingCardColor.SPADES).toString(),
                p.toString());
        botDummy.getPlayersHand().addAll(singleCard);
        botDummy.setTrumpOnHand(PlayingCardColor.DIAMONDS);
        p = botDummy.attack(emptyField, 0);
        assertEquals(new PlayingCard(PlayingCardValue.NINE, PlayingCardColor.DIAMONDS).toString(),
                p.toString());
    }

    @Test
    public void testAttackNoValidCards() throws Exception {
        botDummy.getPlayersHand().addAll(noValidCards);
        PlayingCard p = botDummy.attack(cardsOnField, 3);
        assertNull(p);
    }

    @Test
    public void testAttackSuccess() throws  Exception {
        PlayingCard p = bot.attack(cardsOnField, 1);
        assertEquals(new PlayingCard(PlayingCardValue.SIX, PlayingCardColor.SPADES).toString(),
                p.toString());
    }

    @Test
    public void testDefend() throws Exception {
        PlayingCard p = bot.defend(cardToBeat, 0);
        assertEquals(new PlayingCard(PlayingCardValue.KING, PlayingCardColor.HEARTS).toString(),
                p.toString());
        botDummy.getPlayersHand().addAll(singleCard);
        botDummy.setTrumpOnHand(PlayingCardColor.DIAMONDS);
        p = botDummy.defend(cardToBeat, 0);
        assertEquals(new PlayingCard(PlayingCardValue.NINE, PlayingCardColor.DIAMONDS).toString(),
                p.toString());
        botDummy.getPlayersHand().clear();
        botDummy.getPlayersHand().addAll(noValidCards);
        p = botDummy.defend(cardToBeat, 0);
        assertNull(p);
    }

    @Test
    public void testScanField() throws Exception {

    }
    @Test
    public void testDrawCard() throws Exception {
        bot.drawCard(new PlayingCard(PlayingCardValue.SIX, PlayingCardColor.CLUBS));
        bot.sortHand();
        assertEquals(new PlayingCard(PlayingCardValue.SIX, PlayingCardColor.CLUBS).toString(),
                bot.getPlayersHand().get(1).toString());
    }

/*
    package de.htwg.model;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static de.htwg.model.PlayingCardValue.*;
import static de.htwg.model.PlayingCardColor.*;
import de.htwg.model.PlayingCard;
import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.LinkedList;

public class ComputerPlayerTest extends TestCase {

    ComputerPlayer bot;
    LinkedList<PlayingCard> field, field2;

    @Before
    public void setUp() throws Exception {
        bot = new ComputerPlayer();
        bot.drawCard(new PlayingCard(ACE, SPADES));
        field = new LinkedList<>();

        PlayingCard c1 = new PlayingCard(SEVEN, HEARTS);
        PlayingCard c2 = new PlayingCard(ACE, HEARTS);
        field.add(c1);
        field.add(c2);

        field2 = new LinkedList<>();
        PlayingCard c3 = new PlayingCard(SEVEN, HEARTS);
        PlayingCard c4 = new PlayingCard(KING, HEARTS);

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testAttackSucceed() throws Exception {
        PlayingCard attackerCard = bot.attack(field, 0);
        PlayingCard expectedCard = new PlayingCard(ACE, SPADES);

        assertTrue(attackerCard.getColor() == expectedCard.getColor()
                    && attackerCard.getValue() == expectedCard.getValue());
    }

    @Test
    public void testDefendFailed() throws Exception {
        PlayingCard attackerCard = bot.defend(new PlayingCard(SIX, CLUBS), 0);
        assertTrue(attackerCard == null);
    }

   @Test
    public void testDefendSucceed() throws Exception {
       PlayingCard attackerCard = bot.defend(new PlayingCard(SIX, SPADES), 0);
       assertTrue(attackerCard != null);
    }

    /*@Test
    public void testScanFieldSucceed() throws Exception {
        PlayingCard scannedCard = bot.scanField(field);
        PlayingCard expectedCard = new PlayingCard(ACE, SPADES);

        assertTrue(scannedCard.getColor() == expectedCard.getColor()
                && scannedCard.getValue() == expectedCard.getValue());
    }

    @Test
    public void testScanFieldFailed() throws Exception {
        //PlayingCard scannedCard = bot.scanField(field2);


        assertTrue(scannedCard == null);
    }
}
*/
}