import com.google.inject.AbstractModule;
import de.htwg.controller.IDurakController;
import de.htwg.controller.impl.DurakController;

/**
 * Created by fafreibe on 10.06.2015.
 */
public class DurakModule extends AbstractModule {

    /**
     * this is just a dummy for sonar
     */
    @Override
    protected void configure() {
        bind(IDurakController.class).to(DurakController.class);
    }
}
