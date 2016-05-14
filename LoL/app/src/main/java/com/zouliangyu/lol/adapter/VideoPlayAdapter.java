package com.zouliangyu.lol.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zouliangyu.lol.R;
import com.zouliangyu.lol.bean.VideoBean;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by zouliangyu on 16/5/12.
 */
public class VideoPlayAdapter extends RecyclerView.Adapter<VideoPlayAdapter.MyViewHolder> {
    private VideoBean videoBean;
    private Context context;
    private MyItemClickListener mItemClickListener;


    public VideoPlayAdapter(Context context) {
        this.context = context;
    }

    public void setVideoBean(VideoBean videoBean) {
        this.videoBean = videoBean;
        notifyDataSetChanged();
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_video, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(itemView,mItemClickListener);
        return viewHolder;
    }

    public void setOnItemClickListener(MyItemClickListener listener){
        this.mItemClickListener = listener;

    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Picasso.with(context).load(videoBean.getData().get(0).getCatword_id().get(position).getPic_url()).
                placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(holder.topIv);
        holder.bottomTv.setText(videoBean.getData().get(0).getCatword_id().get(position).getName());
    }

    @Override
    public int getItemCount() {
        return videoBean == null ? 0 : videoBean.getData().get(0).getCatword_id().size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView topIv;
        TextView bottomTv;
        private MyItemClickListener mListener;





        public MyViewHolder(View itemView, MyItemClickListener listener) {
            super(itemView);
            topIv = (ImageView) itemView.findViewById(R.id.item_video_iv);
            bottomTv = (TextView) itemView.findViewById(R.id.item_video_tv);

            this.mListener = listener;
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            if (mListener != null){
                mListener.onItemClickListener(v, getPosition());
            }
        }
    }


    public interface MyItemClickListener {
        void onItemClickListener(View view, int position);
    }
}
