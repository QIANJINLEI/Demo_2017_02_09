package com.okhttp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by wb-qjl256634 on 2017/2/13.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    public void setList(ArrayList<String> list) {
        this.list = list;
    }

    private ArrayList<String> list = null;
    private OnClickListener onClickListener=null;

    public MyAdapter(ArrayList<String> list) {
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View view = View.inflate(parent.getContext(), R.layout.recyclerview_item, null);
        return new MyViewHolder(view, parent.getContext());
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        ImageView mIma = (ImageView) holder.itemView.findViewById(R.id.recyclerview_item_imageview);
        TextView mIv = (TextView) holder.itemView.findViewById(R.id.recyclerview_item_text);
        mIv.setText("这是第" + position + "条数据！"+list.get(position));
        Glide.with(holder.context).load(list.get(position)).into(mIma);
        mIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onClickListener!=null){
                    onClickListener.onItemClick(view,position);
                }
            }
        });



    }

    @Override
    public int getItemCount() {
        if (list != null) {
            return list.size();
        }
        return 0;
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        View itemView;
        Context context;

        public MyViewHolder(View itemView, Context context) {
            super(itemView);
            this.itemView = itemView;
            this.context = context;
        }
    }
    void setOnonItemClick(OnClickListener onClickListener){
        this.onClickListener=onClickListener;

    }
    public interface OnClickListener{
        void onItemClick(View view,int postion);
    }




}
