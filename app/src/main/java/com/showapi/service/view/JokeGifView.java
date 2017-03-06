package com.showapi.service.view;

import com.showapi.service.entity.JokeGif;

/**
 * Created by song on 2017/2/21.
 * Email：815464927@qq.com
 */

public interface JokeGifView extends View {
    void onSucess(JokeGif jokeGif);
    void onError(String result);
}