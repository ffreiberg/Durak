package de.htwg.view.gui;

import de.htwg.controller.DurakController;
import de.htwg.model.PlayingCard;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by jan-erikwaigel on 12.05.15.
 */
public class FieldCardPanel extends JPanel implements Observer{

    private List<PlayingCard> cards;

    public FieldCardPanel(DurakController controller, List<PlayingCard> cards) {
        this.cards = cards;
        controller.addObserver(this);

        this.setLayout(new FlowLayout(FlowLayout.LEFT));
    }

    public void paintCards() {
        this.removeAll();

        for(PlayingCard card: cards){
            PlayingCardButton btn = new PlayingCardButton(card, 0);
            this.add(btn);
        }
        updateUI();
    }

    @Override
    public void update(Observable o, Object arg) {
        paintCards();
    }
}
