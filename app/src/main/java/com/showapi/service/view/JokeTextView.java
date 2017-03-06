package com.showapi.service.view;

import com.showapi.service.entity.JokeText;

/**
 * Created by song on 2017/2/23.
 * Email：815464927@qq.com
 */

public interface JokeTextView extends View{
    void onSucess(JokeText jokeText);
    void onError(String result);
}
