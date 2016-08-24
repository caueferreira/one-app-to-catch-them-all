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
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

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

        mPokemonApi.list()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<PokemonResponseList>() {
                    @Override
                    public void onCompleted() {
                        showLoading(false);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("onFailure", e.toString());
                    }

                    @Override
                    public void onNext(PokemonResponseList pokemonResponseList) {
                        updateList(pokemonResponseList.getResults());
                    }
                });

        mRecyclerView.addOnScrollListener(new EndlessRecyclerOnScrollListener((LinearLayoutManager) mLayoutManager) {
            @Override
            public void onLoadMore(int page) {
                mPokemonApi.list(page * 10, 10)
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Subscriber<PokemonResponseList>() {
                            @Override
                            public void onCompleted() {
                                showLoading(false);
                            }

                            @Override
                            public void onError(Throwable e) {
                                Log.e("onFailure", e.toString());
                            }

                            @Override
                            public void onNext(PokemonResponseList pokemonResponseList) {
                                updateList(pokemonResponseList.getResults());
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
