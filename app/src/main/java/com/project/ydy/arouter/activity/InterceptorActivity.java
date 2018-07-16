package com.project.ydy.arouter.activity;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.project.ydy.arouter.R;
import com.project.ydy.arouter.base.BaseActivity;
import com.project.ydy.arouter.constant.RoutePathConstant;

/**
 * @author ydy
 * group = RoutePathConstant.GROUP_FIRST属于自定义分组
 * 在被跳转的界面@Route()方法中写明，同时跳转界面的build()方法中也需要写明
 */
@Route(path = RoutePathConstant.ACTIVITY_INTERCEPTOR, group = RoutePathConstant.GROUP_FIRST)
public class InterceptorActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interceptor);
    }
}
