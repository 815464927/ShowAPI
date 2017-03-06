package com.showapi.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.showapi.R;
import com.showapi.service.entity.JokeGif;
import com.showapi.ui.activity.ImageActivity;
import com.showapi.utils.Consts;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by song on 2017/2/22.
 * Email：815464927@qq.com
 */

public class JokeGifAdapter extends RecyclerView.Adapter<JokeGifAdapter.mViewHolder>{

    private ArrayList<JokeGif.ShowapiResBodyBean.ContentlistBean>  mList;
    private Context mContext;
    private LayoutInflater inflater;

    public JokeGifAdapter(Context context, ArrayList<JokeGif.ShowapiResBodyBean.ContentlistBean> list){
        this.mContext = context;
        this.mList = list;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public mViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mViewHolder view = new mViewHolder(inflater.inflate(R.layout.joke_gif_item,parent,false));
        return view;
    }

    @Override
    public void onBindViewHolder(mViewHolder holder, int position) {
        JokeGif.ShowapiResBodyBean.ContentlistBean itme = mList.get(position);

        Glide.with(mContext).load(itme.getImg()).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(holder.iv);
        holder.title.setText(itme.getTitle());
        final String imageUrl = itme.getImg();
        //监听事件
        holder.iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, ImageActivity.class);
                intent.putExtra(Consts.BIG_IMAGE,imageUrl);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class mViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.tv_title) TextView title;
        @BindView(R.id.iv_iamge) ImageView iv;

        public mViewHolder(View view){
            super(view);
            ButterKnife.bind(this,view);
        }
    }

}
