package com.zouliangyu.lol.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.zouliangyu.lol.R;
import com.zouliangyu.lol.greendao.Article;
import java.util.List;

/**
 * Created by zouliangyu on 16/5/26.
 */
public class MyCollectDetailsAdapter extends BaseAdapter {
    private List<Article> articles;

    public void setArticles(List<Article> articles) {
        this.articles = articles;
        notifyDataSetChanged();
    }

    private Context context;


    public MyCollectDetailsAdapter(Context context) {
        this.context = context;
    }


    @Override
    public int getCount() {
        return articles == null ? 0 : articles.size();
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
        MyViewHolder myViewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_information, parent, false);
            myViewHolder = new MyViewHolder(convertView);
            convertView.setTag(myViewHolder);
        } else {
            myViewHolder = (MyViewHolder) convertView.getTag();
        }

        myViewHolder.title.setText(articles.get(position).getTitle());
        myViewHolder.desc.setText(articles.get(position).getDesc());
        myViewHolder.time.setText(articles.get(position).getTime());


        return convertView;
    }

    class MyViewHolder {
        TextView title;
        TextView desc;
        TextView time;

        public MyViewHolder(View itemView) {
            title = (TextView) itemView.findViewById(R.id.item_title_tv);
            desc = (TextView) itemView.findViewById(R.id.item_desc_tv);
            time = (TextView) itemView.findViewById(R.id.item_time_tv);

        }
    }
}
