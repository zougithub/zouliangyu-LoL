package com.zouliangyu.lol.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zouliangyu.lol.R;
import com.zouliangyu.lol.bean.MoreMatchNewsBean;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zouliangyu on 16/5/22.
 */
public class MatchNewsAdapter extends BaseAdapter {
    private MoreMatchNewsBean moreMatchNewsBean;
    private Context context;

    public MatchNewsAdapter(Context context) {
        this.context = context;
    }

    public void setMoreMatchNewsBean(MoreMatchNewsBean moreMatchNewsBean) {
        this.moreMatchNewsBean = moreMatchNewsBean;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return moreMatchNewsBean == null ? 0 : moreMatchNewsBean.getData().size();
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_more_match_news, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.titleTv.setText(moreMatchNewsBean.getData().get(position).getTitle());
        viewHolder.descTv.setText(moreMatchNewsBean.getData().get(position).getDesc());
        Date date = new Date(moreMatchNewsBean.getData().get(position).getPublished());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
        String time = simpleDateFormat.format(date);
        viewHolder.timeTv.setText(time);

        return convertView;
    }

    class ViewHolder {
        TextView titleTv;
        TextView descTv;
        TextView timeTv;

        public ViewHolder(View itemView) {
            titleTv = (TextView) itemView.findViewById(R.id.item_more_match_news_title_tv);
            descTv = (TextView) itemView.findViewById(R.id.item_more_match_news_desc_tv);
            timeTv = (TextView) itemView.findViewById(R.id.item_more_match_news_time_tv);

        }
    }
}
