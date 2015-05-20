package de.htwg.view.gui;

import de.htwg.model.PlayingCard;

import javax.swing.*;
import java.awt.*;

/**
 * Created by jawaigel on 07.05.2015.
 */
public class PlayingCardButton extends JButton{

    private static final Dimension CARD_SIZE_DIMENSION = new Dimension(60, 100);

    private int position;

    public PlayingCardButton(PlayingCard card, int position) {

        if(card.getHide()) {
            super.setText("$");
        } else {
            super.setText(card.toString());
        }

        this.setPreferredSize(CARD_SIZE_DIMENSION);
        this.setVerticalAlignment(CENTER);

        this.position = position;
    }

    public int getPosition() {
        return this.position;
    }
}
