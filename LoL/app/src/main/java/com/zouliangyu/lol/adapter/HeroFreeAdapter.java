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

    // 接口对象
    private MyItemClickListener myItemClickListener;

    // 设置接口对象
    public void setMyItemClickListener(MyItemClickListener myItemClickListener) {
        this.myItemClickListener = myItemClickListener;
    }

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
        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
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

                        Picasso.with(context).load(allHeroImgBeans.get(0).getSmallImg()).placeholder(R.mipmap.photo_default)
                                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                                .config(Bitmap.Config.RGB_565)
                                .error(R.mipmap.photo_default).into(holder.topIv);

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });


        holder.name.setText(allHeroBean.getFree().get(position).getTitle());
        holder.typeTv.setText(allHeroBean.getFree().get(position).getLocation());

        // 如果接口对象不为空, 则开始对itemView设置监听
        if (myItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 当itemView被点击的时候 就会执行里面的代码
                    // getLayoutPosition 是获得当前是第几条数据
                    int pos = holder.getLayoutPosition();
                    // 调用接口对象的方法
                    myItemClickListener.onItemClickListener(pos);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return allHeroBean == null ? 0 : allHeroBean.getFree().size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView topIv;
        TextView name;
        TextView typeTv;


        public MyViewHolder(View itemView) {
            super(itemView);
            topIv = (ImageView) itemView.findViewById(R.id.item_hero_free_topIv);
            name = (TextView) itemView.findViewById(R.id.item_hero_free_name);
            typeTv = (TextView) itemView.findViewById(R.id.item_hero_free_type);

        }
    }

    // 内部接口
    public interface MyItemClickListener {
        void onItemClickListener(int position);
    }
}
