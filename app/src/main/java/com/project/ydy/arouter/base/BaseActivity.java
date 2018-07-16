package com.project.ydy.arouter.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * **************************************************
 * 文件名称 : BaseActivity
 * 作    者 : Created by ydy
 * 创建时间 : 2018/7/16 9:58
 * 文件描述 :
 * 注意事项 :
 * 修改历史 : 2018/7/16 1.00 初始版本
 * **************************************************
 */
public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //ARouter inject注入
        ARouter.getInstance().inject(this);
    }

}
