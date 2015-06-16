package de.htwg.view.tui;

import util.Event;
import util.IObserver;

/**
 * Created by fafreibe on 16.06.2015.
 */
public interface ITUI extends IObserver {
    boolean iterate(String cmd);

    void printTUI();

    @Override
    void update(Event e);
}
