package de.htwg.model;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import java.util.Random;

/**
 * Created by jan-erikwaigel on 16.04.15.
 */
public class ComputerPlayer extends Player {

    public String names[] = {"Elif", "Esac", "Julio", "Jamtonio", "LaDasha", "Schlomo", "Micha", "Walpurga", "Ralle",
            "Karma", "Vladi", "Mustafa", "Yildirim", "Lothar", "Roland", "CR7", "Mausi96", "Allah"};

    public ComputerPlayer(){
        playerName = "BOT " + names[new Random().nextInt(names.length - 1)];
    }
    @Override
    public PlayingCard[] playCard() {
        throw new NotImplementedException();
    }
}
