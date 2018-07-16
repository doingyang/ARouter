package com.project.ydy.arouter.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.project.ydy.arouter.R;
import com.project.ydy.arouter.base.BaseActivity;
import com.project.ydy.arouter.constant.RoutePathConstant;

/**
 * @author ydy
 * 如果希望有些路由不经过任何的拦截器，ARouter给出了一个绿色通道函数供我们使用
 * 使用greenChannel()时所有的Interceptor将失效
 * ARouter.getInstance().build(RoutePathConstant.ACTIVITY_INTERCEPTOR).greenChannel().navigation();
 */
@Route(path = RoutePathConstant.ACTIVITY_URI)
public class UriActivity extends BaseActivity {

    private static final String TAG = "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uri);
        findViewById(R.id.tv_uri).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance()
                        .build(RoutePathConstant.ACTIVITY_INTERCEPTOR, RoutePathConstant.GROUP_FIRST)
                        .navigation(UriActivity.this, new NavigationCallback() {
                            @Override
                            public void onFound(Postcard postcard) {
                                //路由目标被发现时调用
                                String group = postcard.getGroup();
                                String path = postcard.getPath();
                                Log.i(TAG, "onFound: group == "+group + "; path == "+path);
                            }

                            @Override
                            public void onLost(Postcard postcard) {
                                //路由被丢失时调用
                                Log.i(TAG, "onLost: ");
                            }

                            @Override
                            public void onArrival(Postcard postcard) {
                                //路由到达之后调用
                                String group = postcard.getGroup();
                                String path = postcard.getPath();
                                Log.i(TAG, "onArrival: group == "+group + "; path == "+path);
                            }

                            @Override
                            public void onInterrupt(Postcard postcard) {
                                //路由被拦截时调用
                                Log.i(TAG, "onInterrupt: ");
                            }
                        });
            }
        });
    }
}
