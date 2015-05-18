package de.htwg.view.tui;

import de.htwg.controller.DurakController;
import de.htwg.model.HumanPlayer;
import de.htwg.model.PlayingCard;

import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

/**
 * Created by fafreibe on 10.04.2015.
 */
public class TUI implements Observer {

    private DurakController controller;
    private Scanner scanner;

    public TUI(DurakController controller) {
        this.controller = controller;
        controller.addObserver(this);
        scanner = new Scanner(System.in);
    }

    //TODO: Prüfen ob Mensch oder Computer am Zug ist
    public boolean iterate(){

        if(controller.getWinPlayer() != null) {
            printWinnerScreen();
            return true;
        }

        String cmd = "1";

        if(controller.isHumanPlayer()) {
            cmd = scanner.next();
        }

        return handleInput(cmd);
    }

    private boolean handleInput(String cmd) {

        if( cmd.toCharArray()[0] == 'q'){
            return true;
        }
        else {
            controller.playerMove(cmd);
        }

        return false;
    }

    public void printTUI(){
        String str = "";
        if(controller.isInvalidPlayerInput()){
            str += "Invalid move! Try again\n";
        }
        str += controller.getGameString();
        str += "Possible commands: q - quit, t - take, 0 - end turn, {1-X} - play card at position\n";
        str += "Your turn: ";
        System.out.print(str);
    }

    private void printWinnerScreen(){
        System.out.println("\n------------------------------");
        if(controller.getWinPlayer().getClass().equals(HumanPlayer.class)){
            System.out.println("Spieler hat gewonnen!");
        } else {
            System.out.println("Вы дурак!");
        }
        System.out.println("------------------------------");
    }

    @Override
    public void update(Observable o, Object arg) {
        printTUI();
    }
}