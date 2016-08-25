package app.caueferreira.oneapptocatchthemall.data.network.service;

import app.caueferreira.oneapptocatchthemall.data.entity.PokemonEntity;
import app.caueferreira.oneapptocatchthemall.data.entity.PokemonResponseList;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by caueferreira on 8/18/16.
 */

public interface PokemonService {

    @GET("pokemon")
    Observable<PokemonResponseList> list();

    @GET("pokemon")
    Observable<PokemonResponseList> list(@Query("offset") int offset, @Query("limit") int limit);

    @GET("pokemon/{id}")
    Observable<PokemonEntity> get(@Path("id") int id);
}
