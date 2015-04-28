package de.htwg.model;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.LinkedList;
import java.util.Random;

/**
 * Created by jan-erikwaigel on 16.04.15.
 */
public class ComputerPlayer extends Player {

    /**
     * The Names.
     */
    public String names[] = {"Elif", "Esac", "Julio", "Jamtonio", "LaDasha", "Schlomo", "Micha", "Walpurga", "Ralle",
            "Karma", "Vladi", "Mustafa", "Yildirim", "Lothar", "Roland", "CR7", "Mausi96", "Allah"};

    /**
     * Instantiates a new Computer player.
     */
    public ComputerPlayer(){
        playerName = "BOT " + names[new Random().nextInt(names.length - 1)];
    }

    /**
     * Play card.
     *
     * @return the playing card [ ]
     * @param cardsOnField
     */
    @Override
    public LinkedList<PlayingCard> attack(LinkedList<PlayingCard> cardsOnField) {

        LinkedList<PlayingCard> cardsToPlay = scanFieldAttack(cardsOnField);

        if (cardsOnField.isEmpty()) getLowestCard();

        return null;
        //throw new NotImplementedException();
    }

    private PlayingCard getLowestCard() {
        PlayingCard lowestCard = hand.get(0);

        for (PlayingCard cardOnHand : hand)
        {
            if (lowestCard.getValue().ordinal() < cardOnHand.getValue().ordinal())
                lowestCard = cardOnHand;
        }

        return lowestCard;
    }

    @Override
    public LinkedList<PlayingCard> defend(LinkedList<PlayingCard> currentField) {
        throw new NotImplementedException();
    }

    public LinkedList<PlayingCard> scanFieldAttack(LinkedList<PlayingCard> currentField) {
        LinkedList<PlayingCard> validCards = new LinkedList<PlayingCard>();

        for (PlayingCard cardOnField : currentField) {
            for (PlayingCard cardOnHand : hand) {
                if (cardOnHand.getValue() == cardOnField.getValue())
                    validCards.add(cardOnHand);
            }
        }

        return validCards;
    }
}
