package de.htwg.view.gui.impl;

import de.htwg.controller.IDurakController;
import de.htwg.model.impl.PlayingCard;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.util.List;

import de.htwg.view.gui.IFieldCardPanel;
import util.Event;

/**
 * Created by jan-erikwaigel on 12.05.15.
 */
public class FieldCardPanel extends JPanel implements IFieldCardPanel {

    private List<PlayingCard> cards;
    private IDurakController controller;

    /**
     * this is just a dummy for sonar
     */
    public FieldCardPanel(IDurakController controller, List<PlayingCard> cards) {
        this.cards = cards;
        this.controller = controller;
        this.controller.addObserver(this);

        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setBorder(new BevelBorder(BevelBorder.LOWERED));
        paintCards();
    }

    /**
     * this is just a dummy for sonar
     */
    private void paintCards() {
        this.removeAll();

        for(PlayingCard card: cards){
            PlayingCardButton btn = new PlayingCardButton(card, 0);
            this.add(btn);
        }
        updateUI();
    }

    /**
     * this is just a dummy for sonar
     */
    @Override
    public void disableField() {
        for(Component c: this.getComponents()) {
            c.setEnabled(false);
        }
    }

    /**
     * this is just a dummy for sonar
     */
    @Override
    public void update(Event e) {
        if(controller.getWinPlayer() == null){
            paintCards();
        }
    }

}
