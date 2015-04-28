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
     */
    @Override
    public LinkedList<PlayingCard> attack(LinkedList<PlayingCard> attackerField, LinkedList<PlayingCard> defenderField) {
        LinkedList<PlayingCard> cardsToPlay = new LinkedList<PlayingCard>();
        for (PlayingCard cardOnField : defenderField)
        {
            for (PlayingCard cardOnHand : hand) {
                if (cardOnField.equals(cardOnHand))
                {
                    cardsToPlay.add(cardOnHand);
                    return cardsToPlay;
                }
            }
        }
        return null;
        //throw new NotImplementedException();
    }

    @Override
    public LinkedList<PlayingCard> defend(LinkedList<PlayingCard> currentField) {
        throw new NotImplementedException();
    }

    public LinkedList<PlayingCard> scanField(LinkedList<PlayingCard> currentField) {
        LinkedList<PlayingCard> validCards = new LinkedList<PlayingCard>();

        for (PlayingCard cardOnField : currentField) {
            for (PlayingCard cardOnHand : hand) {
                //TODO:
            }
        }

        return validCards;
    }
}
