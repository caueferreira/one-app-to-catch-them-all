package app.caueferreira.oneapptocatchthemall.presentation.view.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import app.caueferreira.oneapptocatchthemall.R;
import app.caueferreira.oneapptocatchthemall.presentation.model.request.PokemonRequest;
import app.caueferreira.oneapptocatchthemall.presentation.model.response.PokemonNameResponse;
import app.caueferreira.oneapptocatchthemall.presentation.view.activity.PokemonDetailActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by caueferreira on 8/18/16.
 */

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.ViewHolder> {
    private List<PokemonNameResponse> mPokemons;
    private Activity mActivity;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.pokemonName)
        public TextView mTxtPokemonName;
        @BindView(R.id.pokemonNumber)
        public TextView mTxtPokemonNumber;

        public ViewHolder(final View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public PokemonAdapter(final Activity activity) {
        mPokemons = new ArrayList<>();
        mActivity = activity;
    }


    public void add(final PokemonNameResponse pokemonNameResponse) {
        this.mPokemons.add(pokemonNameResponse);
    }

    public PokemonAdapter(final List<PokemonNameResponse> pokemons) {
        this.mPokemons = pokemons;
    }

    @Override
    public PokemonAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                        int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.pokemon_list_view, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.mTxtPokemonName.setText(mPokemons.get(position).getName());
        holder.mTxtPokemonNumber.setText(String.valueOf(position + 1));

        holder.itemView.setOnClickListener(v -> {

            Intent myIntent = new Intent(mActivity, PokemonDetailActivity.class);
            myIntent.putExtra("request", new Gson().toJson(PokemonRequest.create().withNumber(position + 1)));
            mActivity.startActivity(myIntent);
        });
    }

    @Override
    public int getItemCount() {
        return mPokemons.size();
    }
}


