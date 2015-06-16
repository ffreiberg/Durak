package de.htwg.view.gui.impl;

import de.htwg.model.impl.PlayingCard;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import de.htwg.view.gui.IPlayingCardButton;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by jawaigel on 07.05.2015.
 */
public class PlayingCardButton extends JButton implements IPlayingCardButton {

    private static final Dimension CARD_SIZE_DIMENSION = new Dimension(60, 100);
    private static Logger logger = LogManager.getLogger(PlayingCardButton.class.getName());
    private static final int WIDTH = 60;
    private static final int HEIGHT = 100;

    private int position;

    /**
     * this is just a dummy for sonar
     */
    public PlayingCardButton(PlayingCard card, int position) {

        if(card.getHide()) {
            try {
                Image img = ImageIO.read(new File("cards/back.png"));
                super.setIcon(new ImageIcon(img.getScaledInstance(WIDTH, HEIGHT, Image.SCALE_SMOOTH)));
            } catch (IOException e) {
                logger.debug("Unable to load cards/back.png");
            }
        } else {
            try {
                Image img = ImageIO.read(new File("cards/" + card.toString() + ".png"));
                super.setIcon(new ImageIcon(img.getScaledInstance(WIDTH, HEIGHT, Image.SCALE_SMOOTH)));
            } catch (IOException e) {
                logger.debug("Unable to load cards/" + card.toString() + ".png");
            }
        }

        this.setPreferredSize(CARD_SIZE_DIMENSION);
        this.setVerticalAlignment(CENTER);

        this.position = position;
    }

    /**
     * this is just a dummy for sonar
     */
    @Override
    public int getPosition() {
        return this.position;
    }
}
