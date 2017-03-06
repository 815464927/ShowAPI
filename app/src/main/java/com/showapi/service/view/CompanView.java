package com.showapi.service.view;

import com.showapi.service.entity.Company;

/**
 * Created by song on 2017/3/1.
 * Email：815464927@qq.com
 */

public interface CompanView extends View{
    void onSucess(Company company);
    void onError(String result);
}
