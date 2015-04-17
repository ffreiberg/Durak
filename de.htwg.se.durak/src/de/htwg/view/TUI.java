package de.htwg.view;

import de.htwg.controller.DurakController;
import de.htwg.model.Player;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import util.IObserver;

import java.util.LinkedList;
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
        printTUI();
    }

    public void printTUI(){
        throw new NotImplementedException();
    }
}
