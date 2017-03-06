package com.showapi.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.showapi.R;
import com.showapi.service.entity.JokeText;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by song on 2017/2/23.
 * Email：815464927@qq.com
 */

public class JokeTextAdapter extends RecyclerView.Adapter<JokeTextAdapter.mViewHolder>{

    private LayoutInflater inflater;

    private ArrayList<JokeText.ShowapiResBodyBean.ContentlistBean> mList;
    public JokeTextAdapter (Context context,
                            ArrayList<JokeText.ShowapiResBodyBean.ContentlistBean> list){
        this.mList = list;
        inflater =LayoutInflater.from(context);
    }

    @Override
    public mViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mViewHolder view = new mViewHolder(inflater.inflate(R.layout.joke_text_item,parent,false));
        return view;
    }

    @Override
    public void onBindViewHolder(mViewHolder holder, int position) {
        JokeText.ShowapiResBodyBean.ContentlistBean item = mList.get(position);

        holder.title.setText(item.getTitle());
        String str = item.getText().replaceAll("<p>", "");
        String str2 = str.replaceAll("</p>","");
        String str3 = str2.replaceAll("&nbsp;","");
        String str4 = str3.replaceAll("<br />","");
        holder.text.setText(str4);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class mViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.tv_title) TextView title;
        @BindView(R.id.tv_text) TextView text;
        public mViewHolder(View view){
            super(view);
            ButterKnife.bind(this,view);
        }
    }
}
