package com.showapi.ui.flagment.jokeFrlagment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.melnykov.fab.FloatingActionButton;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.animation.ValueAnimator;
import com.showapi.R;
import com.showapi.service.entity.JokeGif;
import com.showapi.service.presenter.JokeGifPresenter;
import com.showapi.service.view.JokeGifView;
import com.showapi.ui.adapter.JokeGifAdapter;
import com.showapi.ui.flagment.BaseFragment;
import com.showapi.ui.listener.OnRcvScrollListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by song on 2017/2/22.
 * Email：815464927@qq.com
 */

public class FragmentGifPicture extends BaseFragment {

    @BindView(R.id.recycleview) RecyclerView mRecyclerView;
    @BindView(R.id.swipe_refresh_layout) SwipeRefreshLayout mRefreshLayout;
    @BindView(R.id.fb) FloatingActionButton mFButton;
    private JokeGifPresenter presenter;
    private JokeGifAdapter mAdapter;
    private ArrayList<JokeGif.ShowapiResBodyBean.ContentlistBean> mList =
            new ArrayList<JokeGif.ShowapiResBodyBean.ContentlistBean>();

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
        mAdapter = new JokeGifAdapter(getActivity(), mList);

        presenter = new JokeGifPresenter(getActivity());
        presenter.attachView(new JokeGifView() {
            @Override
            public void onSucess(JokeGif jokeGif) {
                currentPage = jokeGif.getShowapi_res_body().getCurrentPage();
                allPages = jokeGif.getShowapi_res_body().getAllPages();
                Log.d("--->currentPage", currentPage + "");
                Log.d("--->allPages", allPages + "");
                if (currentPage == 1) {
                    mList.clear();
                }
                List<JokeGif.ShowapiResBodyBean.ContentlistBean> entity
                        = jokeGif.getShowapi_res_body().getContentlist();
                for (int i = 0;i<entity.size();i++){
                    mList.add(entity.get(i));
                }
                //Log.d("---> List size ", ""+mList.size());
                mAdapter.notifyDataSetChanged();
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
    protected void loder() {
        initView();
        getData();
    }

    private void initView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        //设置下拉刷新
        mRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                isRefreshing = true;
                //网络请求
                presenter.getWeather(20, 1);
            }
        });
        //底部自动加载更多
        mRecyclerView.addOnScrollListener(new OnRcvScrollListener() {
            @Override
            public void onBottom() {
                Log.d("--->", "底部加载更多======");
                super.onBottom();
                Log.d("--->", "底部加载更多");
                if (!isLoading) {
                    isLoading = true;
                    //网络请求
                    if (currentPage < allPages) {
                        ++currentPage;
                        presenter.getWeather(20, currentPage);
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
                presenter.getWeather(20, 1);
            }
        });
    }

    @Override
    protected int getLayoutForId() {
        return R.layout.fragment_joke_gifpictrue;
    }

    public void getData() {
        mRefreshLayout.setRefreshing(true);
        presenter.getWeather(20, 1);
    }

    @Override
    public void onDestroyView() {
        presenter.onStop();
        super.onDestroyView();
    }
}
