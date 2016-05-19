package com.zouliangyu.lol.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zouliangyu.lol.R;
import com.zouliangyu.lol.bean.InformationNewestBean;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zouliangyu on 16/5/10.
 */
public class InformationAdapter extends BaseAdapter {
    private InformationNewestBean informationNewestBeanList;
    private Context context;

    public InformationAdapter(Context context) {
        this.context = context;
    }

    public void setInformationNewestBeanList(InformationNewestBean informationNewestBeanList) {
        this.informationNewestBeanList = informationNewestBeanList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return informationNewestBeanList == null ? 0 : informationNewestBeanList.getData().size();
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_information, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.titleTv.setText(informationNewestBeanList.getData().get(position).getTitle());
        viewHolder.descTv.setText(informationNewestBeanList.getData().get(position).getDesc());


        Date date = new Date(informationNewestBeanList.getData().get(position).getPublished());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        String time = simpleDateFormat.format(date);
        viewHolder.timeTv.setText(time);

        return convertView;
    }

    class ViewHolder {
        TextView titleTv;
        TextView descTv;
        TextView timeTv;

        public ViewHolder(View itemView) {
            titleTv = (TextView) itemView.findViewById(R.id.item_title_tv);
            descTv = (TextView) itemView.findViewById(R.id.item_desc_tv);
            timeTv = (TextView) itemView.findViewById(R.id.item_time_tv);
        }
    }

}
