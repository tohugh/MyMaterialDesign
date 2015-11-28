package com.hugh.TotalDemo.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hugh.TotalDemo.R;
import com.hugh.TotalDemo.adapter.MySimpleAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentTwo extends Fragment {


    private TabLayout tabLayout;
    private MySimpleAdapter pagerAdapter;
    private ViewPager viewPager;

    public FragmentTwo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_tablayout, container, false);
        pagerAdapter = new MySimpleAdapter(getChildFragmentManager());
        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        viewPager.setAdapter(pagerAdapter);
        tabLayout = (TabLayout)view.findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        return view;
    }


}
