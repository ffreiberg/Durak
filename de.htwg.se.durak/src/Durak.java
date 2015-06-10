import com.google.inject.Guice;
import com.google.inject.Injector;
import de.htwg.controller.IDurakController;
import de.htwg.view.tui.TUI;
import de.htwg.view.gui.Frame;

import java.util.Scanner;

/**
 * Created by jawaigel on 16.04.2015.
 */
public final class Durak {

    private Durak(){}

    public static void main(String args[]){

        Injector injector = Guice.createInjector(new DurakModule());

        Scanner scanner = new Scanner(System.in);
        IDurakController controller = injector.getInstance(IDurakController.class);
        controller.initGame();

        Frame gui = new Frame(controller);
        TUI tui = new TUI(controller);
        tui.printTUI();

        boolean continueGame = true;

        while(continueGame) {
            continueGame = !tui.iterate(scanner.next());
        }

        gui.close();
    }
}
