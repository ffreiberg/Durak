package de.htwg.model;

import java.util.LinkedList;
import java.util.Random;

/**
 * Created by jan-erikwaigel on 16.04.15.
 */
public class ComputerPlayer extends Player {

    /**
     * The Names.
     */
    public String names[] = {"Albert","Allen","Bert","Bob","Cecil","Clarence","Elliot","Elmer","Ernie","Eugene",
            "Fergus","Ferris","Frasier","Fred","George","Graham","Harvey","Irwin","Lester","Marvin","Neil","Niles",
            "Oliver","Opie","Toby","Ulric","Ulysses","Uri","Waldo","Wally","Walt","Wesley","Yanni","Yogi","Yuri"};

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
    public PlayingCard attack(LinkedList<PlayingCard> cardsOnField, int cardIndex) {

        this.sortHand();
        if (cardsOnField.isEmpty()) return hand.remove(0);

        int index = scanField(cardsOnField);

        if(index == -1) return null;
        return hand.remove(index);
    }

    @Override
    public PlayingCard defend(PlayingCard cardToBeat, int cardIndex) {
        int cardDefend = -1;

        for(int i=0; i<hand.size(); ++i){
            if ((hand.get(i).getColor() == cardToBeat.getColor()
                    && (hand.get(i).getValue().ordinal() > cardToBeat.getValue().ordinal()))) {

                return hand.remove(i);
            }
            else if (hand.get(i).isTrump() && !cardToBeat.isTrump()) {
                cardDefend = i;
            }
        }
        if(cardDefend == -1)
            return null;
        else
            return hand.remove(cardDefend);
    }

    public int scanField(LinkedList<PlayingCard> currentField) {

        for (PlayingCard cardOnField : currentField) {
            for (int i=0; i<hand.size(); ++i) {
                if (hand.get(i).getValue() == cardOnField.getValue())
                    return i;
            }
        }

        return -1;
    }
}
