package com.project.ydy.arouter.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.project.ydy.arouter.R;
import com.project.ydy.arouter.base.BaseActivity;
import com.project.ydy.arouter.bean.Person;
import com.project.ydy.arouter.constant.RoutePathConstant;

/**
 * @author ydy
 * 在支持路由的页面上添加注解(必须)
 * 这里的路径至少需要有两级，/xxx/xxx
 * 简单跳转：ARouter.getInstance().build(RoutePathConstant.ACTIVITY_SECOND).navigation();
 * 传值跳转：withString withInt withBoolean withParcelable等；
 * 跳转动画：withTransition(int enterAnim, int exitAnim)
 * Uri跳转：Uri uri = Uri.parse(RoutePathConstant.ACTIVITY_URI);
 * ARouter.getInstance().build(uri).navigation();
 * 回传跳转：navigation(context, 100)第二个参数为请求码
 */
@Route(path = RoutePathConstant.ACTIVITY_MAIN)
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Person person = new Person();
        person.setSex("男");
        person.setJob("Android");
        findViewById(R.id.tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance()
                        .build(RoutePathConstant.ACTIVITY_SECOND)
                        .withString("name", "ydy")
                        .withInt("age", 25)
                        .withBoolean("isStudent", false)
                        .withParcelable("test", person)
//                        .withTransition()
                        .navigation(MainActivity.this, 100);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 100:
                if (null != data) {
                    String name = data.getStringExtra("name");
                    Log.i("TAG", "onActivityResult: " + name);
                } else {
                    Log.i("TAG", "onActivityResult: 回传值");
                }
                break;
            default:
                break;
        }
    }
}
