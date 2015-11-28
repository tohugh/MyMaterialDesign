package com.hugh.TotalDemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hugh.TotalDemo.fragment.FragmentFour;
import com.hugh.TotalDemo.fragment.FragmentOne;
import com.hugh.TotalDemo.fragment.FragmentThree;
import com.hugh.TotalDemo.fragment.FragmentTwo;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends ActionBarActivity {

    @InjectView(R.id.imageview)
    ImageView imageview;
    @InjectView(R.id.textview)
    TextView textview;
    private LayoutInflater mInflater;
    private String mTextArray[] = {"我的", "你的", "他的", "谁的"};
    private Class fragmentArray[] = {FragmentOne.class, FragmentTwo.class, FragmentThree.class,
            FragmentFour.class};
    private FragmentTabHost mTabHost;
    private ImageView imageView;
    private Toolbar toolbar;
    private DrawerLayout drawer_layout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private int[] mDrawableArray = {R.drawable.labelone,R.drawable.labeltwo,R.drawable
            .lablethree,R.drawable.labelfour};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView photo = (ImageView) findViewById(R.id.photo);

        String path = "http://d.lanrentuku.com/down/png/1511/wsj2015/wsj2015-2.png";
        //String pathtest = "http://10.0.3.3:8080/oschina/images/uploads/user/2/4572_50" +
                //".jpg?t=1370685237000";
        //Picasso.with(this).load(pathtest).resize(100,100).centerCrop().into(photo);
        //picasso不能使用端口网址
        Glide.with(this).load(path).crossFade().centerCrop().into(photo);
        //加载fragmenttabhost
        initNavigationview();

        initView();

        //加载toolbar
        initToolbar();

        //加载tablayout
        //initTabLayout();
    }

    private void initNavigationview() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                drawer_layout.closeDrawers(); // 关闭导航菜单
                return true;
            }
        });
    }

    //加载tablayout



    /*
    *   初始化toolbar
    * */
    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        //支持toolbar
        setSupportActionBar(toolbar);


        //只有调用了这个方法才可以设置标题
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setTitle("TotalDemo");
        //给toolBar显示设置icon
        //toolbar.setNavigationIcon(R.drawable.navigation);

        getSupportActionBar().setHomeButtonEnabled(true); //设置左上角图标是否可以点击
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//给左上角图标的左边加上一个返回的图标 。
        //使左上角图标是否显示，如果设成false，则没有程序图标，仅仅就个标题，否则，显示应用程序图标，对应id为android.R.id.home，
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        drawer_layout = (DrawerLayout) findViewById(R.id.drawer_layout);
        //关联toolbar和drawerlayout
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawer_layout,
                toolbar, R.string.open, R.string.close);
        //设置drawerlayout的监听
        drawer_layout.setDrawerListener(drawerToggle);
        //不设置这个也可以实现效果，但是默认图标
        drawerToggle.syncState();

    }


    /*
    * 初始化fragmentTabhost
    * */
    private void initView() {
        //实例化布局对象,大布局
        mInflater = LayoutInflater.from(this);
        //实例化tabhost
        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        //关联tabhost和Framelayout
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
        for (int i = 0; i < mTextArray.length; i++) {
            //为每一个tab设置图标，文字
            //如果mTabHost.newTabSpec(mTextArray[i])不设置参数的话将无法切换tab
            TabHost.TabSpec tabSpec = mTabHost.newTabSpec(mTextArray[i]).setIndicator
                    (getTabItemView(i));
            //将tab按钮添加到tab选项卡
            mTabHost.addTab(tabSpec, fragmentArray[i], null);
            //设置背景颜色
            mTabHost.getTabWidget().getChildAt(i).setBackgroundColor(Color.WHITE);

        }
        //设置tabs之间的分隔线不显示
        mTabHost.getTabWidget().setShowDividers(LinearLayout.SHOW_DIVIDER_NONE);

    }

    private View getTabItemView(int i) {

        View view = mInflater.inflate(R.layout.tab_item_view, null);
        ButterKnife.inject(this, view);
        textview.setText(mTextArray[i]);
        imageview.setBackgroundResource(mDrawableArray[i]);
        return view;
    }
}
