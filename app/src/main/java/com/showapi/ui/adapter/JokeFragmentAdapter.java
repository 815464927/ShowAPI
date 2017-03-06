package com.showapi.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.showapi.ui.flagment.jokeFrlagment.FragmentGifPicture;
import com.showapi.ui.flagment.jokeFrlagment.FragmentPicture;
import com.showapi.ui.flagment.jokeFrlagment.FragmentText;

/**
 * Created by song on 2017/2/22.
 * Email：815464927@qq.com
 */

public class JokeFragmentAdapter extends FragmentPagerAdapter {

    private Fragment[] fragments;

    public JokeFragmentAdapter(FragmentManager manager){
        super(manager);
        fragments = new Fragment[3];
    }

    @Override
    public Fragment getItem(int position) {
        if (fragments[position] == null) {
            switch (position) {
                case 0:
                    fragments[position] = new FragmentGifPicture();
                    break;
                case 1:
                    fragments[position] = new FragmentPicture();
                    break;
                case 2:
                    fragments[position] = new FragmentText();
                    break;
                default:
                    break;
            }
        }
        return fragments[position];
    }

    @Override
    public int getCount() {
        return fragments.length;
    }
}
