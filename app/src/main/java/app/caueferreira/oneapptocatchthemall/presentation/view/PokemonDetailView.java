package app.caueferreira.oneapptocatchthemall.presentation.view;

import app.caueferreira.oneapptocatchthemall.domain.entity.Pokemon;

/**
 * Created by caueferreira on 8/28/16.
 */

public interface PokemonDetailView extends BaseView{

    void renderPokemon(final Pokemon pokemon);
}
