package com.hugh.TotalDemo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.hugh.TotalDemo.fragment.InnerFragment;

/**
 * Created by hugh on 2015/11/24.
 */
public class MySimpleAdapter extends FragmentPagerAdapter {
    //private  Context context;
    private CharSequence[] tabTitles = {"你的","我的","他的"};

    public MySimpleAdapter(FragmentManager fm) {
        super(fm);
        //this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        return InnerFragment.newInstance(position + 1);
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return tabTitles[position];
    }
}
