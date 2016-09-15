package app.caueferreira.oneapptocatchthemall.presentation.presenter;

import android.support.annotation.NonNull;

import javax.inject.Inject;

import app.caueferreira.oneapptocatchthemall.domain.interactor.ListPokemonCase;
import app.caueferreira.oneapptocatchthemall.presentation.model.request.PokemonListRequest;
import app.caueferreira.oneapptocatchthemall.presentation.model.response.PokemonNameResponse;
import app.caueferreira.oneapptocatchthemall.presentation.view.ListPokemonView;
import rx.Subscriber;

/**
 * Created by caueferreira on 8/26/16.
 */

public class ListPokemonPresenter {

    private ListPokemonView listPokemonView;
    private final ListPokemonCase listPokemonCase;

    @Inject
    public ListPokemonPresenter(final ListPokemonCase listPokemonCase) {
        this.listPokemonCase = listPokemonCase;
    }

    public void setView(@NonNull final ListPokemonView listPokemonView) {
        this.listPokemonView = listPokemonView;
    }

    private void showLoading() {
        listPokemonView.showLoading();
    }

    private void hideLoading() {
        listPokemonView.hideLoading();
    }

    public void list(final PokemonListRequest pokemonListRequest) {
        this.listPokemonCase.list(pokemonListRequest.getOffset(), pokemonListRequest.getLimit());
        this.listPokemonCase.execute(new PokemonListSubscriber());
    }

    private void addPokemon(final String pokemonName) {
        this.listPokemonView.renderPokemon(PokemonNameResponse.create().withName(pokemonName));
    }

    private void listPokemon(){
        this.listPokemonView.renderPokemonList();
    }

    private final class PokemonListSubscriber extends Subscriber<String> {

        @Override public void onCompleted() {
            ListPokemonPresenter.this.hideLoading();
            ListPokemonPresenter.this.listPokemon();
        }

        @Override public void onError(final Throwable e) {
            ListPokemonPresenter.this.hideLoading();
        }

        @Override public void onNext(final String pokemonName) {
            ListPokemonPresenter.this.addPokemon(pokemonName);
        }
    }
}
