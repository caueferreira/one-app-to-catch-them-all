package app.caueferreira.oneapptocatchthemall.activity;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.URL;

import app.caueferreira.oneapptocatchthemall.AndroidApplication;
import app.caueferreira.oneapptocatchthemall.R;
import app.caueferreira.oneapptocatchthemall.data.repository.Pokedex;
import app.caueferreira.oneapptocatchthemall.entity.Pokemon;
import app.caueferreira.oneapptocatchthemall.view.MoveAdapter;
import app.caueferreira.oneapptocatchthemall.view.StatsAdapter;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * A placeholder fragment containing a simple view.
 */
public class PokemonDetailActivityFragment extends Fragment {

    public PokemonDetailActivityFragment() {
    }

    private Pokedex mPokedex;

    private TextView mTxtName, mTxtNumber, mTxtType, mTxtType2;
    private ImageView mImgSprite;

    private RecyclerView mMovesView;
    private RecyclerView.LayoutManager mLayoutManager;
    private MoveAdapter mMoveAdapter;

    private RecyclerView mStatsView;
    private StatsAdapter mStatsAdapter;
    private RecyclerView.LayoutManager mLayoutManager2;

    private ProgressDialog mProgress;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pokemon_detail, container, false);

        final int position = getActivity().getIntent().getIntExtra("number", 0);

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

        mPokedex = ((AndroidApplication)getActivity().getApplication()).getApplicationComponent().providePokedex();
        mMovesView.setAdapter(mMoveAdapter);
        mStatsView.setAdapter(mStatsAdapter);

        showLoading(true);

        mPokedex.get(position)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Pokemon>() {
                    @Override
                    public void onCompleted() {
                        showLoading(false);

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("onFailure", e.getLocalizedMessage());
                    }

                    @Override
                    public void onNext(Pokemon pokemon) {

                        mTxtName.setText(pokemon.getName());
                        mTxtNumber.setText(String.valueOf(position));
                        mTxtType.setText(pokemon.getTypes().get(0).getType().getName());

                        if (pokemon.getTypes().size() > 1)
                            mTxtType2.setText(pokemon.getTypes().get(1).getType().getName());
                        else
                            mTxtType2.setVisibility(View.INVISIBLE);

                        mMoveAdapter.addAll(pokemon.getMoves(), getActivity());
                        mMovesView.getAdapter().notifyDataSetChanged();

                        mStatsAdapter.addAll(pokemon.getStats(), getActivity());
                        mStatsView.getAdapter().notifyDataSetChanged();

                        loadSprite(pokemon);
                    }
                });

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

    private class RetrieveSpriteTask extends AsyncTask<Pokemon, Void, Bitmap> {

        @Override
        protected Bitmap doInBackground(Pokemon... pokemons) {

            URL url = null;
            try {
                url = new URL(pokemons[0].getSpripes().getFrontDefault());
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
