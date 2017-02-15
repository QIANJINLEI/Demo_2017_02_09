package com.okhttp;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by wb-qjl256634 on 2017/2/15.
 */

public class MyRecyclerView extends RecyclerView {
    private Adapter mAdapter;

    public MyRecyclerView(Context context) {
        super(context);
    }
    ArrayList<View> mHeaderViews=new ArrayList<>();
    ArrayList<View> mFootViews=new ArrayList<>();

    public MyRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void addHeaderView(View view){
        mHeaderViews.clear();
        mHeaderViews.add(view);
        if (mAdapter!=null){
            if (!(mAdapter instanceof RecyclerViewWrapAdapter)) {
                mAdapter = new RecyclerViewWrapAdapter(mHeaderViews, mFootViews, mAdapter);
               // mAdapter.notifyDataSetChanged();
            }
        }

    }

    public void addFootView(View view){
        mFootViews.clear();
        mFootViews.add(view);
        if (mAdapter!=null){
            if (!(mAdapter instanceof RecyclerViewWrapAdapter)) {
                mAdapter = new RecyclerViewWrapAdapter(mHeaderViews, mFootViews, mAdapter);
               // mAdapter.notifyDataSetChanged();
            }
        }

    }

    @Override
    public void setAdapter(Adapter adapter) {
        if (mHeaderViews.isEmpty()&&mFootViews.isEmpty()){
            super.setAdapter(adapter);
        }else {
            adapter = new RecyclerViewWrapAdapter(mHeaderViews,mFootViews,adapter) ;
            super.setAdapter(adapter);
        }
        this.mAdapter=adapter;
    }
}
