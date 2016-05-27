package com.zouliangyu.lol.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Type;
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
import com.zouliangyu.lol.bean.HeroFreeFalseData;

import java.util.List;

import it.sephiroth.android.library.picasso.MemoryPolicy;
import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by zouliangyu on 16/5/16.
 */
public class HeroFreeAdapter extends RecyclerView.Adapter<HeroFreeAdapter.MyViewHolder> {
    private AllHeroBean allHeroBean;
    private Context context;

    private MyItemClickListener mItemClickListener;


    public HeroFreeAdapter(Context context) {
        this.context = context;
    }

    public void setAllHeroBean(AllHeroBean allHeroBean) {
        this.allHeroBean = allHeroBean;
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_hero_free, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view, mItemClickListener);

        return myViewHolder;
    }

    public void setmItemClickListener(MyItemClickListener listener) {
        this.mItemClickListener = listener;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        String name = allHeroBean.getFree().get(position).getEnName();
        VolleySingle.addRequest("http://box.dwstatic.com/apiHeroSkin.php?hero=" + name + "&v=180&OSType=iOS9.3.1&versionName=3.0.1%20HTTP/1.1",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Gson gson = new Gson();
//                        Type type = (Type) new TypeToken<List<AllHeroImgBean>>(){}.getType();
                        List<AllHeroImgBean> allHeroImgBeans = gson.fromJson(response, new TypeToken<List<AllHeroImgBean>>() {
                        }.getType());

                        Picasso.with(context).load(allHeroImgBeans.get(0).getSmallImg()).placeholder(R.mipmap.ic_launcher)
                                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                                .config(Bitmap.Config.RGB_565)
                                .error(R.mipmap.ic_launcher).into(holder.topIv);

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });


        holder.name.setText(allHeroBean.getFree().get(position).getTitle());
//        holder.gold.setText(allHeroBean.getFree().get(position).getPrice().substring(0, 4));
//        holder.coupon.setText(allHeroBean.getFree().get(position).getPrice().substring(4, 7));
        holder.typeTv.setText(allHeroBean.getFree().get(position).getLocation());
    }

    @Override
    public int getItemCount() {
        return allHeroBean == null ? 0 : allHeroBean.getFree().size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView topIv;
        TextView name;
        //  TextView gold;
//        TextView coupon;
        TextView typeTv;
        private MyItemClickListener mListener;

        public MyViewHolder(View itemView, MyItemClickListener listener) {
            super(itemView);
            topIv = (ImageView) itemView.findViewById(R.id.item_hero_free_topIv);
            name = (TextView) itemView.findViewById(R.id.item_hero_free_name);
//            gold = (TextView) itemView.findViewById(R.id.item_hero_free_gold);
//            coupon = (TextView) itemView.findViewById(R.id.item_hero_free_coupon);
            typeTv = (TextView) itemView.findViewById(R.id.item_hero_free_type);


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
