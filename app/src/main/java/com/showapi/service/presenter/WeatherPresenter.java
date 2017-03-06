package com.showapi.service.presenter;

import android.content.Context;

import com.showapi.service.entity.Weather;
import com.showapi.service.manager.Manager;
import com.showapi.service.view.View;
import com.showapi.service.view.WeatherView;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by song on 2017/2/20.
 * Email：815464927@qq.com
 */

public class WeatherPresenter implements Presenter {

    private Context mContext;
    private Manager mManager;
    private CompositeSubscription mCompositeSubscription;
    private WeatherView mWeatherVeiw;
    private Weather mWeather;

    public WeatherPresenter(Context context){
        this.mContext = context;
        onCreate();
    }

    @Override
    public void onCreate() {
        mManager = new Manager(mContext);
        mCompositeSubscription = new CompositeSubscription();
    }

    @Override
    public void attachView(View view) {
        mWeatherVeiw = (WeatherView) view;
    }

    @Override
    public void onStop() {
        if(mCompositeSubscription.hasSubscriptions()){
            mCompositeSubscription.unsubscribe();
        }
    }

    public void getWeather(String area) {
        mCompositeSubscription.add(mManager.getWeater(area)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Weather>() {
                    @Override
                    public void onCompleted() {
                        if(null != mWeather){
                            mWeatherVeiw.onSucess(mWeather);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        mWeatherVeiw.onError(e.toString().length()>0?e.toString():"error");
                    }

                    @Override
                    public void onNext(Weather weather) {
                        mWeather = weather;
                    }
                })
        );
    }

}
