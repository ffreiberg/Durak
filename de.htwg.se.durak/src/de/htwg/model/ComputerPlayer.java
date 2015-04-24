package de.htwg.model;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import java.util.Random;

/**
 * Created by jan-erikwaigel on 16.04.15.
 */
public class ComputerPlayer extends Player {

    /**
     * The Names.
     */
    public String names[] = {"Elif", "Esac", "Julio", "Jamtonio", "LaDasha", "Schlomo", "Micha", "Walpurga", "Ralle",
            "Karma", "Vladi", "Mustafa", "Yildirim", "Lothar", "Roland", "CR7", "Mausi96", "Allah"};

    /**
     * Instantiates a new Computer player.
     */
    public ComputerPlayer(){
        playerName = "BOT " + names[new Random().nextInt(names.length - 1)];
    }

    /**
     * Play card.
     *
     * @return the playing card [ ]
     */
    @Override
    public PlayingCard[] playCard() {
        throw new NotImplementedException();
    }
}
