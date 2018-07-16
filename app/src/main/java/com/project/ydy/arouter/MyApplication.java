package com.project.ydy.arouter;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * **************************************************
 * 文件名称 : MyApplication
 * 作    者 : Created by ydy
 * 创建时间 : 2018/7/13 16:08
 * 文件描述 :
 * 注意事项 :
 * 修改历史 : 2018/7/13 1.00 初始版本
 * **************************************************
 */
public class MyApplication extends Application {

    //ARouter 调试开关
    private boolean isDebugARouter = true;

    @Override
    public void onCreate() {
        super.onCreate();
        if (isDebugARouter) {
            //下面两行必须写在init之前，否则这些配置在init过程中将无效
            // 打印日志
            ARouter.openLog();
            //开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
            ARouter.openDebug();
        }
        //官方建议推荐在Application中初始化
        ARouter.init(MyApplication.this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        ARouter.getInstance().destroy();
    }
}
