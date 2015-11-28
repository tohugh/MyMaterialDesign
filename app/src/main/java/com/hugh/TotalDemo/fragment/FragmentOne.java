package com.hugh.TotalDemo.fragment;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.hugh.TotalDemo.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentOne extends Fragment implements SwipeRefreshLayout.OnRefreshListener {


    private static final String ARG_PAGE = "ARG_PAGE";
    @InjectView(R.id.tv_test)
    TextView tvTest;
    @InjectView(R.id.srl)
    SwipeRefreshLayout srl;
    private Handler mhandler = new Handler();
    private int mPage;
    private ViewPager viewPager;



    public FragmentOne() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //mPage = getArguments().getInt(ARG_PAGE);


    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragmentone_srlyt, container, false);
        ButterKnife.inject(this, view);
        //tvTest.setText("fragment"+mPage);
        srl.setOnRefreshListener(this);
        //绑定刷新的颜色

        srl.setColorSchemeColors(
                getResources().getColor(R.color.colorPrimary),
                getResources().getColor(R.color.colorPrimaryDark),
                getResources().getColor(R.color.colorAccent),
                getResources().getColor(R.color.colorPrimary));

        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @Override
    public void onRefresh() {
        Toast.makeText(getActivity(), "onRefresh", Toast.LENGTH_SHORT).show();
        mhandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //隐藏进度条
                srl.setRefreshing(false);
            }
        },2000);
    }
}
