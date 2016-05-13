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
public class VideoPlayAdapter extends RecyclerView.Adapter<VideoPlayAdapter.MyViewHolder>{
    private VideoBean videoBean;
    private Context context;

    public VideoPlayAdapter(Context context) {
        this.context = context;
    }

    public void setVideoBean(VideoBean videoBean) {
        this.videoBean = videoBean;
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_video,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

//        Bitmap map = null;
//        try {
//            URL url = new URL(videoBean.getData().get(0).getCatword_id().get(position).getPic_url());
//            URLConnection connection = url.openConnection();
//            connection.connect();
//            InputStream in = connection.getInputStream();
//            map = BitmapFactory.decodeStream(in);
//
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        holder.topIv.setImageBitmap(map);



        Picasso.with(context).load(videoBean.getData().get(0).getCatword_id().get(position).getPic_url()).
                placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(holder.topIv);

        holder.bottomTv.setText(videoBean.getData().get(0).getCatword_id().get(position).getName());
    }

    @Override
    public int getItemCount() {
        return videoBean == null ? 0 : videoBean.getData().get(0).getCatword_id().size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView topIv;
        TextView bottomTv;

        public MyViewHolder(View itemView) {
            super(itemView);
            topIv = (ImageView) itemView.findViewById(R.id.item_video_iv);
            bottomTv = (TextView) itemView.findViewById(R.id.item_video_tv);
        }
    }
}