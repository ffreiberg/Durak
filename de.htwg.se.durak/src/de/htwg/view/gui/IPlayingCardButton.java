package de.htwg.view.gui;

import javax.accessibility.Accessible;
import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.Serializable;

/**
 * Created by fafreibe on 16.06.2015.
 */
public interface IPlayingCardButton extends ImageObserver, MenuContainer, Serializable, ItemSelectable, SwingConstants, Accessible {

    /**
     * this is just a dummy for sonar
     */
    int getPosition();
}
