package app.caueferreira.oneapptocatchthemall.domain.interactor;

import javax.inject.Inject;

import app.caueferreira.oneapptocatchthemall.data.repository.Pokedex;
import rx.Observable;

/**
 * Created by caueferreira on 8/28/16.
 */

public class PokemonDetailCase extends PokemonCase {

    private final Pokedex pokedex;

    @Inject
    public PokemonDetailCase(){
        pokedex = new Pokedex();
    }

    public Observable get(final int id){
        return withObservable(pokedex.get(id));
    }
}