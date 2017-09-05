package com.jiyun.com.newviewpager.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by dell on 2017/8/31.
 */

public class MyAdapter extends FragmentPagerAdapter {
    private ArrayList<String> strings;
    private ArrayList<Fragment> list;
    public MyAdapter(FragmentManager fm,ArrayList<String> strings,ArrayList<Fragment> list) {
        super(fm);
        this.strings=strings;
        this.list=list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return strings.get(position);
    }
}
