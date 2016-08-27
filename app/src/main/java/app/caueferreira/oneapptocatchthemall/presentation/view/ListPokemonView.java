package app.caueferreira.oneapptocatchthemall.presentation.view;

/**
 * Created by caueferreira on 8/26/16.
 */

public interface ListPokemonView {

    void renderPokemonList();
    void renderPokemon(final String pokemonName);
    void showLoading();
    void hideLoading();
}
