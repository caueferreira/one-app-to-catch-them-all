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

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.URL;

import app.caueferreira.oneapptocatchthemall.R;
import app.caueferreira.oneapptocatchthemall.api.PokemonApiService;
import app.caueferreira.oneapptocatchthemall.entity.Pokemon;
import app.caueferreira.oneapptocatchthemall.view.MoveAdapter;
import app.caueferreira.oneapptocatchthemall.view.StatsAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A placeholder fragment containing a simple view.
 */
public class PokemonDetailActivityFragment extends Fragment {

    public PokemonDetailActivityFragment() {
    }

    private Retrofit mRetrofit;
    private PokemonApiService mPokemonApi;

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

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();

        mRetrofit = new Retrofit.Builder()
                .baseUrl("http://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        mPokemonApi = mRetrofit.create(PokemonApiService.class);
        mMovesView.setAdapter(mMoveAdapter);
        mStatsView.setAdapter(mStatsAdapter);

        showLoading(true);

        mPokemonApi.get(position).enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                Log.i("Pokemon", response.body().toString());
                final Pokemon pokemon = response.body();

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

                showLoading(false);
            }

            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {
                Log.e("Pokemon", t.getLocalizedMessage());

                showLoading(false);
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
