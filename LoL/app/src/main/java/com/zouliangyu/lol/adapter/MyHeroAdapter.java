package com.zouliangyu.lol.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Type;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zouliangyu.lol.R;
import com.zouliangyu.lol.base.VolleySingle;
import com.zouliangyu.lol.bean.AllHeroImgBean;
import com.zouliangyu.lol.bean.MyHeroBean;

import java.util.List;

import it.sephiroth.android.library.picasso.MemoryPolicy;
import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by zouliangyu on 16/5/23.
 */
public class MyHeroAdapter extends BaseAdapter {
    private MyHeroBean myHeroBean;

    private Context context;

    public MyHeroAdapter(Context context) {
        this.context = context;
    }

    public void setMyHeroBean(MyHeroBean myHeroBean) {
        this.myHeroBean = myHeroBean;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return myHeroBean == null ? 0 : myHeroBean.getMyHeroes().size();
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
        MyViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_myhero, parent, false);
            viewHolder = new MyViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (MyViewHolder) convertView.getTag();
        }

        String name = myHeroBean.getMyHeroes().get(position).getEnName();
        final MyViewHolder finalViewHolder = viewHolder;
        VolleySingle.addRequest("http://box.dwstatic.com/apiHeroSkin.php?hero=" + name + "&v=180&OSType=iOS9.3.1&versionName=3.0.1%20HTTP/1.1",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Gson gson = new Gson();
                        List<AllHeroImgBean> allHeroImgBeans = gson.fromJson(response, new TypeToken<List<AllHeroImgBean>>() {
                        }.getType());

                        Picasso.with(context).load(allHeroImgBeans.get(0).getSmallImg()).placeholder(R.mipmap.photo_default)
                                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                                .config(Bitmap.Config.RGB_565)
                                .error(R.mipmap.photo_default).into(finalViewHolder.leftIv);

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        viewHolder.titleTv.setText(myHeroBean.getMyHeroes().get(position).getTitle());
        viewHolder.cnNameTv.setText(myHeroBean.getMyHeroes().get(position).getCnName());
        viewHolder.numTv.setText(myHeroBean.getMyHeroes().get(position).getPresentTimes());

        return convertView;
    }

    class MyViewHolder {
        ImageView leftIv;
        TextView titleTv;
        TextView cnNameTv;
        TextView numTv;

        public MyViewHolder(View itemView) {
            leftIv = (ImageView) itemView.findViewById(R.id.myhero_left_iv);
            titleTv = (TextView) itemView.findViewById(R.id.myhero_title_tv);
            cnNameTv = (TextView) itemView.findViewById(R.id.myhero_cnname_tv);
            numTv = (TextView) itemView.findViewById(R.id.myhero_num_tv);

        }
    }
}
