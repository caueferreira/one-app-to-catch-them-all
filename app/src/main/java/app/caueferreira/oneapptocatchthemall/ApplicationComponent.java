package app.caueferreira.oneapptocatchthemall;

import javax.inject.Singleton;

import app.caueferreira.oneapptocatchthemall.data.repository.Pokedex;
import dagger.Component;

/**
 * Created by caueferreira on 8/24/16.
 */

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    Pokedex providePokedex();
}
