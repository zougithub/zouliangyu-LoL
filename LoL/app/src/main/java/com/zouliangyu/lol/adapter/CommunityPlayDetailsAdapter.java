package com.zouliangyu.lol.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zouliangyu.lol.R;
import com.zouliangyu.lol.bean.CommunityPlayBean;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zouliangyu on 16/5/21.
 */
public class CommunityPlayDetailsAdapter extends BaseAdapter {
    private CommunityPlayBean communityPlayBean;
    private Context context;

    public CommunityPlayDetailsAdapter(Context context) {
        this.context = context;
    }

    public void setCommunityPlayBean(CommunityPlayBean communityPlayBean) {
        this.communityPlayBean = communityPlayBean;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return communityPlayBean == null ? 0 : communityPlayBean.getData().size();
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
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_community_play_details, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.personTv.setText(communityPlayBean.getData().get(position).getNickname());

        Date date = new Date(communityPlayBean.getData().get(position).getCreated());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        String time = simpleDateFormat.format(date);
        viewHolder.timeTv.setText(time);

        viewHolder.typeTv.setText(communityPlayBean.getData().get(position).getTitle());
        viewHolder.patternTv.setText(communityPlayBean.getData().get(position).getMap());
        viewHolder.areaTv.setText(communityPlayBean.getData().get(position).getArea());
        viewHolder.nameTv.setText(communityPlayBean.getData().get(position).getSummoner());
        viewHolder.zdlTv.setText(communityPlayBean.getData().get(position).getZdl());
        return convertView;
    }

    class ViewHolder {
        TextView personTv;
        TextView timeTv;
        TextView typeTv;
        TextView patternTv;
        TextView areaTv;
        TextView nameTv;
        TextView zdlTv;

        public ViewHolder(View itemView) {
            personTv = (TextView) itemView.findViewById(R.id.item_community_play_details_person);
            timeTv = (TextView) itemView.findViewById(R.id.item_community_play_details_time);
            typeTv = (TextView) itemView.findViewById(R.id.item_community_play_details_type);
            patternTv = (TextView) itemView.findViewById(R.id.item_community_play_details_pattern);
            areaTv = (TextView) itemView.findViewById(R.id.item_community_play_details_area);
            nameTv = (TextView) itemView.findViewById(R.id.item_community_play_details_name);
            zdlTv = (TextView) itemView.findViewById(R.id.item_community_play_details_zdl);
        }
    }
}
