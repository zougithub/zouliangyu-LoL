package com.zouliangyu.lol.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zouliangyu.lol.R;
import com.zouliangyu.lol.bean.HeroFreeFalseData;

import java.util.List;

/**
 * Created by zouliangyu on 16/5/16.
 */
public class HeroFreeAdapter extends RecyclerView.Adapter<HeroFreeAdapter.MyViewHolder> {
    private List<HeroFreeFalseData> heroFreeFalseDatas;
    private Context context;

    private MyItemClickListener mItemClickListener;


    public HeroFreeAdapter(Context context) {
        this.context = context;
    }

    public void setHeroFreeFalseDatas(List<HeroFreeFalseData> heroFreeFalseDatas) {
        this.heroFreeFalseDatas = heroFreeFalseDatas;
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
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.topIv.setImageResource(heroFreeFalseDatas.get(position).getTopIv());
        holder.name.setText(heroFreeFalseDatas.get(position).getName());
        holder.gold.setText(heroFreeFalseDatas.get(position).getGold());
        holder.coupon.setText(heroFreeFalseDatas.get(position).getCoupon());
    }

    @Override
    public int getItemCount() {
        return heroFreeFalseDatas == null ? 0 : heroFreeFalseDatas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView topIv;
        TextView name;
        TextView gold;
        TextView coupon;
        private MyItemClickListener mListener;

        public MyViewHolder(View itemView, MyItemClickListener listener) {
            super(itemView);
            topIv = (ImageView) itemView.findViewById(R.id.item_hero_free_topIv);
            name = (TextView) itemView.findViewById(R.id.item_hero_free_name);
            gold = (TextView) itemView.findViewById(R.id.item_hero_free_gold);
            coupon = (TextView) itemView.findViewById(R.id.item_hero_free_coupon);


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
