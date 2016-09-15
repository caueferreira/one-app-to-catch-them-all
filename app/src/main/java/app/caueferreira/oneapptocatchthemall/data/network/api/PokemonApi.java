package app.caueferreira.oneapptocatchthemall.data.network.api;

import javax.inject.Inject;
import javax.inject.Singleton;

import app.caueferreira.oneapptocatchthemall.data.entity.PokemonEntity;
import app.caueferreira.oneapptocatchthemall.data.entity.PokemonResponseList;
import app.caueferreira.oneapptocatchthemall.data.network.service.PokemonService;
import rx.Observable;

/**
 * Created by caueferreira on 8/24/16.
 */

public class PokemonApi extends BaseApi {

    @Singleton
    private PokemonService pokemonService;

    @Inject
    public PokemonApi() {
        pokemonService = build().create(PokemonService.class);
    }

    public Observable<PokemonResponseList> list() {
        return pokemonService.list();
    }

    public Observable<PokemonResponseList> list(final int offset, final int limit) {
        return pokemonService.list(offset, limit);
    }

    public Observable<PokemonEntity> get(final int id){
        return pokemonService.get(id);
    }
}
