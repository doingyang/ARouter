package com.project.ydy.arouter.interceptor;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;

/**
 * **************************************************
 * 文件名称 : SecondInterceptor
 * 作    者 : Created by ydy
 * 创建时间 : 2018/7/16 11:23
 * 文件描述 :
 * 注意事项 :
 * 修改历史 : 2018/7/16 1.00 初始版本
 * **************************************************
 */
//@Interceptor(priority = 7)
//public class SecondInterceptor implements IInterceptor {
//    @Override
//    public void process(Postcard postcard, InterceptorCallback callback) {
//        Log.i("TAG", "SecondInterceptor 拦截器process: 线程名称：" + Thread.currentThread().getName());
//        callback.onContinue(postcard);
//    }
//
//    @Override
//    public void init(Context context) {
//        Log.i("TAG", "SecondInterceptor 拦截器init: ");
//    }
//}
