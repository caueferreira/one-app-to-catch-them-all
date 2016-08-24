package app.caueferreira.oneapptocatchthemall.data.network.service;

import app.caueferreira.oneapptocatchthemall.data.entity.PokemonResponseList;
import app.caueferreira.oneapptocatchthemall.entity.Pokemon;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by caueferreira on 8/18/16.
 */

public interface PokemonService {

    @GET("pokemon")
    Call<PokemonResponseList> list();

    @GET("pokemon")
    Call<PokemonResponseList> list(@Query("offset") int offset, @Query("limit") int limit);

    @GET("pokemon/{id}")
    Call<Pokemon> get(@Path("id") int id);
}
