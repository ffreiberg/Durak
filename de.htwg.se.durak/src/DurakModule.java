import com.google.inject.AbstractModule;
import de.htwg.controller.IDurakController;

/**
 * Created by fafreibe on 10.06.2015.
 */
public class DurakModule extends AbstractModule {

    //
    @Override
    protected void configure() {
        bind(IDurakController.class).to(de.htwg.controller.DurakController.class);
    }
}
