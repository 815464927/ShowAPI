package com.showapi.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.showapi.R;
import com.showapi.service.entity.Weather;
import com.showapi.service.entity.WeatherDay;
import com.showapi.service.presenter.WeatherDayPresenter;
import com.showapi.service.presenter.WeatherPresenter;
import com.showapi.service.view.WeatherDayView;
import com.showapi.service.view.WeatherView;
import com.showapi.ui.adapter.WeatherAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 天气预报
 */
public class WeatherActivity extends AppCompatActivity {


    @BindView(R.id.tv_time) TextView time;
    @BindView(R.id.iv) ImageView iv;
    @BindView(R.id.tv_temperature) TextView temperature;
    @BindView(R.id.tv_weather) TextView weather;
    @BindView(R.id.tv_win_derection) TextView windDerection;
    @BindView(R.id.tv_wind_power) TextView windPower;
    @BindView(R.id.ll_item) LinearLayout ll_item;
    @BindView(R.id.tv_des) TextView Des_weather;
    @BindView(R.id.et_city) EditText city_name;
    @BindView(R.id.recycleview) RecyclerView mRecyclerView;

    private WeatherAdapter mAdapter;
    private ArrayList<Weather> mList;
    private WeatherPresenter mWeatherPpresenter;
    private WeatherDayPresenter mWeatherDayPpresenter;
    private String mArea = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        mWeatherPpresenter = new WeatherPresenter(this);
        mWeatherDayPpresenter = new WeatherDayPresenter(this);
        mList = new ArrayList<Weather>();
        mAdapter = new WeatherAdapter(this,mList);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mWeatherPpresenter.attachView(new WeatherView() {
            @Override
            public void onSucess(Weather weather) {
                mList.clear();
                mList.add(weather);
                Des_weather.setVisibility(View.VISIBLE);
                String des = mArea+getString(R.string.des_day);
                Des_weather.setText(des);
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onError(String result) {}
        });
        mWeatherDayPpresenter.attachView(new WeatherDayView() {
            @Override
            public void onSucess(WeatherDay weatherDay) {
                upDataWeatherDay(weatherDay);
            }

            @Override
            public void onError(String result) {
                Toast.makeText(WeatherActivity.this,"查询有误，请重试",Toast.LENGTH_SHORT).show();
            }
        });

        registerLisener();
    }



    private void registerLisener() {
        mAdapter.setOnItemClickListener(new WeatherAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(WeatherActivity.this,"不许乱点喔，左右滑滑就可以了-_-",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void upDataWeatherDay(WeatherDay weatherDay) {
        WeatherDay.ShowapiResBodyBean.HourListBean item =
                weatherDay.getShowapi_res_body().getHourList().get(0);
        ll_item.setVisibility(View.VISIBLE);
        iv.setVisibility(View.GONE);
        String mTime = item.getTime();
        StringBuffer sb = new StringBuffer();
        sb.append(mTime.substring(8,10)+":");
        sb.append(mTime.substring(10,12));
        mTime = mArea+"实时天气\n"+"更新时间  "+sb.toString();
        time.setText(mTime);
        String temper_now = item.getTemperature()+"°C";
        temperature.setText(temper_now);
        temperature.setTextSize(20);
        temperature.setTextColor(Color.BLUE);

        String mWeath = "天气： "+item.getWeather();
        weather.setText(mWeath);
        weather.setTextColor(Color.BLUE);
        String mDri = "风向： "+item.getWind_direction();
        windDerection.setText(mDri);
        windPower.setText(item.getWind_power());
    }

    @OnClick(R.id.btn_get)
    public void onButtonClick(){
        mArea = city_name.getText().toString();
        if(TextUtils.isEmpty(mArea)){
            Toast.makeText(this,"请输入需要查询的城市",Toast.LENGTH_SHORT).show();
            return;
        }
        mWeatherPpresenter.getWeather(mArea);
        mWeatherDayPpresenter.getWeather(mArea);
    }

    @Override
    protected void onDestroy() {
        mWeatherPpresenter.onStop();
        mWeatherDayPpresenter.onStop();
        super.onDestroy();
    }
}
