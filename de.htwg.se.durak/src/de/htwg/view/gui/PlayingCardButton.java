package de.htwg.view.gui;

import de.htwg.model.PlayingCard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.EventListener;

/**
 * Created by jawaigel on 07.05.2015.
 */
public class PlayingCardButton extends JButton{

    private int position;

    public PlayingCardButton(PlayingCard card, int position) {

        if(card.getHide()) {
            super.setText("$");
        } else {
            super.setText(card.toString());
        }
        this.setPreferredSize(new Dimension(60, 100));
        this.position = position;
    }

    public int getPosition() {
        return this.position;
    }
}
