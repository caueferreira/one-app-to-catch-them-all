package app.caueferreira.oneapptocatchthemall.presentation.internal.module;

import javax.inject.Named;
import javax.inject.Singleton;

import app.caueferreira.oneapptocatchthemall.data.repository.Pokedex;
import app.caueferreira.oneapptocatchthemall.domain.executor.ThreadExecutor;
import app.caueferreira.oneapptocatchthemall.domain.interactor.ListPokemonCase;
import app.caueferreira.oneapptocatchthemall.domain.interactor.PokemonDetailCase;
import app.caueferreira.oneapptocatchthemall.presentation.AndroidApplication;
import dagger.Module;
import dagger.Provides;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

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

    @Provides
    @Singleton
    @Named("subscriberOn")
    ThreadExecutor provideSubscriberOnThreadExecutor() {
        return new ThreadExecutor(Schedulers.newThread());
    }

    @Provides
    @Singleton
    @Named("observerOn")
    ThreadExecutor provideObserverOnExecutionThread() {
        return new ThreadExecutor(AndroidSchedulers.mainThread());
    }

    @Provides
    @Singleton
    ListPokemonCase provideListPokemonCase(@Named("subscriberOn") final ThreadExecutor subscriberOn,
                                           @Named("observerOn") final ThreadExecutor observerOn,
                                           final Pokedex pokedex) {
        return new ListPokemonCase(subscriberOn, observerOn, pokedex);
    }

    @Provides
    @Singleton
    PokemonDetailCase providePokemonDetailCase(@Named("subscriberOn") final ThreadExecutor subscriberOn,
                                               @Named("observerOn") final ThreadExecutor observerOn,
                                               final Pokedex pokedex) {
        return new PokemonDetailCase(subscriberOn, observerOn, pokedex);
    }
}
