import de.htwg.controller.DurakController;
import de.htwg.view.tui.TUI;
import de.htwg.view.gui.Frame;

/**
 * Created by jawaigel on 16.04.2015.
 */
class Durak {

    public static void main(String args[]){
        DurakController controller = new DurakController();

        Frame gui = new Frame(controller);
        TUI tui = new TUI(controller);
        tui.printTUI();

        while(!tui.iterate());

        gui.close();
    }
}

//TODO: Tests, Sonar, Jenkins, GUI,
