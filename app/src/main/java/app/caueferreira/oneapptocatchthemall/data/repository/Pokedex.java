package app.caueferreira.oneapptocatchthemall.data.repository;

import javax.inject.Inject;
import javax.inject.Singleton;

import app.caueferreira.oneapptocatchthemall.data.entity.PokemonResponseList;
import app.caueferreira.oneapptocatchthemall.data.network.api.PokemonApi;
import app.caueferreira.oneapptocatchthemall.entity.Pokemon;
import rx.Observable;

/**
 * Created by caueferreira on 8/24/16.
 */

public class Pokedex {

    @Singleton
    private PokemonApi pokemonApi;

    @Inject
    public Pokedex(){
        pokemonApi = new PokemonApi();
    }

    public Observable<PokemonResponseList> list(){
        return pokemonApi.list();
    }

    public Observable<PokemonResponseList> list(final int offset, final int limit){
        return pokemonApi.list(offset, limit);
    }

    public Observable<Pokemon> get(final int id){
        return pokemonApi.get(id);
    }

}