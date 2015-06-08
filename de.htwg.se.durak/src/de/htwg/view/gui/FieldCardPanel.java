package de.htwg.view.gui;

import de.htwg.controller.DurakController;
import de.htwg.model.HumanPlayer;
import de.htwg.model.Player;
import de.htwg.model.PlayingCard;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by jan-erikwaigel on 12.05.15.
 */
public class FieldCardPanel extends JPanel implements Observer{

    private static final Dimension WINNER_LABEL_DIMENSION = new Dimension(500, 200);

    private List<PlayingCard> cards;

    public FieldCardPanel(DurakController controller, List<PlayingCard> cards) {
        this.cards = cards;
        controller.addObserver(this);

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
        //TODO:
        this.removeAll();
        updateUI();
    }

    @Override
    public void update(Observable o, Object arg) {
        paintCards();
    }
}
