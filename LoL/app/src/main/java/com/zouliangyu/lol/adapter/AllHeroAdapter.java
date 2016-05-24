package com.zouliangyu.lol.adapter;

import android.content.Context;
import android.graphics.Bitmap;
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
import com.zouliangyu.lol.bean.AllHeroBean;
import com.zouliangyu.lol.bean.AllHeroImgBean;
import java.util.ArrayList;
import java.util.List;
import it.sephiroth.android.library.picasso.MemoryPolicy;
import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by zouliangyu on 16/5/23.
 * 所有英雄的
 */
public class AllHeroAdapter extends RecyclerView.Adapter<AllHeroAdapter.ViewHolder> {
    private AllHeroBean allHeroBean;
    private Context context;
    private MyItemClickListener myItemClickListener;

    public void setMyItemClickListener(MyItemClickListener listener) {
        this.myItemClickListener = listener;
    }

    public AllHeroAdapter(Context context) {
        this.context = context;
    }


    public void setAllHeroBean(AllHeroBean allHeroBean) {
        this.allHeroBean = allHeroBean;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_hero_free, parent, false);
        ViewHolder viewHolder = new ViewHolder(view, myItemClickListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        String name1 = allHeroBean.getAll().get(position).getEnName();
        VolleySingle.addRequest("http://box.dwstatic.com/apiHeroSkin.php?hero=" + name1 + "&v=180&OSType=iOS9.3.1&versionName=3.0.1%20HTTP/1.1",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Gson gson = new Gson();
                        List<AllHeroImgBean> allHeroImgBeans = gson.fromJson(response, new TypeToken<ArrayList<AllHeroImgBean>>() {
                        }.getType());


                        Picasso.with(context).load(allHeroImgBeans.get(0).getSmallImg())
                                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                                .config(Bitmap.Config.RGB_565).placeholder(R.mipmap.ic_launcher).
                                error(R.mipmap.ic_launcher).into(holder.topIv);


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });


        holder.titleTv.setText(allHeroBean.getAll().get(position).getTitle());
        holder.goldTv.setText(allHeroBean.getAll().get(position).getPrice().substring(0, 4));
        holder.couponTv.setText(allHeroBean.getAll().get(position).getPrice().substring(5, 8));
    }

    @Override
    public int getItemCount() {
        return allHeroBean == null ? 0 : allHeroBean.getAll().size();
    }



    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView topIv;
        TextView titleTv;
        TextView goldTv;
        TextView couponTv;
        private MyItemClickListener mListener;

        public ViewHolder(View itemView, MyItemClickListener listener) {
            super(itemView);
            topIv = (ImageView) itemView.findViewById(R.id.item_hero_free_topIv);
            titleTv = (TextView) itemView.findViewById(R.id.item_hero_free_name);
            goldTv = (TextView) itemView.findViewById(R.id.item_hero_free_gold);
            couponTv = (TextView) itemView.findViewById(R.id.item_hero_free_coupon);
            this.mListener = listener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mListener != null) {
                mListener.onItemClickListener(v, getPosition());
            }

        }
    }


    public interface MyItemClickListener {
        void onItemClickListener(View view, int position);
    }
}
