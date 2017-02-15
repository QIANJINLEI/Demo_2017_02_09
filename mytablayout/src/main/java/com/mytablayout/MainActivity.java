package com.mytablayout;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTbl;
    private ViewPager mVp;
    private ArrayList<Fragment> mFragment = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTbl = (TabLayout) findViewById(R.id.tbl);
        mVp = (ViewPager) findViewById(R.id.vp);
        mFragment.add(new Fragment1());
        mFragment.add(new Fragment2());
        mFragment.add(new Fragment3());
        mVp.setAdapter(new MyPagerAdapter(getSupportFragmentManager(),mFragment));
        mTbl.setupWithViewPager(mVp);



    }
}
