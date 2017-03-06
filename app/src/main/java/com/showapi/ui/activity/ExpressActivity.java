package com.showapi.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.showapi.R;
import com.showapi.service.entity.Company;
import com.showapi.service.entity.ExpressMsg;
import com.showapi.service.presenter.CompanyPresenter;
import com.showapi.service.presenter.ExpressMsgPresenter;
import com.showapi.service.view.CompanView;
import com.showapi.service.view.ExpressMsgView;
import com.showapi.ui.adapter.ExpressMsgAdapter;
import com.showapi.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 快递查询
 */
public class ExpressActivity extends AppCompatActivity {

    @BindView(R.id.et_text) EditText et_text;
    @BindView(R.id.recycleview) RecyclerView mRecyclerVeiw;
    private CompanyPresenter mCompanyPresenter;
    private ExpressMsgPresenter mExpressPresenter;

    private ExpressMsgAdapter mAdapter;
    private ArrayList<ExpressMsg.ShowapiResBodyBean.DataBean> mData = new ArrayList<>();
    private String nu = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_express);
        initData();
    }

    private void initData() {
        ButterKnife.bind(this);

        mAdapter = new ExpressMsgAdapter(this,mData);
        LinearLayoutManager  layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayout.VERTICAL);
        mRecyclerVeiw.setLayoutManager(layoutManager);
        mRecyclerVeiw.setAdapter(mAdapter);

        mCompanyPresenter = new CompanyPresenter(this);
        mCompanyPresenter.attachView(new CompanView() {
            @Override
            public void onSucess(Company company) {
                if(company.getShowapi_res_body().getData()!=null
                        &&company.getShowapi_res_body().getData().size()>0) {
                    String com = company.getShowapi_res_body().getData().get(0);
                    if (!TextUtils.isEmpty(com) && com.length() > 0) {
                        mExpressPresenter.getExpressMsg(com, nu);
                    } else {
                        ToastUtils.showToast(ExpressActivity.this, "查不到该物流信息，请检查订单号是否正确");
                    }
                } else {
                    ToastUtils.showToast(ExpressActivity.this, "查不到该物流信息，请检查订单号是否正确");
                }
            }

            @Override
            public void onError(String result) {
                ToastUtils.showToast(ExpressActivity.this,"查不到该物流信息，请检查订单号是否正确");
            }
        });

        mExpressPresenter = new ExpressMsgPresenter(this);
        mExpressPresenter.attachView(new ExpressMsgView() {
            @Override
            public void onSucess(ExpressMsg expressMsg) {
                List<ExpressMsg.ShowapiResBodyBean.DataBean> data =
                        expressMsg.getShowapi_res_body().getData();
                if(data!=null&&data.size()>0) {
                    mData.clear();
                    for (int i = 0; i < data.size(); i++) {
                        mData.add(data.get(i));
                    }
                    mAdapter.notifyDataSetChanged();
                }else{
                    ToastUtils.showToast(ExpressActivity.this,"查不到该物流信息，请检查订单号是否正确");
                }
            }

            @Override
            public void onError(String result) {
                ToastUtils.showToast(ExpressActivity.this,"查不到该物流信息，请检查订单号是否正确");
            }
        });

    }

    @OnClick(R.id.btn_chack)
    void onClickChack(){
        nu = et_text.getText().toString().trim();
        if(TextUtils.isEmpty(nu)){
            ToastUtils.showToast(this,"请输入订单号");
        }else {
            mCompanyPresenter.getCompany(nu);

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mExpressPresenter!=null){
            mExpressPresenter.onStop();
        }
        if(mCompanyPresenter!=null){
            mCompanyPresenter.onStop();
        }
    }
}
