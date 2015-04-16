import de.htwg.controller.DurakController;
import de.htwg.model.Deck;
import de.htwg.view.TUI;

/**
 * Created by jawaigel on 16.04.2015.
 */
public class Durak {

    public static void main(String args[]){
        DurakController controller = new DurakController(2);
        TUI tui = new TUI(controller);

        Deck deck = new Deck();

        System.out.println(deck.toString());
    }
}
