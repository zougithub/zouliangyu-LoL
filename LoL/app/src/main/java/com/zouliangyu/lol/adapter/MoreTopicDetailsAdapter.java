package com.zouliangyu.lol.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zouliangyu.lol.R;
import com.zouliangyu.lol.bean.MoreTopicDetailsBean;

/**
 * Created by zouliangyu on 16/5/21.
 */
public class MoreTopicDetailsAdapter extends BaseAdapter {
    private MoreTopicDetailsBean moreTopicDetailsBean;
    private Context context;

    public MoreTopicDetailsAdapter(Context context) {
        this.context = context;
    }

    public void setMoreTopicDetailsBean(MoreTopicDetailsBean moreTopicDetailsBean) {
        this.moreTopicDetailsBean = moreTopicDetailsBean;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return moreTopicDetailsBean == null ? 0 : moreTopicDetailsBean.getData().size();
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_more_topic_details, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.titleTv.setText(moreTopicDetailsBean.getData().get(position).getTitle());
        viewHolder.descTv.setText(moreTopicDetailsBean.getData().get(position).getDesc());


        return convertView;
    }

    class ViewHolder {
        TextView titleTv;
        TextView descTv;
        TextView timeTv;

        public ViewHolder(View itemView) {
            titleTv = (TextView) itemView.findViewById(R.id.item_more_topic_details_title_tv);
            descTv = (TextView) itemView.findViewById(R.id.item_more_topic_details_desc_tv);
            timeTv = (TextView) itemView.findViewById(R.id.item_more_topic_details_time_tv);


        }
    }
}
