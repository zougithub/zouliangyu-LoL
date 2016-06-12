package com.zouliangyu.lol.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.zouliangyu.lol.R;
import com.zouliangyu.lol.bean.CommunityFriendBean;

/**
 * Created by zouliangyu on 16/5/21.
 */
public class CommunityFriendDetailsAdapter extends RecyclerView.Adapter<CommunityFriendDetailsAdapter.ViewHolder> {
    private CommunityFriendBean communityFriendBean;
    private Context context;

    public CommunityFriendDetailsAdapter(Context context) {
        this.context = context;
    }

    public void setCommunityFriendBean(CommunityFriendBean communityFriendBean) {
        this.communityFriendBean = communityFriendBean;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return Integer.parseInt(communityFriendBean.getData().get(position).getSex());
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_community_friend, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        int viewType = getItemViewType(position);
        switch (viewType) {
            case 1:
                holder.nickNameTv.setText(communityFriendBean.getData().get(position).getNickname());
                holder.sexIv.setImageResource(R.mipmap.radio_enabled_on_boy);
                holder.timeTv.setText(communityFriendBean.getData().get(position).getCreated().substring(11, 16));
                holder.areaTv.setText(communityFriendBean.getData().get(position).getArea());
                holder.summonerTv.setText(communityFriendBean.getData().get(position).getSummoner());
                holder.zdlTv.setText(communityFriendBean.getData().get(position).getZdl());
                holder.cityTv.setText(communityFriendBean.getData().get(position).getCity());
                holder.sloganTv.setText(communityFriendBean.getData().get(position).getSlogan());
                break;
            case 2:
                holder.nickNameTv.setText(communityFriendBean.getData().get(position).getNickname());
                holder.sexIv.setImageResource(R.mipmap.radio_enabled_on_girl);
                holder.timeTv.setText(communityFriendBean.getData().get(position).getCreated().substring(11, 16));
                holder.areaTv.setText(communityFriendBean.getData().get(position).getArea());
                holder.summonerTv.setText(communityFriendBean.getData().get(position).getSummoner());
                holder.zdlTv.setText(communityFriendBean.getData().get(position).getZdl());
                holder.cityTv.setText(communityFriendBean.getData().get(position).getCity());
                holder.sloganTv.setText(communityFriendBean.getData().get(position).getSlogan());
                break;
        }

    }

    @Override
    public int getItemCount() {
        return communityFriendBean == null ? 0 : communityFriendBean.getData().size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView nickNameTv;
        ImageView sexIv;
        TextView timeTv;
        TextView areaTv;
        TextView summonerTv;
        TextView zdlTv;
        TextView cityTv;
        TextView sloganTv;

        public ViewHolder(View itemView) {
            super(itemView);
            nickNameTv = (TextView) itemView.findViewById(R.id.item_friend_nickname_tv);
            sexIv = (ImageView) itemView.findViewById(R.id.item_friend_sex_iv);
            timeTv = (TextView) itemView.findViewById(R.id.item_friend_time_tv);
            areaTv = (TextView) itemView.findViewById(R.id.item_friend_area_tv);
            summonerTv = (TextView) itemView.findViewById(R.id.item_friend_summoner_name_tv);
            zdlTv = (TextView) itemView.findViewById(R.id.item_friend_zdl_tv);
            cityTv = (TextView) itemView.findViewById(R.id.item_friend_city_tv);
            sloganTv = (TextView) itemView.findViewById(R.id.item_friend_slogan_tv);
        }
    }
}
