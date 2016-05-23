package com.zouliangyu.lol.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zouliangyu.lol.R;
import com.zouliangyu.lol.bean.MoreNovelItemDetailsBean;

/**
 * Created by zouliangyu on 16/5/20.
 */
public class MoreNovelDetailsItemDetailsAdapter extends BaseAdapter {
    private MoreNovelItemDetailsBean moreNovelItemDetailsBean;
    private Context context;

    public MoreNovelDetailsItemDetailsAdapter(Context context) {
        this.context = context;
    }

    public void setMoreNovelItemDetailsBean(MoreNovelItemDetailsBean moreNovelItemDetailsBean) {
        this.moreNovelItemDetailsBean = moreNovelItemDetailsBean;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return moreNovelItemDetailsBean == null ? 0 : moreNovelItemDetailsBean.getData().size();
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_novel_details_item_details, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.titleTv.setText(moreNovelItemDetailsBean.getData().get(position).getTitle());
        viewHolder.descTv.setText(moreNovelItemDetailsBean.getData().get(position).getDesc());
        return convertView;
    }

    class ViewHolder {
        TextView titleTv;
        TextView descTv;

        public ViewHolder(View itemView) {

            titleTv = (TextView) itemView.findViewById(R.id.item_novel_details_item_details_title);
            descTv = (TextView) itemView.findViewById(R.id.item_novel_details_item_details_desc);


        }
    }
}
