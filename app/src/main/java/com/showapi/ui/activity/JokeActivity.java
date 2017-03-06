package com.showapi.ui.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import android.view.WindowManager;

import com.flyco.tablayout.SlidingTabLayout;
import com.showapi.R;
import com.showapi.ui.adapter.JokeFragmentAdapter;

/**
 * 搞笑大全
 */
public class JokeActivity extends AppCompatActivity {

    private Toolbar mToolBar;
    private SlidingTabLayout mSlidingTab;
    private ViewPager mViewPager;
    private JokeFragmentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initWinow();
        setContentView(R.layout.activity_joke);
        initView();
    }

    private void initWinow() {
        //KITKAT = 4.4
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);//透明状态栏
        }

    }

    private void initView() {
        mToolBar = (Toolbar) findViewById(R.id.nav_toolbar);
        mSlidingTab = (SlidingTabLayout) findViewById(R.id.nav_tablayout);
        mViewPager = (ViewPager) findViewById(R.id.nav_viewpager);

        setSupportActionBar(mToolBar);
        adapter = new JokeFragmentAdapter(getSupportFragmentManager());
        mViewPager.setOffscreenPageLimit(3);
        mViewPager.setAdapter(adapter);
        mSlidingTab.setViewPager(mViewPager,new String[]{"动态搞笑图","搞笑图","搞笑文本"});
    }

}
