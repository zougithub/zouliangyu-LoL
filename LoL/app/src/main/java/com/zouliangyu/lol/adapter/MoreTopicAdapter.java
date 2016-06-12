package com.zouliangyu.lol.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zouliangyu.lol.R;
import com.zouliangyu.lol.bean.MoreTopicBean;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by zouliangyu on 16/5/21.
 */
public class MoreTopicAdapter extends BaseAdapter {
    private MoreTopicBean moreTopicBean;
    private Context context;

    public MoreTopicAdapter(Context context) {
        this.context = context;
    }

    public void setMoreTopicBean(MoreTopicBean moreTopicBean) {
        this.moreTopicBean = moreTopicBean;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return moreTopicBean == null ? 0 : moreTopicBean.getData().size();
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_more_topic, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.nameTv.setText(moreTopicBean.getData().get(position).getName());
        Picasso.with(context).load(moreTopicBean.getData().get(position).getPic_url()).
                placeholder(R.mipmap.photo_default).error(R.mipmap.photo_default).into(viewHolder.imageView);
        return convertView;
    }

    class ViewHolder {
        TextView nameTv;
        ImageView imageView;

        public ViewHolder(View itemView) {
            nameTv = (TextView) itemView.findViewById(R.id.item_more_topic_name_tv);
            imageView = (ImageView) itemView.findViewById(R.id.item_more_topic_iv);

        }
    }

}
