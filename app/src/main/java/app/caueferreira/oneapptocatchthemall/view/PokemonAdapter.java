package app.caueferreira.oneapptocatchthemall.view;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import app.caueferreira.oneapptocatchthemall.R;
import app.caueferreira.oneapptocatchthemall.activity.PokemonDetailActivity;
import app.caueferreira.oneapptocatchthemall.data.entity.PokemonResponse;

/**
 * Created by caueferreira on 8/18/16.
 */

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.ViewHolder> {
    private List<PokemonResponse> mPokemons;
    private Activity mActivity;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTxtPokemonName;
        public TextView mTxtPokemonNumber;

        public ViewHolder(final View view) {
            super(view);
            mTxtPokemonName = (TextView) view.findViewById(R.id.pokemonName);
            mTxtPokemonNumber = (TextView) view.findViewById(R.id.pokemonNumber);
        }
    }

    public PokemonAdapter(final Activity activity) {
        mPokemons = new ArrayList<>();
        mActivity = activity;
    }

    public PokemonAdapter addAll(final List<PokemonResponse> pokemons, final Activity activity) {
        this.mPokemons.addAll(pokemons);
        mActivity = activity;
        return this;
    }

    public PokemonAdapter(final List<PokemonResponse> pokemons) {
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
            myIntent.putExtra("number", position + 1);
            mActivity.startActivity(myIntent);
        });
    }

    @Override
    public int getItemCount() {
        return mPokemons.size();
    }
}


