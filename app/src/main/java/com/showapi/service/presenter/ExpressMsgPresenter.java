package com.showapi.service.presenter;

import android.content.Context;

import com.showapi.service.entity.ExpressMsg;
import com.showapi.service.manager.Manager;
import com.showapi.service.view.ExpressMsgView;
import com.showapi.service.view.View;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by song on 2017/3/1.
 * Email：815464927@qq.com
 */

public class ExpressMsgPresenter implements Presenter {
    private Context mContext;
    private Manager mManager;
    private CompositeSubscription mCompositeSubscription;
    private ExpressMsg mExpressMsg;
    private ExpressMsgView mExpressMsgView;

    public ExpressMsgPresenter(Context mContext) {
        this.mContext = mContext;
        onCreate();
    }

    @Override
    public void onCreate() {
        mManager = new Manager(mContext);
        mCompositeSubscription = new CompositeSubscription();
    }

    @Override
    public void attachView(View view) {
        mExpressMsgView = (ExpressMsgView) view;
    }

    @Override
    public void onStop() {
        if(mCompositeSubscription.hasSubscriptions()){
            mCompositeSubscription.unsubscribe();
        }
    }

    /**
     * 根据快递订单 和 快递公司查询--->物流信息
     * @param com 快递公司
     * @param nu 订单号
     */
    public void getExpressMsg(String com,String nu){
        mCompositeSubscription.add(mManager.getExpressMess(com,nu)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ExpressMsg>() {
                    @Override
                    public void onCompleted() {
                        if(mExpressMsg!=null){
                            mExpressMsgView.onSucess(mExpressMsg);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        mExpressMsgView.onError(e.toString().length()>0?e.toString():"error");
                    }

                    @Override
                    public void onNext(ExpressMsg expressMsg) {
                        mExpressMsg = expressMsg;
                    }
                })
        );
    }
}
