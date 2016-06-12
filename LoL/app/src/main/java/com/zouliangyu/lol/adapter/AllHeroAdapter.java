package com.zouliangyu.lol.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
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
import com.zouliangyu.lol.bean.AllHeroBean;
import com.zouliangyu.lol.bean.AllHeroImgBean;
<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;
=======
import com.zouliangyu.lol.bean.AllHeroTypeBean;

import java.util.ArrayList;
import java.util.List;

>>>>>>> 946912944adbc1def3419ef8318c7545267f0068
import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by zouliangyu on 16/5/23.
 * 所有英雄的
 */
public class AllHeroAdapter extends RecyclerView.Adapter<AllHeroAdapter.ViewHolder> {
    private Context context;
<<<<<<< HEAD
    private String enName;
=======
    private String name;
>>>>>>> 946912944adbc1def3419ef8318c7545267f0068
    private List<AllHeroBean.AllBean> allBeans;

    // 接口
    private MyItemClickListener myItemClickListener;

    // 设置接口对象
    public void setMyItemClickListener(MyItemClickListener myItemClickListener) {
        this.myItemClickListener = myItemClickListener;
    }

    public void setAllBeans(List<AllHeroBean.AllBean> allBeans) {
        this.allBeans = allBeans;
        notifyDataSetChanged();
    }


    public AllHeroAdapter(Context context) {
        this.context = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_hero_free, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        // 获取英雄的图片的集合的第一张
<<<<<<< HEAD
        enName = allBeans.get(position).getEnName();
        VolleySingle.addRequest("http://box.dwstatic.com/apiHeroSkin.php?hero=" + enName + "&v=180&OSType=iOS9.3.1&versionName=3.0.1%20HTTP/1.1",
=======
        name = allBeans.get(position).getEnName();
        VolleySingle.addRequest("http://box.dwstatic.com/apiHeroSkin.php?hero=" + name + "&v=180&OSType=iOS9.3.1&versionName=3.0.1%20HTTP/1.1",
>>>>>>> 946912944adbc1def3419ef8318c7545267f0068
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Gson gson = new Gson();
                        List<AllHeroImgBean> allHeroImgBeans = gson.fromJson(response, new TypeToken<ArrayList<AllHeroImgBean>>() {
                        }.getType());
<<<<<<< HEAD
                        // Bitmap.Config.RGB_565   图片压缩质量参数
=======
>>>>>>> 946912944adbc1def3419ef8318c7545267f0068
                        Picasso.with(context).load(allHeroImgBeans.get(0).getSmallImg())
                                .config(Bitmap.Config.RGB_565).placeholder(R.mipmap.photo_default).
                                error(R.mipmap.photo_default).into(holder.topIv);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                });

        holder.titleTv.setText(allBeans.get(position).getTitle());
        holder.typeTv.setText(allBeans.get(position).getLocation());
        holder.moneyTv.setText(allBeans.get(position).getPrice().substring(0, 4));

        // 如果接口对象不为空, 则开始对item设置监听
        if (myItemClickListener != null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // getLayoutPosition  是获得当前是第几条数据
                    int pos = holder.getLayoutPosition();
                    // 调用接口对象的方法
                    myItemClickListener.onItemClickListener(pos);
                }
            });
        }
    }


    @Override
    public int getItemCount() {
        return allBeans == null ? 0 : allBeans.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView topIv;
        TextView titleTv;
        TextView typeTv;
        TextView moneyTv;

        public ViewHolder(View itemView) {
            super(itemView);
            topIv = (ImageView) itemView.findViewById(R.id.item_hero_free_topIv);
            titleTv = (TextView) itemView.findViewById(R.id.item_hero_free_name);
            typeTv = (TextView) itemView.findViewById(R.id.item_hero_free_type);
            moneyTv = (TextView) itemView.findViewById(R.id.item_heto_free_money);


        }
<<<<<<< HEAD
=======


    }
>>>>>>> 946912944adbc1def3419ef8318c7545267f0068


    }

    // 内部接口
    public interface MyItemClickListener {
        void onItemClickListener(int position);
    }
}
