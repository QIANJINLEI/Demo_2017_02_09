package com.okhttp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ArrayList<String> list;
    private MyRecyclerView mRlv;
    private MyAdapter adapter;
    private int i ;
    private GridLayoutManager layouts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.cha).setOnClickListener(this);
        findViewById(R.id.add).setOnClickListener(this);
        findViewById(R.id.ins).setOnClickListener(this);
        findViewById(R.id.del).setOnClickListener(this);
        ListView listView = new ListView(this);
        listView.addHeaderView(new View(this));
        mRlv = (MyRecyclerView) findViewById(R.id.rlv);
        layouts = new GridLayoutManager(this,4,GridLayoutManager.VERTICAL,false);
        mRlv.setLayoutManager(layouts);
        list = new ArrayList<>();
        for (int i = 0; i <100; i++){
            list.add(i,"http://b.hiphotos.baidu.com/image/pic/item/0823dd54564e925838c205c89982d158ccbf4e26.jpg");
        }
        adapter = new MyAdapter(list);

        TextView view = new TextView(this);
        view.setText("addHeaderView");
        view.setTextSize(21);
        view.setGravity(Gravity.CENTER);
        mRlv.addHeaderView(view);
        mRlv.addFootView(view);
        mRlv.setAdapter(adapter);
        adapter.setOnonItemClick(new MyAdapter.OnClickListener() {
            @Override
            public void onItemClick(View view, int postion) {
                Log.e("qwe",postion+"");
            }
        });
        i = 0;
      /*  mRlv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });*/

/*        AlibcTradeSDK.asyncInit(this, new AlibcTradeInitCallback() {
            @Override
            public void onSuccess() {
                //初始化成功，设置相关的全局配置参数
                Log.e("qqq","onSuccess??");
                // ...

            }
            @Override
            public void onFailure(int code, String msg) {
                //初始化失败，可以根据code和msg判断失败原因，详情参见错误说明
                Log.e("qqq","onFailure??"+"code"+code+"+msg"+msg);
            }
        });*/
/*
        okhttp
        OkHttpClient okHttpClient = new OkHttpClient();

        Request.Builder builder = new Request.Builder();
        Request build = builder.url("http://blog.csdn.net/lmj623565791/article/details/47911083").build();

        Call call = okHttpClient.newCall(build);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.e("qwe", response.body().byteStream()+"");
                String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
                File file = new File(absolutePath,"/123.txt");
                Log.e("qwe", file.length()+"1111"+file);
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                byte[] bytes = new byte[1024 * 8];
                InputStream inputStream = response.body().byteStream();

                int c=-1;
                while((c=inputStream.read(bytes))!=-1){
                    for(int i=0;i<c;i++)
                        fileOutputStream.write(bytes[i]);
                }
                fileOutputStream.close();
                Log.e("qwe", file.length()+"22222");


            }
        });*/


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.add:
                list.add(0,"新数据"+ ++i);
                adapter.setList(list);
                adapter.notifyItemInserted(0);
                layouts.scrollToPosition(0);
                //添加
                break;
            case R.id.del:
                list.remove(0);
                adapter.setList(list);
                adapter.notifyItemRemoved(0);
                layouts.scrollToPosition(0);
                //删除
                break;
            case R.id.ins:
                //插入
                break;
            case R.id.cha:
                //跟新
                list.set(0,"跟新新数据"+ ++i);
                adapter.setList(list);
                adapter.notifyItemChanged(0);
                layouts.scrollToPosition(0);

                break;
        }
    }
}
