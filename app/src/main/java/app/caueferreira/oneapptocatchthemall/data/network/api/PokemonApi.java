package app.caueferreira.oneapptocatchthemall.data.network.api;

import app.caueferreira.oneapptocatchthemall.data.entity.PokemonResponseList;
import app.caueferreira.oneapptocatchthemall.data.network.service.PokemonService;
import app.caueferreira.oneapptocatchthemall.entity.Pokemon;
import retrofit2.Call;

/**
 * Created by caueferreira on 8/24/16.
 */

public class PokemonApi extends BaseApi {

    private PokemonService pokemonService;

    public PokemonApi() {
        pokemonService = build().create(PokemonService.class);
    }

    public Call<PokemonResponseList> list() {
        return pokemonService.list();
    }

    public Call<PokemonResponseList> list(final int offset, final int limit) {
        return pokemonService.list(offset, limit);
    }

    public Call<Pokemon> get(final int id){
        return pokemonService.get(id);
    }
}
