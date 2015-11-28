package com.hugh.TotalDemo.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hugh.TotalDemo.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class InnerFragment extends Fragment {


    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPage;

    public static InnerFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        InnerFragment innerFragment = new InnerFragment();
        innerFragment.setArguments(args);
        return innerFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_innerfragment, container, false);
        TextView textView = (TextView) view;
        textView.setText("Fragment #" + mPage);
        return textView;
    }


}
