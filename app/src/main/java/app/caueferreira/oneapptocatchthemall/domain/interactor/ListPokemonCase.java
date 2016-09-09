package app.caueferreira.oneapptocatchthemall.domain.interactor;

import javax.inject.Inject;

import app.caueferreira.oneapptocatchthemall.data.repository.Pokedex;
import app.caueferreira.oneapptocatchthemall.domain.executor.ThreadExecutor;
import rx.Observable;

/**
 * Created by caueferreira on 8/26/16.
 */

public class ListPokemonCase extends PokemonCase {

    private final Pokedex pokedex;

    @Inject
    public ListPokemonCase(final ThreadExecutor subscriberOn, final ThreadExecutor observerOn, final Pokedex pokedex) {
        super(subscriberOn, observerOn);
        this.pokedex = pokedex;
    }

    public Observable list(final int offset, final int limit) {
        return withObservable(pokedex.list(offset, limit));
    }
}
