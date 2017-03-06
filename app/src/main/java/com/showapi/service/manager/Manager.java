package com.showapi.service.manager;

import android.content.Context;

import com.showapi.api.API;
import com.showapi.service.ReterfitHelper;
import com.showapi.service.RetrofitService;
import com.showapi.service.entity.Company;
import com.showapi.service.entity.ExpressMsg;
import com.showapi.service.entity.JokeGif;
import com.showapi.service.entity.JokePicture;
import com.showapi.service.entity.JokeText;
import com.showapi.service.entity.MeiNv;
import com.showapi.service.entity.Weather;
import com.showapi.service.entity.WeatherDay;

import rx.Observable;

/**
 * Created by song on 2017/2/20.
 * Email：815464927@qq.com
 */

public class Manager {
    private RetrofitService mRetrofitService;
    public Manager(Context context){
        this.mRetrofitService = ReterfitHelper.getInstance(context).getService();
    }

    /**
     * 获取未来15天的天气
     * @param area 城市名称，如：深圳
     * @return Weather
     */
    public Observable<Weather> getWeater(String area){
        /** 第二个参数是城市的地区id：areaid可为空
         * 三个参数为showAPI注册的app_id
         * 第四个参数是时间
         * 第五个参数是在showAPI注册的App_KEY*/
        return mRetrofitService.getWeater(area, "", API.APP_ID,
                String.valueOf(System.currentTimeMillis()), API.APP_KEY);
    }

    /**
     * 获取24小时的天气
     * @param area 城市名称，如：深圳
     * @return WeatherDay
     */
    public Observable<WeatherDay> getWeatherDay(String area){
        /** 第二个参数是城市的地区id：areaid可为空
         * 三个参数为showAPI注册的app_id
         * 第四个参数是时间
         * 第五个参数是在showAPI注册的App_KEY*/
        return mRetrofitService.getWeatherDay(area, "", API.APP_ID,
                String.valueOf(System.currentTimeMillis()), API.APP_KEY);
    }

    /**
     * 获取搞笑gif图片
     * @param maxResult 最大返回的数量20以内（包括20）
     * @param page 请求的页码
     * @return JokeGif
     */
    public Observable<JokeGif> getJokeGif(int maxResult, int page){
        return mRetrofitService.getJokeGif(maxResult,page,API.APP_ID,
                String.valueOf(System.currentTimeMillis()), API.APP_KEY);
    }

    /**
     * 获取搞笑图片
     * @param maxResult 最大返回的数量20以内（包括20）
     * @param page 请求的页码e
     * @return JokePicture
     */
    public Observable<JokePicture> getJokePicture(int maxResult, int page){
        return mRetrofitService.getJokePicture(maxResult,page,API.APP_ID,
                String.valueOf(System.currentTimeMillis()),API.APP_KEY);
    }

    /**
     * 获取搞笑文本
     * @param maxResult 最大返回的数量20以内（包括20）
     * @param page 请求的页码e
     * @return JokePicture
     */
    public Observable<JokeText> getJokeText(int maxResult, int page){
        return mRetrofitService.getJokeText(maxResult,page,API.APP_ID,
                String.valueOf(System.currentTimeMillis()),API.APP_KEY);
    }

    /**
     * 获取美女图片
     * num 20 返回的条数
     * @param page 页码
     * rand 1 为随机返回
     * @return MeiNv
     */
    public Observable<MeiNv> getMeiNv(int page){
        return mRetrofitService.getMeiNv(20,page,1,API.APP_ID,
        String.valueOf(System.currentTimeMillis()),API.APP_KEY);
    }

    /**
     * 根据订单号查询快递公司
     * @param nu 订单号
     * @return Company
     */
    public Observable<Company> getCompany(String nu){
        return mRetrofitService.getCompanyFormOrder(nu,API.APP_ID,
                String.valueOf(System.currentTimeMillis()),API.APP_KEY);
    }

    /**
     * 根据快递订单 和 快递公司查询--->物流信息
     * @param com 快递公司
     * @param nu 订单号
     * @return ExpressMsg
     */
    public Observable<ExpressMsg> getExpressMess(String com,String nu){
        return mRetrofitService.getExpressMesg(com,nu,API.APP_ID,
                String.valueOf(System.currentTimeMillis()),API.APP_KEY);
    }

}
