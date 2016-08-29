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
import app.caueferreira.oneapptocatchthemall.presentation.model.MoveModel;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by caueferreira on 8/21/16.
 */

public class MoveAdapter extends RecyclerView.Adapter<MoveAdapter.ViewHolder> {
    private List<MoveModel> mMoves;
    private Activity mActivity;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.move)
        public TextView mTxtMove;

        public ViewHolder(final View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public MoveAdapter(final Activity activity) {
        mMoves = new ArrayList<>();
        mActivity = activity;
    }

    public MoveAdapter addAll(final List<MoveModel> moves, final Activity activity) {
        this.mMoves.addAll(moves);
        mActivity = activity;
        return this;
    }

    public MoveAdapter(final List<MoveModel> moves) {
        this.mMoves = moves;
    }


    @Override
    public MoveAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.move_list_view, parent, false);

        MoveAdapter.ViewHolder vh = new MoveAdapter.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MoveAdapter.ViewHolder holder, int position) {
        holder.mTxtMove.setText(mMoves.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return mMoves.size();
    }
}
