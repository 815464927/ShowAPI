package com.showapi.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.showapi.R;
import com.showapi.ui.widige.ZoomImageView;
import com.showapi.utils.Consts;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 图片
 */
public class ImageActivity extends AppCompatActivity {

    @BindView(R.id.iv_fullscreen) ZoomImageView iv;

    private String imgeUrl = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        imgeUrl = getIntent().getStringExtra(Consts.BIG_IMAGE);
        Glide.with(this).load(imgeUrl).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(iv);
    }

}
