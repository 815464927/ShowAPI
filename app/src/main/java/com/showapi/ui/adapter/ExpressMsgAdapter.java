package com.showapi.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.showapi.R;
import com.showapi.service.entity.ExpressMsg;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by song on 2017/3/1.
 * Email：815464927@qq.com
 */

public class ExpressMsgAdapter extends RecyclerView.Adapter<ExpressMsgAdapter.ExpressItemViewHolder>{
    private Context mContext;
    private ArrayList<ExpressMsg.ShowapiResBodyBean.DataBean> mData;

    public ExpressMsgAdapter(Context mContext, ArrayList<ExpressMsg.ShowapiResBodyBean.DataBean> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public ExpressItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ExpressItemViewHolder view = new ExpressItemViewHolder(
                LayoutInflater.from(mContext).inflate(R.layout.express_item,parent,false));
        return view;
    }

    @Override
    public void onBindViewHolder(ExpressItemViewHolder holder, int position) {
        holder.time.setText(mData.get(position).getTime());
        holder.address.setText(mData.get(position).getContext());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class ExpressItemViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.tv_time) TextView time;
        @BindView(R.id.tv_address) TextView address;

        public ExpressItemViewHolder(View view){
            super(view);
            ButterKnife.bind(this,view);
        }
    }
}
