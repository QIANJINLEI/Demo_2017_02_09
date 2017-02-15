package com.mytablayout;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by wb-qjl256634 on 2017/2/15.
 */

public class Fragment2 extends BaseFragment {
    @Override
    void initData() {

    }

    @Override
    View initView(Context context) {
        TextView view = new TextView(context);
        view.setText(getClass().getSimpleName());
        view.setGravity(Gravity.CENTER);
        return view;
    }
}
