package de.htwg.model;

import java.util.List;

/**
 * Created by jan-erikwaigel on 16.04.15.
 */
public class ComputerPlayer extends Player {

    /**
     * The Names.
     */
    @Override
    public PlayingCard attack(List<PlayingCard> cardsOnField, int cardIndex) {

        this.sortHand();
        if (cardsOnField.isEmpty()) {
            return getPlayersHand().remove(firstAttack());
        }

        int index = scanField(cardsOnField);

        if(index == -1) {
            return null;
        }

        PlayingCard retCard = getPlayersHand().remove(index);
        retCard.setHide(true);
        return retCard;
    }

    private int firstAttack() {
        int i = 0;

        for (PlayingCard cardOnHand : getPlayersHand()){
            if (!cardOnHand.isTrump()) {
                return i;
            }
            ++i;
        }
        return 0;
    }

    @Override
    public PlayingCard defend(PlayingCard cardToBeat, int cardIndex) {
        int cardDefend = -1;

        for(int i=0; i<getPlayersHand().size(); ++i){
            if ((getPlayersHand().get(i).getColor() == cardToBeat.getColor()
                    && (getPlayersHand().get(i).getValue().ordinal() > cardToBeat.getValue().ordinal()))) {

                return getPlayersHand().remove(i);
            }
            else if (getPlayersHand().get(i).isTrump() && !cardToBeat.isTrump()) {
                cardDefend = i;
            }
        }
        if(cardDefend == -1) {
            return null;
        }
        else {
            PlayingCard returnCard = getPlayersHand().remove(cardDefend);
            returnCard.setHide(true);
            return returnCard;
        }
    }

    public int scanField(List<PlayingCard> currentField) {

        for (PlayingCard cardOnField : currentField) {
            for (int i=0; i<getPlayersHand().size(); ++i) {
                if (getPlayersHand().get(i).getValue() == cardOnField.getValue()) {
                    return i;
                }
            }
        }

        return -1;
    }
}
