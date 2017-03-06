package com.showapi.service.view;


import com.showapi.service.entity.Weather;

/**
 * Created by song on 2017/2/20.
 * Email：815464927@qq.com
 */

public interface WeatherView extends View {
    void onSucess(Weather weather);
    void onError(String result);
}
