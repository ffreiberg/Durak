package de.htwg.view;

import com.sun.org.apache.xpath.internal.functions.FuncFalse;
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

        switch (input){
            case "q":
            case "Q":
                return true;
            case "w":
            case "W":
                controller.playRound();
                break;
            default:
                controller.playRound();

        }
        return false;
    }

    public void printTUI(){
        System.out.println(controller.getPlayerRoles());
        //System.out.println(controller.getPlayersHand());
    }

    @Override
    public void update(Observable o, Object arg) {
        printTUI();
    }
}
