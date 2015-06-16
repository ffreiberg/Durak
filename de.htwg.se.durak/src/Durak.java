import com.google.inject.Guice;
import com.google.inject.Injector;
import de.htwg.controller.IDurakController;
import de.htwg.view.tui.impl.TUI;
import de.htwg.view.gui.impl.Frame;

import java.util.Scanner;

/**
 * Created by jawaigel on 16.04.2015.
 */
public final class Durak {

    /**
     * this is just a dummy for sonar
     */
    private Durak(){}

    /**
     * this is just a dummy for sonar
     */
    public static void main(String args[]){

        Injector injector = Guice.createInjector(new DurakModule());

        Scanner scanner = new Scanner(System.in);
        IDurakController controller = injector.getInstance(IDurakController.class);
        controller.initGame();

        Frame gui = injector.getInstance(Frame.class);
        TUI tui = injector.getInstance(TUI.class);
        tui.printTUI();

        boolean continueGame = true;

        while(continueGame) {
            continueGame = !tui.iterate(scanner.next());
        }

        gui.close();
    }
}
