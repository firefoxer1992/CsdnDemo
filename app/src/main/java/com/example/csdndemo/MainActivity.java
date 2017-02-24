package com.example.csdndemo;

import java.util.ArrayList;
import java.util.List;

import com.astuetz.PagerSlidingTabStrip;


import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends FragmentActivity {
    private ViewPager mViewPager;
    private PagerSlidingTabStrip mTab;

    private LifeFragment lifeFragment;
    private DevelopFragment developFragment;
    private LanguageFragment languageFragment;

    private List<ItemInfoBean> itemList=new ArrayList<ItemInfoBean>();
    private String[] titles={"头条","博客","论坛","问答","我的"};
    private DrawerLayout drawer;
    private ListView drawerList;
    private ActionBarDrawerToggle drawerToggle;

    @SuppressLint("NewApi") @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData(itemList);
        //加载ViewPager和Tabs
        mViewPager=(ViewPager)findViewById(R.id.page);
        mViewPager.setAdapter(new myPagerAdapter(getSupportFragmentManager()) );
        mTab=(PagerSlidingTabStrip)findViewById(R.id.tabs);
        mTab.setViewPager(mViewPager);

        //加载抽屉布局
        drawer=(DrawerLayout)findViewById(R.id.drawer_layout);
        drawerList=(ListView)findViewById(R.id.left_drawer);
//      drawerList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, titles));
        drawerList.setAdapter(new InfoAdapter(this, R.layout.list_item, itemList));
        drawerList.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                // TODO Auto-generated method stub
                Toast.makeText(MainActivity.this, "You hava click list", Toast.LENGTH_SHORT).show();
//				Intent intent=new Intent(MainActivity.this,SecondActivity.class);
//				startActivity(intent);
            }
        });
        //注册并添加抽屉开关
        drawerToggle=new ActionBarDrawerToggle(this, drawer, R.drawable.ic_drawer, R.string.open_drawer, R.string.close_drawer){
            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                invalidateOptionsMenu();
            }

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu();   // creates call to onPrepareOptionsMenu()
            }

        };
        drawer.setDrawerListener(drawerToggle);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
    }

    //设置drawerLayout的开关图标.
    @Override
    protected void onPostCreate(Bundle savedInstanceState)
    {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        drawerToggle.syncState();
    }

    // 旋转屏幕,配置改变的时候，不必重新OnCreate()
    @Override
    public void onConfigurationChanged(Configuration newConfig)
    {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    //响应选项菜单
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //将选项菜单加入布局内
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    //初始化抽屉布局中ListView的内容
    public void initData(List<ItemInfoBean> list){
        list.add(new ItemInfoBean(R.drawable.head, titles[0]));
        list.add(new ItemInfoBean(R.drawable.blog,titles[1]));
        list.add(new ItemInfoBean(R.drawable.answer,titles[2]));
        list.add(new ItemInfoBean(R.drawable.forum,titles[3]));
        list.add(new ItemInfoBean(R.drawable.mine,titles[4]));

    }



    //PageView的适配器
    public class myPagerAdapter extends FragmentPagerAdapter{
        public myPagerAdapter(FragmentManager fm) {
            super(fm);
            // TODO Auto-generated constructor stub
        }

        private final String[] titles = {"程序人生","软件开发","编程语言"};

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
        @Override
        public int getCount() {
            return titles.length;
        }
        @Override
        public Fragment getItem(int position) {
            // TODO Auto-generated method stub
            switch (position) {
                case 0:
                    if(lifeFragment==null) {
                        lifeFragment= new LifeFragment();
                    }
                    return lifeFragment;
                case 1:
                    if(developFragment==null) {
                        developFragment= new DevelopFragment();
                    }
                    return developFragment;
                case 2:
                    if(languageFragment==null){
                        languageFragment=new LanguageFragment();
                    }
                    return languageFragment;
                default:
                    return null;
            }
        }

    }


}
