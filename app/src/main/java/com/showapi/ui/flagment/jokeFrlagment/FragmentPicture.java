package com.showapi.ui.flagment.jokeFrlagment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.melnykov.fab.FloatingActionButton;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.animation.ValueAnimator;
import com.showapi.R;
import com.showapi.service.entity.JokePicture;
import com.showapi.service.presenter.JokePicturePresenter;
import com.showapi.service.view.JokePictureView;
import com.showapi.ui.adapter.JokePictureAdapter;
import com.showapi.ui.flagment.BaseFragment;
import com.showapi.ui.listener.OnRcvScrollListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by song on 2017/2/22.
 * Email：815464927@qq.com
 */

public class FragmentPicture extends BaseFragment {

    @BindView(R.id.recycleview) RecyclerView mRecyclerView;
    @BindView(R.id.swipe_refresh_layout) SwipeRefreshLayout mRefreshLayout;
    @BindView(R.id.fb) FloatingActionButton mFButton;
    private JokePicturePresenter presenter;
    private JokePictureAdapter adapter;
    private ArrayList<JokePicture.ShowapiResBodyBean.ContentlistBean> mList =
            new ArrayList<JokePicture.ShowapiResBodyBean.ContentlistBean>();

    //RecycleView是否正在刷新
    private boolean isRefreshing;
    private boolean isLoading;
    //属性动画
    private ObjectAnimator mAnimator;
    private int currentPage = 1;
    private int allPages = 0;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        adapter = new JokePictureAdapter(getActivity(),mList);

        presenter = new JokePicturePresenter(getActivity());
        presenter.attachView(new JokePictureView() {
            @Override
            public void onSucess(JokePicture jokePicture) {
                //Log.e("--->jokePicture",jokePicture.toString());

                currentPage = jokePicture.getShowapi_res_body().getCurrentPage();
                allPages = jokePicture.getShowapi_res_body().getAllPages();
                if (currentPage == 1) {
                    mList.clear();
                }
                List<JokePicture.ShowapiResBodyBean.ContentlistBean> entity
                        = jokePicture.getShowapi_res_body().getContentlist();
                for (int i=0;i<entity.size();i++){
                    mList.add(entity.get(i));
                }
                adapter.notifyDataSetChanged();
                //请求结束后处理
                mRefreshLayout.setRefreshing(false);
                isLoading = false;
                isRefreshing = false;
                //取消动画
                if (mAnimator != null)
                    mAnimator.cancel();
            }

            @Override
            public void onError(String result) {

            }
        });
    }

    @Override
    protected int getLayoutForId() {
        return R.layout.fragment_joke_pictrue;
    }

    private void initView() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(adapter);

        //设置下拉刷新
        mRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                isRefreshing = true;
                //网络请求
                presenter.getJokePicture(20, 1);
            }
        });
        //底部自动加载更多
        mRecyclerView.addOnScrollListener(new OnRcvScrollListener() {
            @Override
            public void onBottom() {
                super.onBottom();
                if (!isLoading) {
                    isLoading = true;
                    //网络请求
                    if (currentPage < allPages) {
                        ++currentPage;
                        presenter.getJokePicture(20, currentPage);
                    }
                }
            }
        });

        //设置浮点按钮绑定RecyclerView
        mFButton.attachToRecyclerView(mRecyclerView);
        //浮点按钮监听事件
        mFButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isRefreshing || isLoading)
                    return;
                mAnimator = ObjectAnimator.ofFloat(view, "rotation", 0F, 360F);
                mAnimator.setDuration(500);
                mAnimator.setInterpolator(new LinearInterpolator());
                mAnimator.setRepeatCount(ValueAnimator.INFINITE);
                mAnimator.setRepeatMode(ValueAnimator.RESTART);
                mAnimator.start();
                mRecyclerView.scrollToPosition(0);
                isRefreshing = true;
                //网络请求
                presenter.getJokePicture(20, 1);
            }
        });
    }
    @Override
    protected void loder() {
        initView();
        getData();
    }

    private void getData() {
        mRefreshLayout.setRefreshing(true);
        presenter.getJokePicture(20,1);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onStop();
    }
}
