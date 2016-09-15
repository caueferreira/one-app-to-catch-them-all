package app.caueferreira.oneapptocatchthemall.presentation.internal.component;

import javax.inject.Singleton;

import app.caueferreira.oneapptocatchthemall.presentation.internal.module.ApplicationModule;
import app.caueferreira.oneapptocatchthemall.presentation.view.fragment.ListPokemonActivityFragment;
import app.caueferreira.oneapptocatchthemall.presentation.view.fragment.PokemonDetailActivityFragment;
import app.caueferreira.oneapptocatchthemall.data.repository.Pokedex;
import app.caueferreira.oneapptocatchthemall.domain.interactor.ListPokemonCase;
import app.caueferreira.oneapptocatchthemall.domain.interactor.PokemonDetailCase;
import dagger.Component;

/**
 * Created by caueferreira on 8/24/16.
 */

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {
    void inject(ListPokemonActivityFragment listPokemonActivityFragment);
    void inject(PokemonDetailActivityFragment pokemonDetailActivityFragment);

    Pokedex providePokedex();
    ListPokemonCase provideListPokemonCase();
    PokemonDetailCase providePokemonDetailCase();
}
