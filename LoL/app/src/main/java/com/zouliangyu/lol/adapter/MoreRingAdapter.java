package com.zouliangyu.lol.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.zouliangyu.lol.R;
import com.zouliangyu.lol.bean.MoreRingBean;

/**
 * Created by zouliangyu on 16/5/20.
 */
public class MoreRingAdapter extends BaseAdapter {
    private MoreRingBean moreRingBean;
    private Context context;

    public MoreRingAdapter(Context context) {
        this.context = context;
    }

    public void setMoreRingBean(MoreRingBean moreRingBean) {
        this.moreRingBean = moreRingBean;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return moreRingBean == null ? 0 : moreRingBean.getData().size();
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_more_ring, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.textView.setText(moreRingBean.getData().get(position).getName());
        return convertView;
    }

    public class ViewHolder {
        TextView textView;
        ImageView imageView;

        public ViewHolder(View itemView) {
            textView = (TextView) itemView.findViewById(R.id.item_ring_tv);
            imageView = (ImageView) itemView.findViewById(R.id.item_ring_iv);


        }
    }
}
