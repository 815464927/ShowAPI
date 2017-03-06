package com.showapi.ui.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import com.showapi.R;
import com.showapi.service.entity.MeiNv;
import com.showapi.service.presenter.MeiNvPresenter;
import com.showapi.service.view.MeiNvView;
import com.showapi.ui.adapter.MeiNvAdapter;
import com.showapi.ui.listener.OnRcvScrollListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 美女图片
 */
public class MeiNvActivity extends AppCompatActivity {

    @BindView(R.id.recycleview) RecyclerView mRecyclerView;
    private MeiNvAdapter mAdapter;
    private ArrayList<MeiNv.ShowapiResBodyBean.NewslistBean> mData = new ArrayList<>();
    private MeiNvPresenter presenter;
    private GridLayoutManager mGridLayoutManager;
    private int page = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initWinow();
        setContentView(R.layout.activity_mei_nv);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        mGridLayoutManager = new GridLayoutManager(this,1);
        mAdapter = new MeiNvAdapter(this,mGridLayoutManager,mData);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(mGridLayoutManager);

        //底部加载更多
        mRecyclerView.addOnScrollListener(new OnRcvScrollListener(){
            @Override
            public void onBottom() {
                super.onBottom();
                presenter.getMeiNv(++page);
            }
        });

        presenter = new MeiNvPresenter(this);
        presenter.getMeiNv(1);
        presenter.attachView(new MeiNvView() {
            @Override
            public void onSucess(MeiNv meinv) {
                List<MeiNv.ShowapiResBodyBean.NewslistBean> entity
                        = meinv.getShowapi_res_body().getNewslist();
                for(int i=0;i<entity.size();i++){
                    mData.add(entity.get(i));
                }
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onError(String result) {

            }
        });
    }

    private void initWinow() {
        //KITKAT = 4.4
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);//透明状态栏
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.meinv_layout,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_switch_layout) {
            switchLayout();
            switchIcon(item);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void switchLayout() {
        switch (mGridLayoutManager.getSpanCount()) {
            case 1:
                mGridLayoutManager.setSpanCount(3);
                break;
            case 3:
                mGridLayoutManager.setSpanCount(1);
                break;
            default:
                mGridLayoutManager.setSpanCount(1);
                break;
        }
        mAdapter.notifyItemRangeChanged(0, mAdapter.getItemCount());
    }


    private void switchIcon(MenuItem item) {
        if (mGridLayoutManager.getSpanCount() == 3) {
            item.setIcon(getResources().getDrawable(R.drawable.ic_span_3));
        } else {
            item.setIcon(getResources().getDrawable(R.drawable.ic_span_1));
        }
    }

}
