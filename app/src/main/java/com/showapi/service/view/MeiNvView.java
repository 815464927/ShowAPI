package com.showapi.service.view;

import com.showapi.service.entity.MeiNv;

/**
 * Created by song on 2017/2/28.
 * Email：815464927@qq.com
 */

public interface MeiNvView extends View{
    void onSucess(MeiNv meinv);
    void onError(String result);
}
