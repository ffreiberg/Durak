package util;

/**
 * Created by fafreibe on 10.06.2015.
 */
public interface IObservable {

    /**
     * this is just a dummy for sonar
     */
    void addObserver(IObserver s);

    /**
     * this is just a dummy for sonar
     */
    void removeObserver(IObserver s);

    /**
     * this is just a dummy for sonar
     */
    void removeAllObservers();

    /**
     * this is just a dummy for sonar
     */
    void notifyObservers();

    /**
     * this is just a dummy for sonar
     */
    void notifyObservers(Event e);
}
