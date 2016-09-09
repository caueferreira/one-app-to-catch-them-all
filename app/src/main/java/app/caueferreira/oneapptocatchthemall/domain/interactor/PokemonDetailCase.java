package app.caueferreira.oneapptocatchthemall.domain.interactor;

import javax.inject.Inject;

import app.caueferreira.oneapptocatchthemall.data.repository.Pokedex;
import app.caueferreira.oneapptocatchthemall.domain.executor.ThreadExecutor;
import rx.Observable;

/**
 * Created by caueferreira on 8/28/16.
 */

public class PokemonDetailCase extends PokemonCase {

    private final Pokedex pokedex;

    @Inject
    public PokemonDetailCase(final ThreadExecutor subscriberOn, final ThreadExecutor observerOn, final Pokedex pokedex) {
        super(subscriberOn, observerOn);
        this.pokedex = pokedex;
    }

    public Observable get(final int id){
        return withObservable(pokedex.get(id));
    }
}