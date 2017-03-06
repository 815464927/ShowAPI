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
import com.showapi.service.entity.JokePicture;
import com.showapi.ui.activity.ImageActivity;
import com.showapi.utils.Consts;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by song on 2017/2/23.
 * Email：815464927@qq.com
 */

public class JokePictureAdapter extends RecyclerView.Adapter<JokePictureAdapter.mViewholder>{

    private ArrayList<JokePicture.ShowapiResBodyBean.ContentlistBean> mList;
    private Context mContext;
    private LayoutInflater inflater;

    public JokePictureAdapter (Context context ,
                               ArrayList<JokePicture.ShowapiResBodyBean.ContentlistBean> list){
        this.mContext = context;
        this.mList = list;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public mViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        mViewholder view = new mViewholder(inflater.inflate(R.layout.joke_gif_item,parent,false));
        return view;
    }

    @Override
    public void onBindViewHolder(mViewholder holder, int position) {
        JokePicture.ShowapiResBodyBean.ContentlistBean itme = mList.get(position);

        holder.title.setText(itme.getTitle());
        Glide.with(mContext).load(itme.getImg()).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(holder.iv);
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

    class mViewholder extends RecyclerView.ViewHolder{

        @BindView(R.id.tv_title) TextView title;
        @BindView(R.id.iv_iamge) ImageView iv;

        public mViewholder(View view){
            super(view);
            ButterKnife.bind(this,view);
        }
    }
}
