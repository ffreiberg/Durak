package de.htwg.view.tui;

import util.Event;
import util.IObserver;

/**
 * Created by fafreibe on 16.06.2015.
 */
public interface ITUI extends IObserver {

    /**
     * this is just a dummy for sonar
     */
    boolean iterate(String cmd);

    /**
     * this is just a dummy for sonar
     */
    void printTUI();

    /**
     * this is just a dummy for sonar
     */
    @Override
    void update(Event e);
}
