package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by dangxiaoliang.me on 2016/11/9.
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.VH> {

    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private int[] datas;

    public MyRecyclerViewAdapter(Context context, int[] datas) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        this.datas = datas;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {

    }

    @Override
    public int getItemCount() {
        return datas.length;
    }

    public static class VH extends RecyclerView.ViewHolder {
        public VH(View itemView) {
            super(itemView);
        }
    }
}
