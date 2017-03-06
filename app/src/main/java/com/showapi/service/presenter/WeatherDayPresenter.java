package com.showapi.service.presenter;

import android.content.Context;

import com.showapi.service.entity.WeatherDay;
import com.showapi.service.manager.Manager;
import com.showapi.service.view.View;
import com.showapi.service.view.WeatherDayView;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by song on 2017/2/20.
 * Email：815464927@qq.com
 */

public class WeatherDayPresenter implements Presenter {

    private Context mContext;
    private Manager mManager;
    private CompositeSubscription mCompositeSubscription;
    private WeatherDayView mWeatherDayVeiw;
    private WeatherDay mWeatherDay;

    public WeatherDayPresenter(Context context){
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
        mWeatherDayVeiw = (WeatherDayView) view;
    }

    @Override
    public void onStop() {
        if(mCompositeSubscription.hasSubscriptions()){
            mCompositeSubscription.unsubscribe();
        }
    }

    public void getWeather(String area) {
        mCompositeSubscription.add(mManager.getWeatherDay(area)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<WeatherDay>() {
                    @Override
                    public void onCompleted() {
                        if(null != mWeatherDay){
                            mWeatherDayVeiw.onSucess(mWeatherDay);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        mWeatherDayVeiw.onError(e.toString().length()>0?e.toString():"error");
                    }

                    @Override
                    public void onNext(WeatherDay weather) {
                        mWeatherDay = weather;
                    }
                })
        );
    }

}
