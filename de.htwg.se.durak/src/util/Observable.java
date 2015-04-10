package util;

import java.util.Vector;

/**
 * Created by jawaigel on 10.04.2015.
 */
public class Observable {

    protected Vector<IObserver> subscribers = new Vector<>(2);

    public void addObserver(IObserver s) {
        subscribers.addElement(s);
    }

    public void removeObserver(IObserver s) {
        subscribers.removeElement(s);
    }

    public void removeAllObservers() {
        subscribers.removeAllElements();
    }

    public void notifyObservers() {
        for( IObserver iObserver: subscribers){
            iObserver.update();
        }
    }
}
