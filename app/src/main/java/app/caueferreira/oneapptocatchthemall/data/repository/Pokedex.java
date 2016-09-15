package app.caueferreira.oneapptocatchthemall.data.repository;

import javax.inject.Inject;
import javax.inject.Singleton;

import app.caueferreira.oneapptocatchthemall.data.mapper.PokemonEntityMapper;
import app.caueferreira.oneapptocatchthemall.data.network.api.PokemonApi;
import app.caueferreira.oneapptocatchthemall.domain.entity.Pokemon;
import rx.Observable;

/**
 * Created by caueferreira on 8/24/16.
 */

public class Pokedex {

    @Singleton
    private PokemonApi pokemonApi;
    @Singleton
    PokemonEntityMapper pokemonEntityMapper;

    @Inject
    public Pokedex() {
        pokemonApi = new PokemonApi();
        pokemonEntityMapper = new PokemonEntityMapper();
    }

    public Observable<String> list() {
        return pokemonApi.list()
                .flatMap(pokemonResponseList -> Observable.from(pokemonResponseList.getResults())
                        .flatMap(pokemonResponse -> Observable.just(pokemonResponse.getName())));
    }

    public Observable<String> list(final int offset, final int limit) {
        return pokemonApi.list(offset, limit)
                .flatMap(pokemonResponseList -> Observable.from(pokemonResponseList.getResults())
                        .flatMap(pokemonResponse -> Observable.just(pokemonResponse.getName())));
    }

    public Observable<Pokemon> get(final int id) {
        return pokemonApi.get(id)
                .flatMap(pokemonEntity -> Observable.just(pokemonEntityMapper.transform(pokemonEntity)));
    }

}