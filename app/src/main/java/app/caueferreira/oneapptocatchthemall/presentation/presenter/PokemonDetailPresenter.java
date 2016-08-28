package app.caueferreira.oneapptocatchthemall.presentation.presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import javax.inject.Inject;

import app.caueferreira.oneapptocatchthemall.domain.entity.Pokemon;
import app.caueferreira.oneapptocatchthemall.domain.interactor.PokemonDetailCase;
import app.caueferreira.oneapptocatchthemall.presentation.view.PokemonDetailView;
import rx.Subscriber;

/**
 * Created by caueferreira on 8/28/16.
 */

public class PokemonDetailPresenter {

    private PokemonDetailView pokemonDetailView;
    private final PokemonDetailCase pokemonDetailCase;

    @Inject
    public PokemonDetailPresenter(final PokemonDetailCase pokemonDetailCase) {
        this.pokemonDetailCase = pokemonDetailCase;
    }

    public void setView(@NonNull final PokemonDetailView pokemonDetailView) {
        this.pokemonDetailView = pokemonDetailView;
    }

    private void showLoading() {
        pokemonDetailView.showLoading();
    }

    private void hideLoading() {
        pokemonDetailView.hideLoading();
    }

    public void get(final int id) {
        this.pokemonDetailCase.get(id);
        this.pokemonDetailCase.execute(new PokemonDetailSubscriber());
    }

    private void pokemonDetail(final Pokemon pokemon) {
        this.pokemonDetailView.renderPokemon(pokemon);
    }

    private final class PokemonDetailSubscriber extends Subscriber<Pokemon> {

        @Override public void onCompleted() {
            PokemonDetailPresenter.this.hideLoading();
        }

        @Override public void onError(final Throwable e) {
            Log.e("onError", e.toString());
            PokemonDetailPresenter.this.hideLoading();
        }

        @Override public void onNext(final Pokemon pokemon) {
            PokemonDetailPresenter.this.pokemonDetail(pokemon);
        }
    }
}
