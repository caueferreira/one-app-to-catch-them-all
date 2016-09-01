package app.caueferreira.oneapptocatchthemall.presentation.view;

import app.caueferreira.oneapptocatchthemall.presentation.model.response.PokemonResponse;

/**
 * Created by caueferreira on 8/28/16.
 */

public interface PokemonDetailView extends BaseView{

    void renderPokemon(final PokemonResponse pokemonResponse);
}
