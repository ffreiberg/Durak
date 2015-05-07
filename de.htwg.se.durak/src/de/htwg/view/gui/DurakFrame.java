package de.htwg.view.gui;

import de.htwg.controller.DurakController;

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

    private Container pane;
    private DurakCardPanel panelComputerPlayer, panelHumanPlayer, panelField;

    private DurakController controller;

    public DurakFrame(DurakController controller) {
        this.controller = controller;
        controller.addObserver(this);

        setTitle("Durak");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(DEFAULT_X, DEFAULT_Y);
        pane = getContentPane();
        pane.setLayout(new BorderLayout());

        //Add Card Panels
        panelComputerPlayer = new DurakCardPanel();
        panelHumanPlayer = new DurakCardPanel();
        panelField = new DurakCardPanel();

        pane.add(panelComputerPlayer, BorderLayout.NORTH);
        pane.add(panelField, BorderLayout.CENTER);
        pane.add(panelHumanPlayer, BorderLayout.SOUTH);

        setVisible(true);
        repaint();
    }

    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }
}
