package util;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Fabi on 11.06.2015.
 */
public class ObservableTest {

    private boolean ping=false;
    private TestObserver testObserver;
    private Observable testObservable;

    class TestObserver implements IObserver {
        //@Override
        public void update(Event e) {
            ping=true;
        }

    }

    @Before
    public void setUp() throws Exception {
        testObserver = new TestObserver();
        testObservable = new Observable();
        testObservable.addObserver(testObserver);
    }

    @Test
    public void testNotify() {
        assertFalse(ping);
        testObservable.notifyObservers();
        assertTrue(ping);
    }

    @Test
    public void testRemove() {
        assertFalse(ping);
        testObservable.removeObserver(testObserver);
        testObservable.notifyObservers();
        assertFalse(ping);
    }

    @Test
    public void testRemoveAll() {
        assertFalse(ping);
        testObservable.removeAllObservers();
        testObservable.notifyObservers();
        assertFalse(ping);
    }

}