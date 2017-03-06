package com.showapi.service.presenter;

import android.content.Context;

import com.showapi.service.entity.JokeText;
import com.showapi.service.manager.Manager;
import com.showapi.service.view.JokeTextView;
import com.showapi.service.view.View;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by song on 2017/2/23.
 * Email：815464927@qq.com
 */

public class JokeTextPresenter implements Presenter {

    private Context mContext;
    private Manager manager;
    private CompositeSubscription mCompositeSubscription;
    private JokeText mJokeText;
    private JokeTextView mJokeTextView;

    public JokeTextPresenter(Context context) {
        this.mContext = context;
        onCreate();
    }

    @Override
    public void onCreate() {
        manager = new Manager(mContext);
        mCompositeSubscription = new CompositeSubscription();
    }

    @Override
    public void attachView(View view) {
        mJokeTextView = (JokeTextView) view;
    }

    @Override
    public void onStop() {
        if (mCompositeSubscription.hasSubscriptions()) {
            mCompositeSubscription.unsubscribe();
        }
    }

    /**
     * 获取搞笑文本
     * @param maxResult 返回的最大结果20，包括20
     * @param page 请求页码
     */
    public void getJokeText(int maxResult, int page) {
        mCompositeSubscription.add(manager.getJokeText(maxResult, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JokeText>() {
                    @Override
                    public void onCompleted() {
                        if (null != mJokeText) {
                            mJokeTextView.onSucess(mJokeText);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        mJokeTextView.onError(e.toString().length() > 0 ? e.toString() : "error");
                    }

                    @Override
                    public void onNext(JokeText jokeText) {
                        mJokeText = jokeText;
                    }
                })
        );
    }

}
