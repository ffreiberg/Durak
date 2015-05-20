package de.htwg.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ComputerPlayerTest {

    ComputerPlayer bot;

    @Before
    public void setUp() throws Exception {
        bot = new ComputerPlayer();
    }

    @After
    public void tearDown() throws Exception {
        this.bot = null;
    }

    @Test
    public void testAttack() throws Exception {

    }

    @Test
    public void testDefend() throws Exception {

    }

    @Test
    public void testScanField() throws Exception {

    }
    @Test
    public void testDrawCard() throws Exception {
        bot.drawCard(new PlayingCard(PlayingCardValue.SIX, PlayingCardColor.CLUBS));
        bot.sortHand();
        assertEquals(new PlayingCard(PlayingCardValue.SIX, PlayingCardColor.CLUBS).toString(), bot.getPlayersHand().get(0).toString());
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