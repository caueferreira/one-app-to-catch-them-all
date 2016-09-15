package app.caueferreira.oneapptocatchthemall.presentation.view;

import app.caueferreira.oneapptocatchthemall.presentation.model.response.PokemonNameResponse;

/**
 * Created by caueferreira on 8/26/16.
 */

public interface ListPokemonView extends BaseView{

    void renderPokemonList();
    void renderPokemon(final PokemonNameResponse pokemonNameResponse);
}
