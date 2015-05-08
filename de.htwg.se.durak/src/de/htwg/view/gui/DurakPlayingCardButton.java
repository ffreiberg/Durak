package de.htwg.view.gui;

import de.htwg.model.PlayingCard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by jawaigel on 07.05.2015.
 */
public class DurakPlayingCardButton extends JButton {

    private PlayingCard card;

    public DurakPlayingCardButton(PlayingCard card) {
        super(card.toString());
        this.card = card;

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(card.toString());
                //return card
            }
        });
    }



}
