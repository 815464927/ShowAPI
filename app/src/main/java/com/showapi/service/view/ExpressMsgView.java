package com.showapi.service.view;

import com.showapi.service.entity.ExpressMsg;

/**
 * Created by song on 2017/3/1.
 * Email：815464927@qq.com
 */

public interface ExpressMsgView  extends View{
    void onSucess(ExpressMsg expressMsg);
    void onError(String result);
}
