package com.showapi.service.presenter;

import android.content.Context;

import com.showapi.service.entity.MeiNv;
import com.showapi.service.manager.Manager;
import com.showapi.service.view.MeiNvView;
import com.showapi.service.view.View;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by song on 2017/2/20.
 * Email：815464927@qq.com
 */

public class MeiNvPresenter implements Presenter {

    private Context mContext;
    private Manager mManager;
    private CompositeSubscription mCompositeSubscription;
    private MeiNvView mMeiNuView;
    private MeiNv mMeiNv;

    public MeiNvPresenter(Context context){
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
        mMeiNuView = (MeiNvView) view;
    }

    @Override
    public void onStop() {
        if(mCompositeSubscription.hasSubscriptions()){
            mCompositeSubscription.unsubscribe();
        }
    }

    public void getMeiNv(int page) {
        mCompositeSubscription.add(mManager.getMeiNv(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MeiNv>() {
                    @Override
                    public void onCompleted() {
                        if(null != mMeiNv){
                            mMeiNuView.onSucess(mMeiNv);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        mMeiNuView.onError(e.toString().length()>0?e.toString():"error");
                    }

                    @Override
                    public void onNext(MeiNv meinv) {
                        mMeiNv = meinv;
                    }
                })
        );
    }

}
