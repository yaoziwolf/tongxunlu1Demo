package com.example.administrator.tongxunlu1demo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {

    private DrawerLayout mDrawerLayout;
    private ListView listView;
    private List<String> list;
    private List<Fragment> lists;
    private TextView tv_main;
    private oneFragment one;
    private twoFragment two;
    private threeFragment three;
    private fourFragment four;
    private ImageView imag;
    private ViewPager viewPager;
    private ImageView img1, img2, img3, img4;
    private TextView tv1, tv2, tv3, tv4;
    private LinearLayout lin1, lin2, lin3, lin4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化所有的碎片，并且放入到集合里。
        initListFragment();
        //在ListView抽屉中加载item，并且添加item的点击事件，每次点击后，自动关闭抽屉
        initAddDate();
        //关闭抽屉  mDrawerLayout.closeDrawer(listView);
        //初始化默认加载的碎片页面
        initDefaultFragment();
        initViewPager();
        //initBottom();

        initLinear();
        initView();
    }

    private void initAddDate() {
        imag = (ImageView) findViewById(R.id.imag);
        tv_main = (TextView) findViewById(R.id.tv_main);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        listView = (ListView) findViewById(R.id.listView);
        list = new ArrayList<String>();
        list.add("拨号");
        list.add("联系人");
        list.add("短信");
        list.add("通话记录");
        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    FragmentManager fm = getSupportFragmentManager();
                    FragmentTransaction fs = fm.beginTransaction();
                    Bundle bundle = new Bundle();
                    bundle.putString("title", list.get(i));
                    lists.get(i).setArguments(bundle);
//                    fs.replace(R.id.main_container, lists.get(i));
                    tv_main.setText(list.get(i));

                    fs.commit();

                mDrawerLayout.closeDrawer(listView);
            }
        });
        imag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawerLayout.openDrawer(listView);
            }
        });
    }

    private void initDefaultFragment() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fs = fm.beginTransaction();
        Bundle bundle = new Bundle();
        bundle.putString("title", list.get(0));
        lists.get(0).setArguments(bundle);
//        fs.add(R.id.main_container, one);
        fs.commit();
    }

    private void initListFragment() {
        one = new oneFragment();
        two = new twoFragment();
        three = new threeFragment();
        four = new fourFragment();

        lists = new ArrayList<>();
        lists.add(one);
        lists.add(two);
        lists.add(three);
        lists.add(four);

    }

    private void initLinear() {
        lin1 = (LinearLayout) findViewById(R.id.line_1);
        lin2 = (LinearLayout) findViewById(R.id.line_2);
        lin3 = (LinearLayout) findViewById(R.id.line_3);
        lin4 = (LinearLayout) findViewById(R.id.line_4);

        lin1.setOnClickListener(this);
        lin2.setOnClickListener(this);
        lin3.setOnClickListener(this);
        lin4.setOnClickListener(this);


    }

    private void initView() {
        img1.setImageResource(R.drawable.bohao1);
        tv1.setTextColor(getResources().getColor(R.color.colorAccent));

    }

//    private void initBottom() {
//        img1 = (ImageView) findViewById(R.id.image1);
//        img2 = (ImageView) findViewById(R.id.image2);
//        img3 = (ImageView) findViewById(R.id.image3);
//        img4 = (ImageView) findViewById(R.id.image4);
//
//        tv1 = (TextView) findViewById(R.id.text_x);
//        tv2 = (TextView) findViewById(R.id.text_l);
//        tv3 = (TextView) findViewById(R.id.text_f);
//        tv4 = (TextView) findViewById(R.id.text_m);
//
//    }

    private void initViewPager() {
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPagerAdapter adapter = new viewPagerAdapter(getSupportFragmentManager(),lists);
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        //clearAll();
        int nowSelect = viewPager.getCurrentItem();
        switch (nowSelect) {
            case 0:
                tv1.setTextColor(getResources().getColor(R.color.colorAccent));
                img1.setImageResource(R.drawable.bohao1);
                break;
            case 1:
                tv2.setTextColor(getResources().getColor(R.color.colorAccent));
                img2.setImageResource(R.drawable.lianxi1);
                break;
            case 2:
                tv3.setTextColor(getResources().getColor(R.color.colorAccent));
                img3.setImageResource(R.drawable.xinxi1);
                break;
            case 3:
                tv4.setTextColor(getResources().getColor(R.color.colorAccent));
                img4.setImageResource(R.drawable.jilu1);
                break;

        }
    }

//    private void clearAll() {
//        tv1.setTextColor(getResources().getColor(R.color.select_false));
//        img1.setImageResource(R.drawable.bohao);
//        tv2.setTextColor(getResources().getColor(R.color.select_false));
//        img2.setImageResource(R.drawable.lianxi);
//        tv3.setTextColor(getResources().getColor(R.color.select_false));
//        img3.setImageResource(R.drawable.xinxi);
//        tv4.setTextColor(getResources().getColor(R.color.select_false));
//        img4.setImageResource(R.drawable.jilu);
//
//    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.line_1:
                viewPager.setCurrentItem(0);
                tv_main.setText("拨号");
                break;
            case R.id.line_2:
                viewPager.setCurrentItem(1);
                tv_main.setText("联系人");
                break;
            case R.id.line_3:
                viewPager.setCurrentItem(2);
                tv_main.setText("短信");
                break;
            case R.id.line_4:
                viewPager.setCurrentItem(3);
                tv_main.setText("通话记录");
                break;

        }
    }

}
