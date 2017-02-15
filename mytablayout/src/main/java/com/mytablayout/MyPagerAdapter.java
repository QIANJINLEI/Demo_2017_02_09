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
    private String tabTitles[] = new String[]{"TAB1", "TAB2", "TAB3"};
    @Override
    public CharSequence getPageTitle(int position) {
        // 返回纯文字

        return tabTitles[position];

        // 返回ICON和文字
     /*   Drawable image = context.getResources().getDrawable(imageResId[position]);
        image.setBounds(0, 0, image.getIntrinsicWidth() * 2, image.getIntrinsicHeight() * 2);
        SpannableString sb = new SpannableString(tabTitles[position]);
        ImageSpan imageSpan = new ImageSpan(image, ImageSpan.ALIGN_BOTTOM);
        sb.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return sb;*/
    }
}
