package com.showapi.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.showapi.R;
import com.showapi.ui.activity.ExpressActivity;
import com.showapi.ui.activity.JokeActivity;
import com.showapi.ui.activity.MeiNvActivity;
import com.showapi.ui.activity.WeatherActivity;

import java.util.ArrayList;

/**
 * Created by song on 2017/3/1.
 * Email：815464927@qq.com
 */

public class MainRecyclerAdapter extends RecyclerView.Adapter<MainRecyclerAdapter.ItemViewHolder> {

    private Context mContext;
    private ArrayList<String> mList;

    public MainRecyclerAdapter(Context mContext, ArrayList<String> mData) {
        this.mContext = mContext;
        this.mList = mData;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MainRecyclerAdapter.ItemViewHolder viwe = new MainRecyclerAdapter.ItemViewHolder(
                LayoutInflater.from(mContext).inflate(R.layout.main_item, parent, false));
        return viwe;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, final int position) {
        switch (position) {
            case 0://天气预报
                holder.image.setImageResource(R.drawable.wearther);
                holder.msg.setText(R.string.weather_mgs);
                break;
            case 1://笑话大全
                holder.image.setImageResource(R.drawable.joke);
                holder.msg.setText(R.string.joke_mgs);
                break;
            case 2://美女
                holder.image.setImageResource(R.drawable.meinv);
                holder.msg.setText(R.string.meinv_mgs);
                break;
            case 3://快递查询
                holder.image.setImageResource(R.drawable.express);
                holder.msg.setText(R.string.express_mgs);
                break;
        }
        holder.title.setText(mList.get(position));
        holder.main_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (position) {
                    case 0:
                        mContext.startActivity(new Intent(mContext, WeatherActivity.class));
                        break;
                    case 1:
                        mContext.startActivity(new Intent(mContext, JokeActivity.class));
                        break;
                    case 2:
                        mContext.startActivity(new Intent(mContext, MeiNvActivity.class));
                        break;
                    case 3:
                        mContext.startActivity(new Intent(mContext, ExpressActivity.class));
                        break;
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView title,msg;
        ImageView image;
        LinearLayout main_item;

        public ItemViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.tv_item_title);
            msg = (TextView) view.findViewById(R.id.tv_item_msg);
            image = (ImageView) view.findViewById(R.id.iv_image);
            main_item = (LinearLayout) view.findViewById(R.id.ll_main_item);
        }
    }

}
