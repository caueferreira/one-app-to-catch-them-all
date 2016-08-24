package app.caueferreira.oneapptocatchthemall.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import app.caueferreira.oneapptocatchthemall.R;
import app.caueferreira.oneapptocatchthemall.data.entity.PokemonResponse;
import app.caueferreira.oneapptocatchthemall.data.entity.PokemonResponseList;
import app.caueferreira.oneapptocatchthemall.data.network.api.PokemonApi;
import app.caueferreira.oneapptocatchthemall.view.EndlessRecyclerOnScrollListener;
import app.caueferreira.oneapptocatchthemall.view.PokemonAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A placeholder fragment containing a simple view.
 */
public class ListPokemonActivityFragment extends Fragment {

    public ListPokemonActivityFragment() {
    }

    private RecyclerView mRecyclerView;
    private PokemonAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private PokemonApi mPokemonApi;

    private ProgressDialog mProgress;

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

        mPokemonApi = new PokemonApi();

        showLoading(true);

        mPokemonApi.list().enqueue(new Callback<PokemonResponseList>() {
            @Override
            public void onResponse(Call<PokemonResponseList> call, Response<PokemonResponseList> response) {
                Log.i("onResponse",response.body().getResults().toString());
                updateList(response.body().getResults());

                showLoading(false);
            }

            @Override
            public void onFailure(Call<PokemonResponseList> call, Throwable t) {
                Log.e("onFailure",t.toString());

                showLoading(false);
            }
        });

        mRecyclerView.addOnScrollListener(new EndlessRecyclerOnScrollListener((LinearLayoutManager) mLayoutManager) {
            @Override
            public void onLoadMore(int page) {
                mPokemonApi.list(page*10,10).enqueue(new Callback<PokemonResponseList>() {
                    @Override
                    public void onResponse(Call<PokemonResponseList> call, Response<PokemonResponseList> response) {
                        Log.i("onResponse", call.request().toString());
                        updateList(response.body().getResults());
                    }

                    @Override
                    public void onFailure(Call<PokemonResponseList> call, Throwable t) {
                        Log.e("onFailure", ""+call.request().body());
                    }
                });
            }
        });



        return view;
    }

    private void showLoading(final boolean toggle) {
        if (toggle) {
            mProgress = new ProgressDialog(getActivity());
            mProgress.setTitle("Loading");
            mProgress.setMessage("Retrieving pokemon list...");
            mProgress.show();
        } else {
            mProgress.dismiss();
        }
    }

    private void updateList(final List<PokemonResponse> list) {
        mAdapter.addAll(list, getActivity());
        mRecyclerView.getAdapter().notifyDataSetChanged();
    }
}
