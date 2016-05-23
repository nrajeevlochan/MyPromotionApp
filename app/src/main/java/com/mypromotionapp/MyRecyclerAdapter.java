package com.mypromotionapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.List;

/**
 * Created by ${} on 5/20/16.
 */
public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder> {

    private static final String TAG = MyRecyclerAdapter.class.getName();
    private List<Promotion> promotionList;
    private ImageLoader imageLoader;
    public OnItemClickListener mItemClickListener;
    private Context context;

    public interface OnItemClickListener {
        void onItemClick(View view, Promotion promotion, int position);
    }

    public MyRecyclerAdapter(List<Promotion> promotionList, Context context, OnItemClickListener onItemClickListener) {
        this.promotionList = promotionList;
        this.context = context;
        mItemClickListener = onItemClickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.promo_list_row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Promotion promotion = promotionList.get(position);
        holder.title.setText(promotion.getTitle());

        imageLoader = MyPromotionCardApplication.getInstance().getImageLoader();
        imageLoader.get(promotion.getImageUrl(), ImageLoader.getImageListener(holder.imageView, R.mipmap.ic_launcher, android.R.drawable.ic_dialog_alert));

        holder.imageView.setImageUrl(promotion.getImageUrl(), imageLoader);
        holder.title.setText(promotion.getTitle());

        holder.bind(promotion, mItemClickListener, position);
    }

    @Override
    public int getItemCount() {
        return promotionList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public NetworkImageView imageView;
        private View view;

        public MyViewHolder(View view) {
            super(view);
            this.view = view;
            title = (TextView) view.findViewById(R.id.title);
            imageView = (NetworkImageView) view.findViewById(R.id.imageView);
        }

        public void bind(final Promotion promotion, final OnItemClickListener listener, final int position) {
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "Onclick at postion: " + position);
                    listener.onItemClick(v, promotion, position);
                }
            });
        }
    }
}
