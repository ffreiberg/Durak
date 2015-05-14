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
            System.out.print("Zug Spieler -> Kommando: ");
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
        if(controller.isInvalidPlayerInput()){
            System.out.println("Invalid move! Try again");
        }

        System.out.println("Дурак!\n");
        System.out.println("Trumpf " + controller.getTrump().toString() + "\t Cards in Deck: [" + controller.getDeckSize() + "]" );
        System.out.println("------------------------------");

        System.out.print("Computer\t");
        for(int i=1; i<=controller.getComputerHand().size(); ++i)
            System.out.print("[$]\t");

        System.out.println("\n------------------------------");
        System.out.print("Feld\t\t");
        for(PlayingCard fieldCard: controller.getField())
            System.out.print(fieldCard.toString() + "\t");

        System.out.println("\n------------------------------");
        System.out.print("\t\t\t");

        for(int i=1; i<=controller.getPlayersHand().size(); ++i)
            System.out.print("[" + i + "]\t");

        System.out.print("\nSpieler\t\t");
        for(PlayingCard attackerCard: controller.getPlayersHand())
            System.out.print(attackerCard.toString() + "\t");
        System.out.println("\n------------------------------");
        System.out.println();
    }

    private void printWinnerScreen(){
        System.out.println("\n------------------------------");
        if(controller.getWinPlayer().getClass().equals(HumanPlayer.class)){
            System.out.println("Spieler hat gewonnen!");
        } else {
            System.out.println("Computer hat gewonnen!");
        }
        System.out.println("------------------------------");
    }

    @Override
    public void update(Observable o, Object arg) {
        printTUI();
    }
}