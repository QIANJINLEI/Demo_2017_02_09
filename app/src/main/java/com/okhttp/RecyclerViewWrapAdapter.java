package com.okhttp;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by wb-qjl256634 on 2017/2/15.
 */

public class RecyclerViewWrapAdapter extends RecyclerView.Adapter  {
    private ArrayList<View> mHeaderViews;
    private ArrayList<View> mFootViews;
    private final ArrayList<View> EMPTY_INFO_LIST = new ArrayList<>();
    private  RecyclerView.Adapter mAdapter;

    public RecyclerViewWrapAdapter(ArrayList<View> mHeaderViews, ArrayList<View> mFootViews, RecyclerView.Adapter mAdapter) {
        if (mHeaderViews == null) {
            this. mHeaderViews = EMPTY_INFO_LIST;
        } else {
            this.mHeaderViews = mHeaderViews;
        }
        if (mFootViews == null) {
            this.mFootViews = EMPTY_INFO_LIST;
        } else {
            this.mFootViews = mFootViews;
        }
        this.mAdapter = mAdapter;

    }
    public int getHeaderCount(){
        return mHeaderViews.size();
    }

    public int getFootCount() {
        return mHeaderViews.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType==RecyclerView.INVALID_TYPE){
            return  new HeaderViewHolder(mHeaderViews.get(0));
        }
        else if (viewType==RecyclerView.INVALID_TYPE -1){
            return  new HeaderViewHolder(mFootViews.get(0));
        }
        return mAdapter.onCreateViewHolder(parent,viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int numHeaders=getHeaderCount();
        if (position<numHeaders){
            return;
        }
        int adjPosition=position-numHeaders;
        int adapterCount=0;
        if (mAdapter!=null){
            adapterCount=mAdapter.getItemCount();
            if (adjPosition<adapterCount){
                mAdapter.onBindViewHolder(holder,adjPosition);
                return;
            }
        }
    }

    @Override
    public int getItemCount() {
        if (mAdapter!=null){
            return  getFootCount()+getHeaderCount()+mAdapter.getItemCount();
        }else{
            return getFootCount()+getHeaderCount();
        }
    }

    @Override
    public int getItemViewType(int position) {
        int mCurrentPosion = position;
        int numHeaders=getHeaderCount();
        if (position<numHeaders){
            return  RecyclerView.INVALID_TYPE;
        }
        int adjPosition = position-numHeaders;
        int adapterCount =0;
        if (mAdapter!=null){
            adapterCount =mAdapter.getItemCount();
            if (adjPosition<adapterCount){
                return mAdapter.getItemViewType(adjPosition);
            }
        }
        return RecyclerView.INVALID_TYPE-1;
    }

    @Override
    public long getItemId(int position) {
        int numHeaders = getHeaderCount();
        if (mAdapter!=null&&position>=numHeaders){
            int adjPosition =position-numHeaders;
            int adapterCount =mAdapter.getItemCount();
            if (adjPosition<adapterCount){
                return mAdapter.getItemId(adjPosition);
            }
        }
        return -1;
    }


    class HeaderViewHolder extends RecyclerView.ViewHolder{

        public HeaderViewHolder(View itemView) {
            super(itemView);
        }
    }
}
