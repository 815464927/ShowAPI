package com.showapi.service.view;

import com.showapi.service.entity.WeatherDay;

/**
 * Created by song on 2017/2/21.
 * Email：815464927@qq.com
 */

public interface WeatherDayView extends View {
    void onSucess(WeatherDay weatherDay);
    void onError(String result);
}