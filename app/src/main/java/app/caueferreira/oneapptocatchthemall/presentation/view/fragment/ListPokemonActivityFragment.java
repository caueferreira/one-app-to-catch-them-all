package app.caueferreira.oneapptocatchthemall.presentation.view.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import app.caueferreira.oneapptocatchthemall.R;
import app.caueferreira.oneapptocatchthemall.presentation.model.request.PokemonListRequest;
import app.caueferreira.oneapptocatchthemall.presentation.model.response.PokemonNameResponse;
import app.caueferreira.oneapptocatchthemall.presentation.presenter.ListPokemonPresenter;
import app.caueferreira.oneapptocatchthemall.presentation.view.ListPokemonView;
import app.caueferreira.oneapptocatchthemall.presentation.view.custom.EndlessRecyclerOnScrollListener;
import app.caueferreira.oneapptocatchthemall.presentation.view.adapter.PokemonAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A placeholder fragment containing a simple view.
 */
public class ListPokemonActivityFragment extends BaseFragment implements ListPokemonView {

    public ListPokemonActivityFragment() {
    }

    @BindView(R.id.pokemon_list)
    RecyclerView mRecyclerView;

    private PokemonAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private ProgressDialog mProgress;

    @Inject
    ListPokemonPresenter listPokemonPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_pokemon, container, false);
        getApplicationComponent().inject(this);
        ButterKnife.bind(this, view);

        listPokemonPresenter.setView(this);

        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new PokemonAdapter(getActivity());
        mRecyclerView.setAdapter(mAdapter);

        showLoading();

        listPokemonPresenter.list(PokemonListRequest.create().withOffset(0).withLimit(10));

        mRecyclerView.addOnScrollListener(new EndlessRecyclerOnScrollListener((LinearLayoutManager) mLayoutManager) {
            @Override
            public void onLoadMore(int page) {
                listPokemonPresenter.list(PokemonListRequest.create().withOffset((page-1) * 10).withLimit(10));
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

    @Override
    public void renderPokemonList() {
        mRecyclerView.getAdapter().notifyDataSetChanged();

    }

    @Override
    public void renderPokemon(final PokemonNameResponse pokemonNameResponse) {
        mAdapter.add(pokemonNameResponse);
    }

    @Override
    public void showLoading() {
        showLoading(true);
    }

    @Override
    public void hideLoading() {
        showLoading(false);
    }
}
