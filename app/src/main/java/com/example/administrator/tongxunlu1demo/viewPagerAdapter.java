package com.example.administrator.tongxunlu1demo;

/**
 * Created by Administrator on 2016/11/14.
 */
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016/8/16.
 */
public class viewPagerAdapter extends FragmentPagerAdapter {


    private List<Fragment> views;

    public viewPagerAdapter(FragmentManager fm,List<Fragment> views) {
        super(fm);
        this.views=views;
    }


    @Override
    public Fragment getItem(int position) {
        return views.get(position);
    }

    @Override
    public int getCount() {
        return views.size();
    }
}
