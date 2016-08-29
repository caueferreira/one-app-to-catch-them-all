package app.caueferreira.oneapptocatchthemall.presentation.view.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import app.caueferreira.oneapptocatchthemall.R;
import app.caueferreira.oneapptocatchthemall.presentation.model.StatsModel;

/**
 * Created by caueferreira on 8/22/16.
 */

public class StatsAdapter extends RecyclerView.Adapter<StatsAdapter.ViewHolder> {
    private List<StatsModel> mStats;
    private Activity mActivity;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTxtName;
        public TextView mTxtValue;

        public ViewHolder(final View view) {
            super(view);
            mTxtName = (TextView) view.findViewById(R.id.name);
            mTxtValue = (TextView) view.findViewById(R.id.value);
        }
    }

    public StatsAdapter(final Activity activity) {
        mStats = new ArrayList<>();
        mActivity = activity;
    }

    public StatsAdapter addAll(final List<StatsModel> stats, final Activity activity) {
        this.mStats.addAll(stats);
        mActivity = activity;
        return this;
    }

    public StatsAdapter(final List<StatsModel> stats) {
        this.mStats = stats;
    }


    @Override
    public StatsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.stats_list_view, parent, false);

        StatsAdapter.ViewHolder vh = new StatsAdapter.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(StatsAdapter.ViewHolder holder, int position) {
        holder.mTxtName.setText(mStats.get(position).getName());
        holder.mTxtValue.setText(mStats.get(position).getValue());
    }

    @Override
    public int getItemCount() {
        return mStats.size();
    }
}