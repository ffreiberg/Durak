package de.htwg.view.gui;

import de.htwg.controller.DurakController;
import de.htwg.model.PlayingCard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by jawaigel on 07.05.2015.
 */
public class PlayerCardPanel extends JPanel implements ActionListener, Observer {

    private List<PlayingCard> cards;
    private DurakController controller;

    public PlayerCardPanel(DurakController controller, List<PlayingCard> cards) {
        this.controller = controller;
        this.cards = cards;
        this.controller.addObserver(this);
        this.setLayout(new FlowLayout(FlowLayout.LEFT));

        paintCards();
    }

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

    public void disableField() {
        for(Component c: this.getComponents()) {
            c.setEnabled(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        PlayingCardButton btn = (PlayingCardButton) e.getSource();
        controller.playerMove(Integer.toString(btn.getPosition()));
    }

    @Override
    public void update(Observable o, Object arg) {
        if(controller.getWinPlayer() == null ) {
            paintCards();
        }
    }
}
