package com.showapi.service.view;

import com.showapi.service.entity.JokePicture;

/**
 * Created by song on 2017/2/23.
 * Email：815464927@qq.com
 */

public interface JokePictureView extends View{
    void onSucess(JokePicture jokePicture);
    void onError(String result);
}
