package com.showapi.service.presenter;

import com.showapi.service.view.View;

/**
 * Created by song on 2017/2/20.
 * Email：815464927@qq.com
 */

public interface Presenter {
    void onCreate();
    void attachView(View view);
    void onStop();
}
