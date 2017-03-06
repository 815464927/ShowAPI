package com.showapi.service.presenter;

import android.content.Context;

import com.showapi.service.entity.Company;
import com.showapi.service.manager.Manager;
import com.showapi.service.view.CompanView;
import com.showapi.service.view.View;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by song on 2017/3/1.
 * Email：815464927@qq.com
 */

public class CompanyPresenter implements Presenter {
    private Context mContext;
    private Manager mManager;
    private CompositeSubscription mCompositeSubscription;
    private Company mCompany;
    private CompanView mCompanyView;

    public CompanyPresenter(Context mContext) {
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
        mCompanyView = (CompanView) view;
    }

    @Override
    public void onStop() {
        if(mCompositeSubscription.hasSubscriptions()){
            mCompositeSubscription.unsubscribe();
        }
    }

    /**
     * 根据订单号查询快递公司
     * @param nu 订单号
     */
    public void getCompany(String nu){
        mCompositeSubscription.add(mManager.getCompany(nu)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Company>() {
                    @Override
                    public void onCompleted() {
                        if(mCompany!=null){
                            mCompanyView.onSucess(mCompany);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        mCompanyView.onError(e.toString().length()>0?e.toString():"error");
                    }

                    @Override
                    public void onNext(Company company) {
                        mCompany = company;
                    }
                })
        );
    }
}
