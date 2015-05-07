package de.htwg.view.gui;

import de.htwg.model.PlayingCard;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

/**
 * Created by jawaigel on 07.05.2015.
 */
public class DurakCardPanel extends JPanel {

    private LinkedList<PlayingCard> cards;

    public DurakCardPanel(LinkedList<PlayingCard> cards) {
        this.cards = cards;
        paintCards();
    }

    public void paintCards() {
        this.removeAll();
        this.setLayout(new GridLayout(1, this.cards.size()));
        for(PlayingCard card: this.cards){
            this.add(new DurakPlayingCardButton(card));
        }
        updateUI();
    }
}
