package com.showapi.service.presenter;

import android.content.Context;

import com.showapi.service.entity.JokeGif;
import com.showapi.service.manager.Manager;
import com.showapi.service.view.JokeGifView;
import com.showapi.service.view.View;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by song on 2017/2/20.
 * Email：815464927@qq.com
 */

public class JokeGifPresenter implements Presenter {

    private Context mContext;
    private Manager mManager;
    private CompositeSubscription mCompositeSubscription;
    private JokeGifView mJokeGifView;
    private JokeGif mJoke;

    public JokeGifPresenter(Context context){
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
        mJokeGifView = (JokeGifView) view;
    }

    @Override
    public void onStop() {
        if(mCompositeSubscription.hasSubscriptions()){
            mCompositeSubscription.unsubscribe();
        }
    }

    /**
     * 过去搞笑gif图片
     * @param maxResult 请求的最大返回结果
     * @param page 请求的页码
     *
     */
    public void getWeather(int maxResult, int page) {
        mCompositeSubscription.add(mManager.getJokeGif(maxResult,page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JokeGif>() {
                    @Override
                    public void onCompleted() {
                        if(null != mJoke){
                            mJokeGifView.onSucess(mJoke);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        mJokeGifView.onError(e.toString().length()>0?e.toString():"error");
                    }

                    @Override
                    public void onNext(JokeGif jokeGif) {
                        mJoke = jokeGif;
                    }
                })
        );
    }

}
