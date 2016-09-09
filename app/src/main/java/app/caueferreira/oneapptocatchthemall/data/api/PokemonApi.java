package app.caueferreira.oneapptocatchthemall.data.api;

import app.caueferreira.oneapptocatchthemall.domain.entity.Pokemon;
import retrofit2.Call;

/**
 * Created by caueferreira on 9/5/16.
 */

public class PokemonApi extends BaseApi{


    private PokemonService pokemonService;


    public PokemonApi(){
        this.pokemonService = build().create(PokemonService.class);
    }


    public Call<PokemonResponseList> list(){
        return pokemonService.list();
    }

    public Call<PokemonResponseList> list(final int offset, final int limit){
        return pokemonService.list(offset, limit);
    }


    public Call<Pokemon> get(final int id){
        return pokemonService.get(id);
    }
}
