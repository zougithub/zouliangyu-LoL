package com.zouliangyu.lol.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.zouliangyu.lol.R;
import com.zouliangyu.lol.bean.MoreImageBean;

import java.util.List;

import it.sephiroth.android.library.picasso.Picasso;

import static com.zouliangyu.lol.R.layout.item_more_image;

/**
 * Created by zouliangyu on 16/5/19.
 */
public class MoreImageAdapter extends RecyclerView.Adapter<MoreImageAdapter.MyViewHolder> {
    private MoreImageBean moreImageBeans;
    private Context context;

    public MoreImageAdapter(Context context) {
        this.context = context;
    }

    public void setMoreImageBeans(MoreImageBean moreImageBeans) {
        this.moreImageBeans = moreImageBeans;
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_more_image, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Picasso.with(context).load(moreImageBeans.getData().get(position).getPic_thumb_url()).
                placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(holder.imageView);


    }

    @Override
    public int getItemCount() {
        return moreImageBeans == null ? 0 : moreImageBeans.getData().size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.item_more_image);
        }
    }
}
