package com.showapi.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.showapi.R;
import com.showapi.service.entity.Weather;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by song on 2017/2/21.
 * Email：815464927@qq.com
 */

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.mViewHolder>{

    private Context mContext;
    private ArrayList<Weather> mList;

    private OnItemClickListener onItemClickListener;

    public OnItemClickListener getOnItemClickListener() {
        return onItemClickListener;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener{
        void onClick(View view,int position);
    }

    public WeatherAdapter(Context context, ArrayList<Weather> list){
        this.mContext = context;
        this.mList = list;
    }

    @Override
    public mViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mViewHolder mViewHolder = new mViewHolder(
                LayoutInflater.from(mContext).inflate(R.layout.weather_item,null));
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(final mViewHolder holder, int position) {

        Weather.ShowapiResBodyBean.DayListBean item =
                mList.get(0).getShowapi_res_body().getDayList().get(position);

        String time = item.getDaytime();
        StringBuffer sb = new StringBuffer();
        sb.append(time.substring(4,6)+"月");
        sb.append(time.substring(6,8)+"日");
        time = sb.toString();
        holder.time.setText(time);
        Glide.with(mContext).load(item.getDay_weather_pic()).asBitmap().into(holder.iv);
        String temperature = item.getDay_air_temperature()+"~"+item.getNight_air_temperature()+"°C";
        holder.temperature.setText(temperature);
        holder.weather.setText(item.getDay_weather());
        holder.windDerection.setText(item.getDay_wind_direction());
        holder.windPower.setText(item.getDay_wind_power());

        //设置回调 监听事件
        if(onItemClickListener!=null){
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int pos = holder.getLayoutPosition();
                        onItemClickListener.onClick(view,pos);
                    }
                });
        }

    }

    @Override
    public int getItemCount() {
        return mList.size()<=0?0:mList.get(0).getShowapi_res_body().getDayList().size();
    }

    class mViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.tv_time) TextView time;
        @BindView(R.id.iv) ImageView iv;
        @BindView(R.id.tv_temperature) TextView temperature;
        @BindView(R.id.tv_weather) TextView weather;
        @BindView(R.id.tv_win_derection) TextView windDerection;
        @BindView(R.id.tv_wind_power) TextView windPower;

        public mViewHolder(View view){
            super(view);
            ButterKnife.bind(this,view);
        }
    }

}
