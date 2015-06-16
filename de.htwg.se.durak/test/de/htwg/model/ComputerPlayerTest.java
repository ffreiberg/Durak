package de.htwg.model;

import de.htwg.model.impl.ComputerPlayer;
import de.htwg.model.impl.PlayingCard;
import de.htwg.model.impl.PlayingCardColor;
import de.htwg.model.impl.PlayingCardValue;
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
        this.botDummy = null;
        this.cardsOnField = null;
        this.cardsOnHand = null;
        this.cardToBeat = null;
        this.emptyField = null;
        this.noValidCards = null;
        this.singleCard = null;
        this.trumpCard = null;
        this.successCard = null;
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
}