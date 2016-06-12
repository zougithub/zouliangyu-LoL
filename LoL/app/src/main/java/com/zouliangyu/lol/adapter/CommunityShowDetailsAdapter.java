package com.zouliangyu.lol.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.zouliangyu.lol.R;
import com.zouliangyu.lol.bean.CommunityShowBean;
import java.util.List;
import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by zouliangyu on 16/5/20.
 */
public class CommunityShowDetailsAdapter extends BaseAdapter {
    private Context context;
    private List<CommunityShowBean.DataBean> dataBeans;
    private ViewHolder viewHolder;

    public void setDataBeans(List<CommunityShowBean.DataBean> dataBeans) {
        this.dataBeans = dataBeans;
        notifyDataSetChanged();
    }

    public CommunityShowDetailsAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return dataBeans == null ? 0 : dataBeans.size();
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
        viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_community_show, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        int viewType = getItemViewType(position);
        switch (viewType) {
            case 1:
                viewHolder.nickNameTv.setText(dataBeans.get(position).getNickname());
                viewHolder.timeTv.setText(dataBeans.get(position).getCreated().substring(11, 16));
                viewHolder.sexIv.setImageResource(R.mipmap.radio_enabled_on_boy);
                viewHolder.areaTv.setText(dataBeans.get(position).getArea());
                viewHolder.summonerTv.setText(dataBeans.get(position).getSummoner());
                Picasso.with(context).load(dataBeans.get(position).getPic_url()).
                        placeholder(R.mipmap.photo_default).error(R.mipmap.photo_default).into(viewHolder.imageView);
                viewHolder.descTv.setText(dataBeans.get(position).getDesc());
                break;
            case 2:
                viewHolder.nickNameTv.setText(dataBeans.get(position).getNickname());
                viewHolder.timeTv.setText(dataBeans.get(position).getCreated().substring(11, 16));
                viewHolder.sexIv.setImageResource(R.mipmap.radio_enabled_on_girl);
                viewHolder.areaTv.setText(dataBeans.get(position).getArea());
                viewHolder.summonerTv.setText(dataBeans.get(position).getSummoner());
                Picasso.with(context).load(dataBeans.get(position).getPic_url()).
                        placeholder(R.mipmap.photo_default).error(R.mipmap.photo_default).into(viewHolder.imageView);
                viewHolder.descTv.setText(dataBeans.get(position).getDesc());
                break;
        }
        return convertView;
    }

    @Override
    public int getItemViewType(int position) {
        return Integer.parseInt(dataBeans.get(position).getSex());
    }

    class ViewHolder {
        TextView nickNameTv;
        TextView timeTv;
        ImageView sexIv;
        TextView areaTv;
        TextView summonerTv;
        ImageView imageView;
        TextView descTv;

        public ViewHolder(View itemView) {
            nickNameTv = (TextView) itemView.findViewById(R.id.item_community_show_nickname_tv);
            timeTv = (TextView) itemView.findViewById(R.id.item_community_show_time_tv);
            sexIv = (ImageView) itemView.findViewById(R.id.item_community_show_sex_iv);
            areaTv = (TextView) itemView.findViewById(R.id.item_community_show_area_tv);
            summonerTv = (TextView) itemView.findViewById(R.id.item_community_show_summoner_tv);
            imageView = (ImageView) itemView.findViewById(R.id.item_community_show_iv);
            descTv = (TextView) itemView.findViewById(R.id.item_community_show_desc_tv);
        }
    }


}
