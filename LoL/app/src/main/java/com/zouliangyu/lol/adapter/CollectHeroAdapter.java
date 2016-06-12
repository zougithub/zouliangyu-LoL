package com.zouliangyu.lol.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
<<<<<<< HEAD
=======
import android.util.Log;
>>>>>>> 946912944adbc1def3419ef8318c7545267f0068
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
<<<<<<< HEAD
=======

>>>>>>> 946912944adbc1def3419ef8318c7545267f0068
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zouliangyu.lol.R;
import com.zouliangyu.lol.base.VolleySingle;
import com.zouliangyu.lol.bean.AllHeroImgBean;
import com.zouliangyu.lol.greendao.Hero;
<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;
=======

import java.util.ArrayList;
import java.util.List;

>>>>>>> 946912944adbc1def3419ef8318c7545267f0068
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
<<<<<<< HEAD
        // heros.get(position).getImageUrl() 是单个英雄图片集合的网址
=======


        // heros.get(position).getImageUrl() 是图片集合的网址
>>>>>>> 946912944adbc1def3419ef8318c7545267f0068
        // 获取第一张图片的网址
        VolleySingle.addRequest(heros.get(position).getImageUrl(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
<<<<<<< HEAD
//                Type type = (Type) new TypeToken<ArrayList<AllHeroImgBean>>() {
//                }.getType();

                // 单个英雄多张图片的集合
=======
>>>>>>> 946912944adbc1def3419ef8318c7545267f0068
                List<AllHeroImgBean> allHeroImgBeans = gson.fromJson(response,
                        new TypeToken<ArrayList<AllHeroImgBean>>() {
                        }.getType());

<<<<<<< HEAD

                Picasso.with(context).load(allHeroImgBeans.get(0).getSmallImg()).placeholder(R.mipmap.photo_default)
                        .error(R.mipmap.photo_default).into(holder.collectIv);
=======
                Picasso.with(context).load(allHeroImgBeans.get(0).getSmallImg()).placeholder(R.mipmap.ic_launcher)
                        .error(R.mipmap.ic_launcher).into(holder.collectIv);
>>>>>>> 946912944adbc1def3419ef8318c7545267f0068
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
<<<<<<< HEAD


=======
>>>>>>> 946912944adbc1def3419ef8318c7545267f0068
        holder.collectTv.setText(heros.get(position).getCode());
        holder.collectTv.setTextColor(Color.WHITE);

        // 如果接口对象那个不为空, 给item设置监听
        if (myItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
<<<<<<< HEAD
                    // getLayoutPosition 是获得当前第几条的位置
                    int pos = holder.getLayoutPosition();
                    // 调用接口对象的方法
=======
                    // getLayoutPosition
                    int pos = holder.getLayoutPosition();
                    //
>>>>>>> 946912944adbc1def3419ef8318c7545267f0068
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

<<<<<<< HEAD
=======

>>>>>>> 946912944adbc1def3419ef8318c7545267f0068
    // 内部接口
    public interface MyItemClickListener {
        void onItemClickListener(int position);
    }
}
