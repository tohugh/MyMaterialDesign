package com.hugh.TotalDemo.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.hugh.TotalDemo.R;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentFour extends Fragment {
    private MyAdapter myPagerAdapter;
    private List<ImageView> mData = new ArrayList<ImageView>();
    int [] images={R.drawable.cartoon,R.drawable.cat,R.drawable.ic_launcher};

    public FragmentFour() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
    }

    private void initData() {
        for (int i =0;i<images.length;i++){
            ImageView imageView = new ImageView(getActivity());
            imageView.setBackgroundResource(images[i]);
            mData.add(imageView);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = View.inflate(getActivity(), R.layout.layout_roll_view, null);
        ViewPager viewPager =(ViewPager)view.findViewById(R.id.vp);


        if (myPagerAdapter == null){
            myPagerAdapter = new MyAdapter();
        }
        viewPager.setAdapter(myPagerAdapter);
        return view;

    }

    class MyAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(mData.get(position));
            return mData.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }


}
