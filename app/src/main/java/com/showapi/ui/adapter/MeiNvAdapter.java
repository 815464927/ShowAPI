package com.showapi.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.showapi.R;
import com.showapi.service.entity.MeiNv;
import com.showapi.ui.activity.ImageActivity;
import com.showapi.utils.Consts;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by song on 2017/2/28.
 * Email：815464927@qq.com
 */

public class MeiNvAdapter extends RecyclerView.Adapter<MeiNvAdapter.MeiNvViewHolder>{

    private GridLayoutManager mLayoutManagert;
    private ArrayList<MeiNv.ShowapiResBodyBean.NewslistBean> mData;
    private Context mContext;

    public MeiNvAdapter(Context context,GridLayoutManager mLayoutManagert,
                        ArrayList<MeiNv.ShowapiResBodyBean.NewslistBean> mData) {
        this.mContext = context;
        this.mLayoutManagert = mLayoutManagert;
        this.mData = mData;
    }

    @Override
    public MeiNvViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MeiNvViewHolder(LayoutInflater
                .from(mContext).inflate(R.layout.meivn_item,parent,false));
    }

    @Override
    public void onBindViewHolder(MeiNvViewHolder holder, int position) {
        int spanCount = mLayoutManagert.getSpanCount();

        if (spanCount == 1) {
            holder.layoutBig.setVisibility(View.VISIBLE);
            holder.layoutSmall.setVisibility(View.GONE);
        } else {
            holder.layoutSmall.setVisibility(View.VISIBLE);
            holder.layoutBig.setVisibility(View.GONE);
        }

        final MeiNv.ShowapiResBodyBean.NewslistBean item = mData.get(position);
        holder.titleSmall.setText(item.getTitle());
        holder.titleBig.setText(item.getTitle());
        Glide.with(mContext).load(item.getPicUrl()).into(holder.ivSmall);
        Glide.with(mContext).load(item.getPicUrl()).into(holder.ivBig);
        holder.info.setText(item.getDescription());

        //监听事件
        holder.ivSmall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, ImageActivity.class);
                intent.putExtra(Consts.BIG_IMAGE, item.getPicUrl());
                mContext.startActivity(intent);
            }
        });
        holder.ivBig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, ImageActivity.class);
                intent.putExtra(Consts.BIG_IMAGE, item.getPicUrl());
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class MeiNvViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.layout_small) View layoutSmall;
        @BindView(R.id.image_small) ImageView ivSmall;
        @BindView(R.id.title_small) TextView titleSmall;
        @BindView(R.id.layout_big) View layoutBig;
        @BindView(R.id.image_big) ImageView ivBig;
        @BindView(R.id.title_big) TextView titleBig;
        @BindView(R.id.tv_info) TextView info;

        public MeiNvViewHolder(View view ){
            super(view);
            ButterKnife.bind(this,view);
        }
    }
}
