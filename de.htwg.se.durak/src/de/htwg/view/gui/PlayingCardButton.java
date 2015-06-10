package de.htwg.view.gui;

import de.htwg.model.PlayingCard;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by jawaigel on 07.05.2015.
 */
public class PlayingCardButton extends JButton{

    private static final Dimension CARD_SIZE_DIMENSION = new Dimension(60, 100);
    private static final int WIDTH = 60;
    private static final int HEIGHT = 100;

    private int position;

    public PlayingCardButton(PlayingCard card, int position) {

        if(card.getHide()) {
            try {
                Image img = ImageIO.read(new File("cards/back.png"));
                super.setIcon(new ImageIcon(img.getScaledInstance(WIDTH, HEIGHT, Image.SCALE_SMOOTH)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                Image img = ImageIO.read(new File("cards/" + card.toString() + ".png"));
                super.setIcon(new ImageIcon(img.getScaledInstance(WIDTH, HEIGHT, Image.SCALE_SMOOTH)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        this.setPreferredSize(CARD_SIZE_DIMENSION);
        this.setVerticalAlignment(CENTER);

        this.position = position;
    }

    public int getPosition() {
        return this.position;
    }
}
