package de.htwg.view.gui;

import de.htwg.controller.DurakController;
import de.htwg.model.HumanPlayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by jawaigel on 07.05.2015.
 */
public class Frame extends JFrame implements ActionListener, Observer{

    private static final int DEFAULT_X = 800;
    private static final int DEFAULT_Y = 420;

    private PlayerCardPanel panelComputerPlayer, panelHumanPlayer;
    //private FieldCardPanel panelField;
    private JPanel panelField;
    private JButton playerTakeBtn, playerSkipBtn, trumpBtn, deckBtn;

    private DurakController controller;

    public Frame(DurakController controller) {

        this.controller = controller;

        this.setTitle("Durak");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(DEFAULT_X, DEFAULT_Y);

        //Add Card Panels
        panelComputerPlayer = new PlayerCardPanel(controller, controller.getComputerHand());
        panelHumanPlayer = new PlayerCardPanel(controller, controller.getPlayersHand());
        panelField = new FieldCardPanel(controller, controller.getField());

        this.controller.addObserver(this);

        playerTakeBtn = new JButton("take");
        playerTakeBtn.addActionListener(this);

        playerSkipBtn = new JButton("skip");
        playerSkipBtn.addActionListener(this);

        trumpBtn = new JButton(controller.getTrump().toString());
        trumpBtn.setPreferredSize(new Dimension(50, 80));
        deckBtn = new JButton(Integer.toString(controller.getDeckSize()));
        deckBtn.setPreferredSize(new Dimension(50, 80));

        JPanel cardPanel = new JPanel(new GridLayout(3, 1, 5, 5));
        cardPanel.add(panelComputerPlayer);
        cardPanel.add(panelField);
        cardPanel.add(panelHumanPlayer);

        JPanel deckPanel = new JPanel(new GridLayout(2, 1));
        deckPanel.add(trumpBtn);
        deckPanel.add(deckBtn);

        Container pane = this.getContentPane();
        pane.setLayout(new BorderLayout(5, 5));
        pane.add(deckPanel, BorderLayout.LINE_START);
        pane.add(cardPanel, BorderLayout.CENTER);

        JPanel actionPanel = new JPanel(new GridLayout(2, 1));
        actionPanel.add(playerTakeBtn);
        actionPanel.add(playerSkipBtn);
        pane.add(actionPanel, BorderLayout.EAST);

        this.setVisible(true);
    }

    private void paintWinnerScreen() {
        panelField = new JPanel();
        JTextField txtField = new JTextField();
        txtField.setMinimumSize(new Dimension(DEFAULT_X-20, 100));

        if(controller.getWinPlayer() instanceof HumanPlayer){
            txtField.setText("Spieler hat gewonnen!");
        } else {
            txtField.setText("Computer hat gewonnen!");
        }
    }

    public void close() {
        this.setVisible(false);
        this.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(playerTakeBtn)) {
            controller.playerMove("t");
        } else if (e.getSource().equals(playerSkipBtn)) {
            controller.playerMove("0");
        }

    }

    @Override
    public void update(Observable o, Object arg) {
        /*if(!controller.isHumanPlayer()) {
            controller.playerMove("1");
        }*/
        if(controller.getWinPlayer() != null) {
            paintWinnerScreen();
            return;
        }

        deckBtn.setText(Integer.toString(controller.getDeckSize()));
    }

}
