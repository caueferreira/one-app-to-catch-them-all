package app.caueferreira.oneapptocatchthemall;

import javax.inject.Singleton;

import app.caueferreira.oneapptocatchthemall.data.repository.Pokedex;
import dagger.Module;
import dagger.Provides;

/**
 * Created by caueferreira on 8/24/16.
 */

@Module
public class ApplicationModule {

    private final AndroidApplication mApplication;

    public ApplicationModule(AndroidApplication application) {
        this.mApplication = application;
    }

    @Provides
    @Singleton
    Pokedex providePokedex() {
        return new Pokedex();
    }
}
