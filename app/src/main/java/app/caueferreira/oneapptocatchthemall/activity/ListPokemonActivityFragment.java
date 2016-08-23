package app.caueferreira.oneapptocatchthemall.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import app.caueferreira.oneapptocatchthemall.R;
import app.caueferreira.oneapptocatchthemall.api.PokemonApiService;
import app.caueferreira.oneapptocatchthemall.api.PokemonResponse;
import app.caueferreira.oneapptocatchthemall.api.PokemonResponseList;
import app.caueferreira.oneapptocatchthemall.view.EndlessRecyclerOnScrollListener;
import app.caueferreira.oneapptocatchthemall.view.PokemonAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A placeholder fragment containing a simple view.
 */
public class ListPokemonActivityFragment extends Fragment {

    public ListPokemonActivityFragment() {
    }

    private RecyclerView mRecyclerView;
    private PokemonAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Retrofit mRetrofit;
    private PokemonApiService mPokemonApi;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_pokemon, container, false);


        mRecyclerView = (RecyclerView) view.findViewById(R.id.pokemon_list);

        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new PokemonAdapter(getActivity());
        mRecyclerView.setAdapter(mAdapter);

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();

        mRetrofit = new Retrofit.Builder()
                .baseUrl("http://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        mPokemonApi = mRetrofit.create(PokemonApiService.class);

        mPokemonApi.list().enqueue(new Callback<PokemonResponseList>() {
            @Override
            public void onResponse(Call<PokemonResponseList> call, Response<PokemonResponseList> response) {
                Log.i("onResponse",response.body().getResults().toString());
                updateList(response.body().getResults());
            }

            @Override
            public void onFailure(Call<PokemonResponseList> call, Throwable t) {
                Log.e("onFailure",t.toString());
            }
        });




        mRecyclerView.addOnScrollListener(new EndlessRecyclerOnScrollListener((LinearLayoutManager) mLayoutManager) {
            @Override
            public void onLoadMore(int page) {
                mPokemonApi.list(page*10,10).enqueue(new Callback<PokemonResponseList>() {
                    @Override
                    public void onResponse(Call<PokemonResponseList> call, Response<PokemonResponseList> response) {
                        Log.i("call", call.request().toString());
                        updateList(response.body().getResults());
                    }

                    @Override
                    public void onFailure(Call<PokemonResponseList> call, Throwable t) {
                        Log.e("error", ""+call.request().body());
                    }
                });
            }
        });



        return view;
    }

    public void updateList(final List<PokemonResponse> list) {
        mAdapter.addAll(list, getActivity());
        mRecyclerView.getAdapter().notifyDataSetChanged();
    }
}
