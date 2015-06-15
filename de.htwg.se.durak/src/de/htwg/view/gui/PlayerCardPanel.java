package de.htwg.view.gui;


import de.htwg.controller.IDurakController;
import de.htwg.model.PlayingCard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import util.IObserver;
import util.Event;

/**
 * Created by jawaigel on 07.05.2015.
 */
public class PlayerCardPanel extends JPanel implements ActionListener, IObserver {

    private List<PlayingCard> cards;
    private IDurakController controller;

    /**
     * this is just a dummy for sonar
     */
    public PlayerCardPanel(IDurakController controller, List<PlayingCard> cards) {
        this.controller = controller;
        this.cards = cards;
        this.controller.addObserver(this);
        this.setLayout(new FlowLayout(FlowLayout.LEFT));

        paintCards();
    }

    /**
     * this is just a dummy for sonar
     */
    private void paintCards() {
        this.removeAll();

        int i=1;
        for(PlayingCard card: cards){
            PlayingCardButton btn = new PlayingCardButton(card, i++);
            btn.addActionListener(this);
            this.add(btn);
        }
        updateUI();
    }

    /**
     * this is just a dummy for sonar
     */
    public void disableField() {
        for(Component c: this.getComponents()) {
            c.setEnabled(false);
        }
    }

    /**
     * this is just a dummy for sonar
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        PlayingCardButton btn = (PlayingCardButton) e.getSource();
        controller.playerMove(Integer.toString(btn.getPosition()));
    }

    /**
     * this is just a dummy for sonar
     */
    @Override
    public void update(Event e) {
        if(controller.getWinPlayer() == null ) {
            paintCards();
        }
    }
}
