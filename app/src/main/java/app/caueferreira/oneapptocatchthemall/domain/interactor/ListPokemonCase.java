package app.caueferreira.oneapptocatchthemall.domain.interactor;

import javax.inject.Inject;

import app.caueferreira.oneapptocatchthemall.data.repository.Pokedex;
import rx.Observable;

/**
 * Created by caueferreira on 8/26/16.
 */

public class ListPokemonCase extends PokemonCase {

    private final Pokedex pokedex;

    @Inject
    public ListPokemonCase() {
        pokedex = new Pokedex();
    }

    public Observable list(final int offset, final int limit) {
        return withObservable(pokedex.list(offset, limit));
    }
}
