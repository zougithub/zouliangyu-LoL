package com.zouliangyu.lol.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zouliangyu.lol.R;
import com.zouliangyu.lol.bean.MoreNovelBean;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by zouliangyu on 16/5/20.
 */
public class MoreNovelAdapter extends BaseAdapter {
    private MoreNovelBean moreNovelBean;
    private Context context;

    public MoreNovelAdapter(Context context) {
        this.context = context;
    }

    public void setMoreNovelBean(MoreNovelBean moreNovelBean) {
        this.moreNovelBean = moreNovelBean;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return moreNovelBean == null ? 0 : moreNovelBean.getData().get(0).getCatword_id().size();
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_more_novel, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }


        Picasso.with(context).load(moreNovelBean.getData().get(0).getCatword_id().get(position).getPic_url()).
                placeholder(R.mipmap.photo_default).error(R.mipmap.photo_default).into(viewHolder.imageView);
        viewHolder.nameTv.setText(moreNovelBean.getData().get(0).getCatword_id().get(position).getName());
        viewHolder.descTv.setText(moreNovelBean.getData().get(0).getCatword_id().get(position).getDesc());

        return convertView;
    }

    class ViewHolder {
        ImageView imageView;
        TextView nameTv;
        TextView descTv;

        public ViewHolder(View itemView) {
            imageView = (ImageView) itemView.findViewById(R.id.novel_iv);
            nameTv = (TextView) itemView.findViewById(R.id.novel_name_tv);
            descTv = (TextView) itemView.findViewById(R.id.novel_desc_tv);


        }
    }
}
