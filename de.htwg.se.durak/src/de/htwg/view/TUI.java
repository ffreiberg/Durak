package de.htwg.view;

import de.htwg.controller.DurakController;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

/**
 * Created by fafreibe on 10.04.2015.
 */
public class TUI implements Observer {

    private DurakController controller;
    Scanner scanner;

    public TUI(DurakController controller) {
        this.controller = controller;
        controller.addObserver(this);
        scanner = new Scanner(System.in);
    }

    public boolean iterate(){
        return handleInput(scanner.next());
    }

    private boolean handleInput(String input) {

        switch (input.toLowerCase()){
            case "q":
                return true;
            case "w":
                controller.playerMove(null);
                break;
            default:
                controller.playerMove(null);

        }
        return false;
    }

    public void printTUI(){

    }

    @Override
    public void update(Observable o, Object arg) {
        printTUI();
    }
}

/**
 * Computer: |*| |*| |*| |*|
 * 1. Zug: herz 8   herz 9
 * 2. Zug:
 * 3. Zug:
 * ...
 * Spieler: |herz 10|
 */