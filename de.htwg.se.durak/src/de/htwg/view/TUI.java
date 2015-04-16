package de.htwg.view;

import de.htwg.controller.DurakController;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import util.IObserver;

import java.util.Scanner;

/**
 * Created by fafreibe on 10.04.2015.
 */
public class TUI implements IObserver {

    private DurakController controller;
    Scanner scanner;

    public TUI(DurakController controller) {
        this.controller = controller;
        controller.addObserver(this);
        scanner = new Scanner(System.in);
    }

    @Override
    public void update() {
        throw new NotImplementedException();
    }
}
