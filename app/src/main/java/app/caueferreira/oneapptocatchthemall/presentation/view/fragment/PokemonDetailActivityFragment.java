package app.caueferreira.oneapptocatchthemall.presentation.view.fragment;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.URL;

import javax.inject.Inject;

import app.caueferreira.oneapptocatchthemall.R;
import app.caueferreira.oneapptocatchthemall.domain.entity.Pokemon;
import app.caueferreira.oneapptocatchthemall.presentation.presenter.PokemonDetailPresenter;
import app.caueferreira.oneapptocatchthemall.presentation.view.PokemonDetailView;
import app.caueferreira.oneapptocatchthemall.presentation.view.adapter.MoveAdapter;
import app.caueferreira.oneapptocatchthemall.presentation.view.adapter.StatsAdapter;

/**
 * A placeholder fragment containing a simple view.
 */
public class PokemonDetailActivityFragment extends BaseFragment implements PokemonDetailView {

    public PokemonDetailActivityFragment() {
    }

    private TextView mTxtName, mTxtNumber, mTxtType, mTxtType2;
    private ImageView mImgSprite;

    private RecyclerView mMovesView;
    private RecyclerView.LayoutManager mLayoutManager;
    private MoveAdapter mMoveAdapter;

    private RecyclerView mStatsView;
    private StatsAdapter mStatsAdapter;
    private RecyclerView.LayoutManager mLayoutManager2;

    private ProgressDialog mProgress;

    @Inject
    PokemonDetailPresenter pokemonDetailPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pokemon_detail, container, false);
        getApplicationComponent().inject(this);

        pokemonDetailPresenter.setView(this);

        final int position = getActivity().getIntent().getIntExtra("number", 0);

        pokemonDetailPresenter.get(position);

        mTxtName = (TextView) view.findViewById(R.id.name);
        mTxtNumber = (TextView) view.findViewById(R.id.number);
        mImgSprite = (ImageView) view.findViewById(R.id.sprite);
        mTxtType = (TextView) view.findViewById(R.id.type);
        mTxtType2 = (TextView) view.findViewById(R.id.type2);
        mMovesView = (RecyclerView) view.findViewById(R.id.move_list);
        mStatsView = (RecyclerView) view.findViewById(R.id.stats_list);

        mMovesView.setHasFixedSize(true);
        mStatsView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(getActivity());
        mLayoutManager2 = new LinearLayoutManager(getActivity());

        mMovesView.setLayoutManager(mLayoutManager);
        mStatsView.setLayoutManager(mLayoutManager2);

        mMoveAdapter = new MoveAdapter(getActivity());
        mStatsAdapter = new StatsAdapter(getActivity());

        mMovesView.setAdapter(mMoveAdapter);
        mStatsView.setAdapter(mStatsAdapter);

        showLoading();

        return view;
    }

    private void loadSprite(final Pokemon pokemon) {
        new RetrieveSpriteTask().execute(pokemon);
    }

    private void showLoading(final boolean toggle) {
        if (toggle) {
            mProgress = new ProgressDialog(getActivity());
            mProgress.setTitle("Loading");
            mProgress.setMessage("Retrieving pokemon detail...");
            mProgress.show();
        } else {
            mProgress.dismiss();
        }
    }

    @Override
    public void renderPokemon(final Pokemon pokemon) {
        mTxtName.setText(pokemon.getName());
        mTxtNumber.setText(String.valueOf(pokemon.getNumber()));
        mTxtType.setText(pokemon.getTypes().get(0).getName());

        if (pokemon.getTypes().size() > 1)
            mTxtType2.setText(pokemon.getTypes().get(1).getName());
        else
            mTxtType2.setVisibility(View.INVISIBLE);

        mMoveAdapter.addAll(pokemon.getMoves(), getActivity());
        mMovesView.getAdapter().notifyDataSetChanged();

        mStatsAdapter.addAll(pokemon.getStats(), getActivity());
        mStatsView.getAdapter().notifyDataSetChanged();

        loadSprite(pokemon);
    }

    @Override
    public void showLoading() {
        showLoading(true);
    }

    @Override
    public void hideLoading() {
        showLoading(false);
    }

    private class RetrieveSpriteTask extends AsyncTask<Pokemon, Void, Bitmap> {

        @Override
        protected Bitmap doInBackground(Pokemon... pokemons) {

            URL url = null;
            try {
                url = new URL(pokemons[0].getSprite());
                Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
                return bmp;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            mImgSprite.setImageBitmap(bitmap);
        }
    }
}
