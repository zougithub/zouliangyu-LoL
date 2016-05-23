package com.zouliangyu.lol.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zouliangyu.lol.R;
import com.zouliangyu.lol.bean.CommunityShowBean;

import java.text.SimpleDateFormat;
import java.util.Date;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by zouliangyu on 16/5/20.
 */
public class CommunityShowDetailsAdapter extends RecyclerView.Adapter<CommunityShowDetailsAdapter.ViewHolder> {
    private CommunityShowBean communityShowBean;
    private Context context;

    public CommunityShowDetailsAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        return Integer.parseInt(communityShowBean.getData().get(position).getSex());
    }

    public void setCommunityShowBean(CommunityShowBean communityShowBean) {
        this.communityShowBean = communityShowBean;
        notifyDataSetChanged();
    }
//
//    @Override
//    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        ViewHolder viewHolder = null;
////        switch (viewType){
////            case 1:
//        View view = LayoutInflater.from(context).inflate(R.layout.item_community_show, parent, false);
//        viewHolder = new ViewHolder(view);
//
////        }
//        return viewHolder;
//    }
//
//    @Override
//    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//        int viewType = getItemViewType(position);
//        switch (viewType){
//            case 1:
//                ViewHolder viewHolder = (ViewHolder) holder;
//                viewHolder.
//                break;
//            case 2:
//                break;
//        }
//
//    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder viewHolder = null;
        View view = LayoutInflater.from(context).inflate(R.layout.item_community_show, parent, false);
        viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        int viewType = getItemViewType(position);
        switch (viewType) {
            case 1:
                holder.nickNameTv.setText(communityShowBean.getData().get(position).getNickname());
                holder.timeTv.setText(communityShowBean.getData().get(position).getCreated().substring(11, 16));
                holder.sexIv.setImageResource(R.mipmap.radio_enabled_on_boy);
                holder.areaTv.setText(communityShowBean.getData().get(position).getArea());
                holder.summonerTv.setText(communityShowBean.getData().get(position).getSummoner());
                Picasso.with(context).load(communityShowBean.getData().get(position).getPic_url()).
                        placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(holder.imageView);
                holder.descTv.setText(communityShowBean.getData().get(position).getDesc());
                break;
            case 2:
                holder.nickNameTv.setText(communityShowBean.getData().get(position).getNickname());

//                Date date = new Date(communityShowBean.getData().get(position).getCreated());
//                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
//                String time = simpleDateFormat.format(date);

                holder.timeTv.setText(communityShowBean.getData().get(position).getCreated().substring(11, 16));

                holder.sexIv.setImageResource(R.mipmap.radio_enabled_on_girl);
                holder.areaTv.setText(communityShowBean.getData().get(position).getArea());
                holder.summonerTv.setText(communityShowBean.getData().get(position).getSummoner());
                Picasso.with(context).load(communityShowBean.getData().get(position).getPic_url()).
                        placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(holder.imageView);
                holder.descTv.setText(communityShowBean.getData().get(position).getDesc());
                break;
        }
    }

    @Override
    public int getItemCount() {
        return communityShowBean == null ? 0 : communityShowBean.getData().size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView nickNameTv;
        TextView timeTv;
        ImageView sexIv;
        TextView areaTv;
        TextView summonerTv;
        ImageView imageView;
        TextView descTv;

        public ViewHolder(View itemView) {
            super(itemView);
            nickNameTv = (TextView) itemView.findViewById(R.id.item_community_show_nickname_tv);
            timeTv = (TextView) itemView.findViewById(R.id.item_community_show_time_tv);
            sexIv = (ImageView) itemView.findViewById(R.id.item_community_show_sex_iv);
            areaTv = (TextView) itemView.findViewById(R.id.item_community_show_area_tv);
            summonerTv = (TextView) itemView.findViewById(R.id.item_community_show_summoner_tv);
            imageView = (ImageView) itemView.findViewById(R.id.item_community_show_iv);
            descTv = (TextView) itemView.findViewById(R.id.item_community_show_desc_tv);
        }
    }

    class WomanViewHolder extends RecyclerView.ViewHolder {
        TextView nickNameTv;
        ImageView sexIv;
        TextView areaTv;
        TextView summonerTv;
        ImageView imageView;
        TextView descTv;

        public WomanViewHolder(View itemView) {
            super(itemView);
            nickNameTv = (TextView) itemView.findViewById(R.id.item_community_show_nickname_tv);
            sexIv = (ImageView) itemView.findViewById(R.id.item_community_show_sex_iv);
            areaTv = (TextView) itemView.findViewById(R.id.item_community_show_area_tv);
            summonerTv = (TextView) itemView.findViewById(R.id.item_community_show_summoner_tv);
            imageView = (ImageView) itemView.findViewById(R.id.item_community_show_iv);
            descTv = (TextView) itemView.findViewById(R.id.item_community_show_desc_tv);
        }
    }
}
