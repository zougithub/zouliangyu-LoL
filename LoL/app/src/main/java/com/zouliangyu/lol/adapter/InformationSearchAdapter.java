package com.zouliangyu.lol.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.zouliangyu.lol.R;
import com.zouliangyu.lol.bean.SearchBean;
import java.text.SimpleDateFormat;
import java.util.Date;
import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by zouliangyu on 16/6/8.
 */
public class InformationSearchAdapter extends BaseAdapter {
    private SearchBean searchBean;

    private Context context;

    public InformationSearchAdapter(Context context) {
        this.context = context;
    }

    public void setSearchBean(SearchBean searchBean) {
        this.searchBean = searchBean;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return searchBean == null ? 0 : searchBean.getData().size();
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_information_two, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        if (!searchBean.getData().get(position).getPic_url().isEmpty()) {
            Picasso.with(context).load(searchBean.getData().get(position).getPic_url()).placeholder(R.mipmap.photo_default)
                    .error(R.mipmap.photo_default).into(viewHolder.imageView);
        }
        viewHolder.titleTv.setText(searchBean.getData().get(position).getTitle());
        viewHolder.descTv.setText(searchBean.getData().get(position).getDesc());

        Date date = new Date(searchBean.getData().get(position).getPublished());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        String time = simpleDateFormat.format(date);
        viewHolder.timeTv.setText(time);

        return convertView;
    }

    class ViewHolder {
        ImageView imageView;
        TextView titleTv;
        TextView descTv;
        TextView timeTv;

        public ViewHolder(View itemView) {
            imageView = (ImageView) itemView.findViewById(R.id.item_information_iv);
            titleTv = (TextView) itemView.findViewById(R.id.item_information_title_tv);
            descTv = (TextView) itemView.findViewById(R.id.item_information_desc_tv);
            timeTv = (TextView) itemView.findViewById(R.id.item_information_time_tv);
        }
    }
}
