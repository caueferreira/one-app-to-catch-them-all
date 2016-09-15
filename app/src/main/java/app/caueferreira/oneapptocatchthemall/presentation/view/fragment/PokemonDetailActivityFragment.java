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

import com.google.gson.Gson;

import java.net.URL;

import javax.inject.Inject;

import app.caueferreira.oneapptocatchthemall.R;
import app.caueferreira.oneapptocatchthemall.presentation.model.request.PokemonRequest;
import app.caueferreira.oneapptocatchthemall.presentation.model.response.PokemonResponse;
import app.caueferreira.oneapptocatchthemall.presentation.presenter.PokemonDetailPresenter;
import app.caueferreira.oneapptocatchthemall.presentation.view.PokemonDetailView;
import app.caueferreira.oneapptocatchthemall.presentation.view.adapter.MoveAdapter;
import app.caueferreira.oneapptocatchthemall.presentation.view.adapter.StatsAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A placeholder fragment containing a simple view.
 */
public class PokemonDetailActivityFragment extends BaseFragment implements PokemonDetailView {

    public PokemonDetailActivityFragment() {
    }

    @BindView(R.id.name)
    TextView mTxtName;
    @BindView(R.id.number)
    TextView mTxtNumber;
    @BindView(R.id.type)
    TextView mTxtType;
    @BindView(R.id.type2)
    TextView mTxtType2;
    @BindView(R.id.sprite)
    ImageView mImgSprite;

    @BindView(R.id.move_list)
    RecyclerView mMovesView;
    @BindView(R.id.stats_list)
    RecyclerView mStatsView;

    private RecyclerView.LayoutManager mLayoutManager;
    private MoveAdapter mMoveAdapter;

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
        ButterKnife.bind(this, view);

        pokemonDetailPresenter.setView(this);

        final PokemonRequest pokemonRequest = new Gson().fromJson(
                getActivity().getIntent().getStringExtra("request"), PokemonRequest.class);

        pokemonDetailPresenter.get(pokemonRequest);

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

    private void loadSprite(final PokemonResponse pokemonResponse) {
        new RetrieveSpriteTask().execute(pokemonResponse);
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
    public void renderPokemon(final PokemonResponse pokemonResponse) {
        mTxtName.setText(pokemonResponse.getName());
        mTxtNumber.setText(pokemonResponse.getNumber());
        mTxtType.setText(pokemonResponse.getTypes().get(0).getName());

        if (pokemonResponse.getTypes().size() > 1)
            mTxtType2.setText(pokemonResponse.getTypes().get(1).getName());
        else
            mTxtType2.setVisibility(View.INVISIBLE);

        mMoveAdapter.addAll(pokemonResponse.getMoves(), getActivity());
        mMovesView.getAdapter().notifyDataSetChanged();

        mStatsAdapter.addAll(pokemonResponse.getStats(), getActivity());
        mStatsView.getAdapter().notifyDataSetChanged();

        loadSprite(pokemonResponse);
    }

    @Override
    public void showLoading() {
        showLoading(true);
    }

    @Override
    public void hideLoading() {
        showLoading(false);
    }

    private class RetrieveSpriteTask extends AsyncTask<PokemonResponse, Void, Bitmap> {

        @Override
        protected Bitmap doInBackground(PokemonResponse... pokemonResponses) {

            URL url = null;
            try {
                url = new URL(pokemonResponses[0].getSprite());
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
