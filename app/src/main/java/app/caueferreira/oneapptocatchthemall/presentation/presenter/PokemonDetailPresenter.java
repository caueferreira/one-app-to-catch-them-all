package app.caueferreira.oneapptocatchthemall.presentation.presenter;

import android.support.annotation.NonNull;

import javax.inject.Inject;

import app.caueferreira.oneapptocatchthemall.domain.entity.Pokemon;
import app.caueferreira.oneapptocatchthemall.domain.interactor.PokemonDetailCase;
import app.caueferreira.oneapptocatchthemall.presentation.mapper.PokemonModelMapper;
import app.caueferreira.oneapptocatchthemall.presentation.model.PokemonModel;
import app.caueferreira.oneapptocatchthemall.presentation.view.PokemonDetailView;
import rx.Subscriber;

/**
 * Created by caueferreira on 8/28/16.
 */

public class PokemonDetailPresenter {

    private PokemonDetailView pokemonDetailView;
    private PokemonModelMapper pokemonModelMapper;
    private final PokemonDetailCase pokemonDetailCase;

    @Inject
    public PokemonDetailPresenter(final PokemonDetailCase pokemonDetailCase) {
        this.pokemonDetailCase = pokemonDetailCase;
        this.pokemonModelMapper = new PokemonModelMapper();
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

    private void pokemonDetail(final PokemonModel pokemonModel) {
        this.pokemonDetailView.renderPokemon(pokemonModel);
    }

    private final class PokemonDetailSubscriber extends Subscriber<Pokemon> {

        @Override public void onCompleted() {
            PokemonDetailPresenter.this.hideLoading();
        }

        @Override public void onError(final Throwable e) {
            PokemonDetailPresenter.this.hideLoading();
        }

        @Override public void onNext(final Pokemon pokemon) {
            PokemonDetailPresenter.this.pokemonDetail(pokemonModelMapper.transform(pokemon));
        }
    }
}
