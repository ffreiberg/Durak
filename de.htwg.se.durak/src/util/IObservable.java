package util;

/**
 * Created by fafreibe on 10.06.2015.
 */
public interface IObservable {

    void addObserver(IObserver s);
    void removeObserver(IObserver s);
    void removeAllObservers();
    void notifyObservers();
    void notifyObservers(Event e);
}
