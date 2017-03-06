package com.showapi.ui.flagment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by song on 2017/2/22.
 * Email：815464927@qq.com
 */

public abstract class BaseFragment extends Fragment{

    private View view = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        if(null == view) {
            view = inflater.inflate(getLayoutForId(), container, false);
            ButterKnife.bind(this,view);
            loder();
        }

        return view;
    }
    protected abstract int getLayoutForId();
    protected abstract void loder();
}
