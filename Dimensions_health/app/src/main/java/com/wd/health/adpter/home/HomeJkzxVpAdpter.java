package com.wd.health.adpter.home;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/*
 *@Auther:陈浩
 *@Date: 2019/8/5
 *@Time:18:45
 *@Description:${DESCRIPTION}
 * */public class HomeJkzxVpAdpter extends FragmentPagerAdapter {
     private Context context;
     private  ArrayList<String> strings ;
     private ArrayList<Fragment> fragments;

    public HomeJkzxVpAdpter(FragmentManager fm, Context context, ArrayList<String> strings, ArrayList<Fragment> fragments) {
        super(fm);
        this.context = context;
        this.strings = strings;
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int i) {
        return fragments.get(i);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return strings.get(position);
    }

}
