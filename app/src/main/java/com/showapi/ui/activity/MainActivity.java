package com.showapi.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;

import com.showapi.R;
import com.showapi.ui.adapter.MainRecyclerAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recycleview) RecyclerView mRecyclerView;
    @BindView(R.id.toolbar) Toolbar toolbar;
    private MainRecyclerAdapter mAdapter;
    private ArrayList<String> mData = new ArrayList<>();
    private String[] name = new String[]{"天气预报", "笑话大全", "美女图片","快递查询"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        setSupportActionBar(toolbar);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayout.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        for (int i = 0; i < name.length; i++) {
            mData.add(name[i]);
        }
        mAdapter = new MainRecyclerAdapter(this, mData);
        mRecyclerView.setAdapter(mAdapter);
    }

}
