package com.mytablayout;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by wb-qjl256634 on 2017/2/15.
 */

public class MyPagerAdapter extends FragmentPagerAdapter {


    private  ArrayList<Fragment> mFragment;

    public MyPagerAdapter(FragmentManager fm, ArrayList<Fragment> mFragment) {

        super(fm);
        this.mFragment=mFragment;
    }

    @Override
    public Fragment getItem(int position) {
        if (mFragment!=null){
            return mFragment.get(position);
        }
        return null;
    }

    @Override
    public int getCount() {
        if (mFragment!=null){
            return mFragment.size();
        }
        return 0;
    }
}
