package de.htwg.view.tui;

import com.google.inject.Inject;
import de.htwg.controller.IDurakController;
import de.htwg.model.HumanPlayer;

import util.Event;
import util.IObserver;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



/**
 * Created by fafreibe on 10.04.2015.
 */
public class TUI implements IObserver {

    private IDurakController controller;
    private static Logger logger = LogManager.getLogger(TUI.class.getName());

    /**
     * this is just a dummy for sonar
     */
    @Inject
    public TUI(IDurakController controller) {
        this.controller = controller;
        controller.addObserver(this);
    }

    /**
     * this is just a dummy for sonar
     */
    public boolean iterate(String cmd){

        if(controller.getWinPlayer() != null) {
            printWinnerScreen();
            return true;
        }

        if(controller.isHumanPlayer()) {
            return handleInput(cmd);
        }
        return false;
    }

    /**
     * this is just a dummy for sonar
     */
    private boolean handleInput(String cmd) {

        if( cmd.toCharArray()[0] == 'q'){
            return true;
        }
        else {
            controller.playerMove(cmd);
        }

        return false;
    }

    /**
     * this is just a dummy for sonar
     */
    public void printTUI(){
        if(controller.getWinPlayer() != null) {
            printWinnerScreen();
            return;
        }

        String str = "";
        if(controller.isInvalidPlayerInput()){
            str += "Invalid move! Try again\n";
        }
        str += controller.getStatus();
        str += "Possible commands: q - quit, t - take, 0 - end turn, {1-X} - play card at position\n";
        str += "Your turn: ";
        logger.info(str);
    }

    /**
     * this is just a dummy for sonar
     */
    private void printWinnerScreen(){
        String str = "";
        str += "\n\n\n\n\n";
        if(controller.getWinPlayer().getClass().equals(HumanPlayer.class)){
            str += "\t\t\t\t\tYou win!\t\t\t\t\t\n";
        } else {
            str += "\t\t\t\t\tВы дурак!\t\t\t\t\t\n";
        }
        str +=  "\n\n\n\n\n";
        logger.info(str);
    }

    /**
     * this is just a dummy for sonar
     */
    @Override
    public void update(Event e) {
        printTUI();
    }
}