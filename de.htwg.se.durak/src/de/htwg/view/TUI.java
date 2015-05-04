package de.htwg.view;

import de.htwg.controller.DurakCommands;
import de.htwg.controller.DurakController;

import java.util.Objects;
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

    //TODO: Prüfen ob Mensch oder Computer am Zug ist
    public boolean iterate(){
        int cardIndex = 0;
        String cmd;

        System.out.print("Kommando: ");
        cmd = scanner.next();

        if( !cmd.toLowerCase().equals("t") )
        {
            System.out.print("\nKarte: ");
            cardIndex = scanner.nextInt();
        }

        return handleInput(cmd, cardIndex);
    }

    private boolean handleInput(String cmd, int cardIndex) {

        switch (cmd.toLowerCase()){
            case "q":
                return true;
            case "a":
                controller.playerMove(DurakCommands.ATTACK, cardIndex);
                break;
            case "b":
                controller.playerMove(DurakCommands.BEAT, cardIndex);
                break;
            case "t":
                controller.playerMove(DurakCommands.TAKE, cardIndex);
                break;
            default:
                controller.playerMove(null, cardIndex);

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