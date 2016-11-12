package adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.util.LruCache;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.LoadingBitmap;
import com.example.myapplication.R;

/**
 * Created by dangxiaoliang.me on 2016/11/9.
 */

public class MyListViewAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private String[] datas;
    private Bitmap mPlaceHolderBitmap;
    private LoadingBitmap loadingBitmap;

    public MyListViewAdapter(Context context, String[] datas) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        this.datas = datas;
        mPlaceHolderBitmap = BitmapFactory
                .decodeResource(mContext.getResources(), R.mipmap.ic_launcher);
        loadingBitmap = new LoadingBitmap(context);
    }

    @Override
    public int getCount() {
        return datas.length;
    }

    @Override
    public Object getItem(int i) {
        return datas[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ViewHolder();
            view = mLayoutInflater.inflate(R.layout.listview_item, viewGroup, false);
            viewHolder.textView = (TextView) view.findViewById(R.id.tv);
            viewHolder.imageView = (ImageView) view.findViewById(R.id.iv);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        //viewHolder.imageView.setImageResource(datas[i]);
        loadBitmap(datas[i], viewHolder.imageView);
        return view;
    }

    class ViewHolder {
        TextView textView;
        ImageView imageView;
    }

    public void loadBitmap(String resId, ImageView imageView) {
        Bitmap bitmap = LoadingBitmap.getBitmapFromMemCache(resId);
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
        } else {
            if (LoadingBitmap.cancelPotentialWork(resId, imageView)) {
                final LoadingBitmap.BitmapWorkerTask task = new LoadingBitmap.BitmapWorkerTask(imageView);
                final LoadingBitmap.AsyncDrawable asyncDrawable =
                        new LoadingBitmap.AsyncDrawable(mContext.getResources(), mPlaceHolderBitmap, task);
                imageView.setImageDrawable(asyncDrawable);
                task.execute(resId);
            }
        }
    }
}
