package com.zouliangyu.lol.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zouliangyu.lol.R;
import com.zouliangyu.lol.bean.VideoPlayNewestDetailsBean;

import java.text.SimpleDateFormat;
import java.util.Date;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by zouliangyu on 16/5/14.
 */
public class VideoPlayNewestDetailsAdapter extends BaseAdapter {
    private VideoPlayNewestDetailsBean videoPlayNewestDetailsBeans;

    private Context context;

    public VideoPlayNewestDetailsAdapter(Context context) {
        this.context = context;
    }

    public void setVideoPlayNewestDetailsBeans(VideoPlayNewestDetailsBean videoPlayNewestDetailsBeans) {
        this.videoPlayNewestDetailsBeans = videoPlayNewestDetailsBeans;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return videoPlayNewestDetailsBeans == null ? 0 : videoPlayNewestDetailsBeans.getData().size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_video_details, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }


        Picasso.with(context).load(videoPlayNewestDetailsBeans.getData().get(position).getPic_url()).
                placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(holder.bottomIv);
        holder.titleTv.setText(videoPlayNewestDetailsBeans.getData().get(position).getTitle());
        holder.descTv.setText(videoPlayNewestDetailsBeans.getData().get(position).getDesc());

        Date date = new Date(videoPlayNewestDetailsBeans.getData().get(position).getPublished());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        String time = simpleDateFormat.format(date);
        holder.timeTv.setText(time);

        return convertView;
    }


    class ViewHolder {
        ImageView bottomIv;
        TextView titleTv;
        TextView descTv;
        TextView timeTv;

        public ViewHolder(View itemView) {
            bottomIv = (ImageView) itemView.findViewById(R.id.item_video_details_bottom_iv);
            titleTv = (TextView) itemView.findViewById(R.id.item_video_details_title_tv);
            descTv = (TextView) itemView.findViewById(R.id.item_video_details_desc_tv);
            timeTv = (TextView) itemView.findViewById(R.id.item_video_details_time_tv);


        }


    }
}
