import de.htwg.controller.DurakController;
import de.htwg.view.TUI;

/**
 * Created by jawaigel on 16.04.2015.
 */
public class Durak {

    public static void main(String args[]){
        DurakController controller = new DurakController();
        TUI tui = new TUI(controller);

        tui.printTUI();

        while(!tui.iterate());
    }
}

//TODO: Tests, Sonar, Jenkins, GUI,
