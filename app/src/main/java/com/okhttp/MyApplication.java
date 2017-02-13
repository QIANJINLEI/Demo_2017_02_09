package com.okhttp;

import android.app.Application;

/**
 * Created by wb-qjl256634 on 2017/2/10.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
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


    }
}
