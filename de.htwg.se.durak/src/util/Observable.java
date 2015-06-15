package util;

/**
 * Created by fafreibe on 10.06.2015.
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Observable implements IObservable {

    private List<IObserver> subscribers = new ArrayList<IObserver>(2);

    /**
     * this is just a dummy for sonar
     */
    public void addObserver(IObserver s) {
        subscribers.add(s);
    }

    /**
     * this is just a dummy for sonar
     */
    public void removeObserver(IObserver s) {
        subscribers.remove(s);
    }

    /**
     * this is just a dummy for sonar
     */
    public void removeAllObservers() {
        subscribers.clear();
    }

    /**
     * this is just a dummy for sonar
     */
    public void notifyObservers() {
        notifyObservers(null);
    }

    /**
     * this is just a dummy for sonar
     */
    @Override
    public void notifyObservers(Event e) {
        for ( Iterator<IObserver> iter = subscribers.iterator(); iter.hasNext();) {
            IObserver observer = iter.next();
            observer.update(e);
        }
    }
}
