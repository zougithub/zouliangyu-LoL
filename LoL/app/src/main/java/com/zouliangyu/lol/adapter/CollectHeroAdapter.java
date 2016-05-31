package com.zouliangyu.lol.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zouliangyu.lol.R;
import com.zouliangyu.lol.base.VolleySingle;
import com.zouliangyu.lol.bean.AllHeroImgBean;
import com.zouliangyu.lol.greendao.Hero;

import java.util.ArrayList;
import java.util.List;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by zouliangyu on 16/5/29.
 */
public class CollectHeroAdapter extends RecyclerView.Adapter<CollectHeroAdapter.ViewHolder> {
    private List<Hero> heros;
    private Context context;
    private MyItemClickListener myItemClickListener; // 接口对象

    // 设置接口对象
    public void setMyItemClickListener(MyItemClickListener myItemClickListener) {
        this.myItemClickListener = myItemClickListener;
    }

    public CollectHeroAdapter(Context context) {
        this.context = context;
    }

    public void setHeros(List<Hero> heros) {
        this.heros = heros;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder viewHolder = null;
        View view = LayoutInflater.from(context).inflate(R.layout.item_collect_hero, parent, false);
        viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {


        // heros.get(position).getImageUrl() 是图片集合的网址
        // 获取第一张图片的网址
        VolleySingle.addRequest(heros.get(position).getImageUrl(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                List<AllHeroImgBean> allHeroImgBeans = gson.fromJson(response,
                        new TypeToken<ArrayList<AllHeroImgBean>>() {
                        }.getType());

                Picasso.with(context).load(allHeroImgBeans.get(0).getSmallImg()).placeholder(R.mipmap.ic_launcher)
                        .error(R.mipmap.ic_launcher).into(holder.collectIv);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        holder.collectTv.setText(heros.get(position).getCode());
        holder.collectTv.setTextColor(Color.WHITE);

        // 如果接口对象那个不为空, 给item设置监听
        if (myItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // getLayoutPosition
                    int pos = holder.getLayoutPosition();
                    //
                    myItemClickListener.onItemClickListener(pos);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return heros == null ? 0 : heros.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView collectIv;
        TextView collectTv;

        public ViewHolder(View itemView) {
            super(itemView);
            collectIv = (ImageView) itemView.findViewById(R.id.item_collect_hero_iv);
            collectTv = (TextView) itemView.findViewById(R.id.item_collect_hero_tv);
        }
    }


    // 内部接口
    public interface MyItemClickListener {
        void onItemClickListener(int position);
    }
}
