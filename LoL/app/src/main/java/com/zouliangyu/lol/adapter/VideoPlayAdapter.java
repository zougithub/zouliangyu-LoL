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
import com.zouliangyu.lol.activity.VideoDetailsAty;
import com.zouliangyu.lol.bean.VideoBean;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by zouliangyu on 16/5/12.
 *
 * 视频tap的 adapter
 */
public class VideoPlayAdapter extends RecyclerView.Adapter<VideoPlayAdapter.MyViewHolder> {
    private VideoBean videoBean;
    private Context context;
    // 接口对象
    private MyItemClickListener myItemClickListener;
    // 设置接口对象
    public void setMyItemClickListener(MyItemClickListener myItemClickListener) {
        this.myItemClickListener = myItemClickListener;
    }

    private int pos;
    public VideoPlayAdapter(Context context, int pos) {
        this.context = context;
        this.pos = pos;
    }

    public void setVideoBean(VideoBean videoBean) {
        this.videoBean = videoBean;
        notifyDataSetChanged();
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_video, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(itemView);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {


        Picasso.with(context).load(videoBean.getData().get(pos).getCatword_id().get(position).getPic_url()).
                placeholder(R.mipmap.photo_default).error(R.mipmap.photo_default).into(holder.topIv);
        holder.bottomTv.setText(videoBean.getData().get(pos).getCatword_id().get(position).getName());
        if (myItemClickListener != null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();
                    myItemClickListener.onItemClickListener(pos);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return videoBean == null ? 0 : videoBean.getData().get(pos).getCatword_id().size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView topIv;
        TextView bottomTv;
        private MyItemClickListener mListener;


        public MyViewHolder(View itemView) {
            super(itemView);
            topIv = (ImageView) itemView.findViewById(R.id.item_video_iv);
            bottomTv = (TextView) itemView.findViewById(R.id.item_video_tv);

        }



    }


    // 内部接口
    public interface MyItemClickListener {
        void onItemClickListener(int position);
    }
}
