package de.htwg.view.gui;

import de.htwg.controller.IDurakController;
import de.htwg.model.PlayingCard;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.util.List;

import util.Event;
import util.IObserver;

/**
 * Created by jan-erikwaigel on 12.05.15.
 */
public class FieldCardPanel extends JPanel implements IObserver{

    private List<PlayingCard> cards;
    private IDurakController controller;

    public FieldCardPanel(IDurakController controller, List<PlayingCard> cards) {
        this.cards = cards;
        this.controller = controller;
        this.controller.addObserver(this);

        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setBorder(new BevelBorder(BevelBorder.LOWERED));
        paintCards();
    }

    private void paintCards() {
        this.removeAll();

        for(PlayingCard card: cards){
            PlayingCardButton btn = new PlayingCardButton(card, 0);
            this.add(btn);
        }
        updateUI();
    }

    public void disableField() {
        for(Component c: this.getComponents()) {
            c.setEnabled(false);
        }
    }

    @Override
    public void update(Event e) {
        if(controller.getWinPlayer() == null){
            paintCards();
        }
    }

}
