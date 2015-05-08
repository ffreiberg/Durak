package de.htwg.view.gui;

import de.htwg.controller.DurakController;
import de.htwg.model.PlayingCard;
import de.htwg.model.PlayingCardColor;
import de.htwg.model.PlayingCardValue;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by jawaigel on 07.05.2015.
 */
public class DurakFrame extends JFrame implements Observer {

    private static final int DEFAULT_X = 480;
    private static final int DEFAULT_Y = 320;

    private DurakCardPanel panelComputerPlayer, panelHumanPlayer, panelField;

    private DurakController controller;

    public DurakFrame(DurakController controller) {

        this.controller = controller;
        controller.addObserver(this);

        this.setTitle("Durak");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(DEFAULT_X, DEFAULT_Y);

        //Add Card Panels
        panelComputerPlayer = new DurakCardPanel(controller.getComputerHand());
        panelHumanPlayer = new DurakCardPanel(controller.getPlayersHand());
        panelField = new DurakCardPanel(controller.getField());

        JPanel cardPanel = new JPanel(new GridLayout(3, 1, 5, 5));
        cardPanel.add(panelComputerPlayer);
        cardPanel.add(panelField);
        cardPanel.add(panelHumanPlayer);

        JPanel deckPanel = new JPanel(new GridLayout(2, 1));
        deckPanel.add(new JLabel(controller.getTrump().toString()));
        deckPanel.add(new JLabel(Integer.toString(controller.getDeckSize())));

        Container pane = this.getContentPane();
        pane.setLayout(new BorderLayout(5, 5));
        pane.add(cardPanel, BorderLayout.CENTER);
        pane.add(deckPanel, BorderLayout.LINE_START);

        this.setVisible(true);

    }

    @Override
    public void update(Observable o, Object arg) {
        panelField.paintCards();
        panelHumanPlayer.paintCards();
        panelComputerPlayer.paintCards();
        repaint();
    }
}
