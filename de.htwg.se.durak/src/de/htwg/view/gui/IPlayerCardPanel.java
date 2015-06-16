package de.htwg.view.gui;

import util.*;

import javax.accessibility.Accessible;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.io.Serializable;

/**
 * Created by fafreibe on 16.06.2015.
 */
public interface IPlayerCardPanel extends ImageObserver, MenuContainer, Serializable, Accessible, ActionListener, IObserver {

    /**
     * this is just a dummy for sonar
     */
    void disableField();

    /**
     * this is just a dummy for sonar
     */
    @Override
    void actionPerformed(ActionEvent e);

    /**
     * this is just a dummy for sonar
     */
    @Override
    void update(util.Event e);
}
