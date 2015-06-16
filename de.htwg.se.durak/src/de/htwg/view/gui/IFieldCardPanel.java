package de.htwg.view.gui;

import util.*;

import javax.accessibility.Accessible;
import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.Serializable;

/**
 * Created by fafreibe on 16.06.2015.
 */
public interface IFieldCardPanel extends ImageObserver, MenuContainer, Serializable, Accessible, IObserver {

    /**
     * this is just a dummy for sonar
     */
    void disableField();

    /**
     * this is just a dummy for sonar
     */
    @Override
    void update(util.Event e);
}
