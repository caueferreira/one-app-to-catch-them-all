package app.caueferreira.oneapptocatchthemall;

import javax.inject.Singleton;

import app.caueferreira.oneapptocatchthemall.activity.ListPokemonActivityFragment;
import app.caueferreira.oneapptocatchthemall.activity.PokemonDetailActivityFragment;
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
