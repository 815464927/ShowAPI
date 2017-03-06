package com.showapi.service.presenter;

import android.content.Context;

import com.showapi.service.entity.JokePicture;
import com.showapi.service.manager.Manager;
import com.showapi.service.view.JokePictureView;
import com.showapi.service.view.View;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by song on 2017/2/20.
 * Email：815464927@qq.com
 */

public class JokePicturePresenter implements Presenter {

    private Context mContext;
    private Manager mManager;
    private CompositeSubscription mCompositeSubscription;
    private JokePictureView mJokePictureView;
    private JokePicture mJokePicture;

    public JokePicturePresenter(Context context){
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
        mJokePictureView = (JokePictureView) view;
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
    public void getJokePicture(int maxResult, int page) {
        mCompositeSubscription.add(mManager.getJokePicture(maxResult,page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JokePicture>() {
                    @Override
                    public void onCompleted() {
                        if(null != mJokePicture){
                            mJokePictureView.onSucess(mJokePicture);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        mJokePictureView.onError(e.toString().length()>0?e.toString():"error");
                    }

                    @Override
                    public void onNext(JokePicture jokePicture) {
                        mJokePicture = jokePicture;
                    }
                })
        );
    }

}
