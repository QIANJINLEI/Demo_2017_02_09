package com.okhttp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> list;
    private RecyclerView mRlv;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRlv = (RecyclerView) findViewById(R.id.rlv);
        RecyclerView.LayoutManager layouts =new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mRlv.setLayoutManager(layouts);
        list = new ArrayList<>();
        for (int i=0;i<100;i++){
            list.add(i,"http://b.hiphotos.baidu.com/image/pic/item/0823dd54564e925838c205c89982d158ccbf4e26.jpg");
        }
        adapter = new MyAdapter(list);
        mRlv.setAdapter(adapter);
        adapter.setOnonItemClick(new MyAdapter.OnClickListener() {
            @Override
            public void onItemClick(View view, int postion) {
                Log.e("qwe",postion+"");
            }
        });
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
}
