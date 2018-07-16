package com.project.ydy.arouter.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.project.ydy.arouter.R;
import com.project.ydy.arouter.base.BaseActivity;
import com.project.ydy.arouter.bean.Person;
import com.project.ydy.arouter.constant.RoutePathConstant;

/**
 * @author ydy
 * 使用@Autowired()注解接收传递值
 * 注：接收对象时，@Autowired(name = "test")
 * 需要写标签名name，并且与key一致（即name = "传对象时的key"），才可以获取到对象的值，否则结果为null
 * <p>
 * 为了规避可能会遇到的风险，建议在@Autowired()里面都写上与之对应具体的key名，key名不一致也会导致null
 */
@Route(path = RoutePathConstant.ACTIVITY_SECOND)
public class SecondActivity extends BaseActivity implements View.OnClickListener {

    @Autowired()
    String name;
    @Autowired()
    int age;
    @Autowired()
    boolean isStudent;
    @Autowired(name = "test")
    Person person;

    private TextView tvSecond;
    private TextView tvResult;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initView();
        setListener();
        Log.i("TAG", "name=" + name + ", age=" + age + ", isStudent=" + isStudent + ", Person=" + person);
        tvSecond.setText("name=" + name + ", age=" + age + ", isStudent=" + isStudent + ", Person=" + person.getJob());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_second:
                Uri uri = Uri.parse(RoutePathConstant.ACTIVITY_URI);
                ARouter.getInstance().build(uri).navigation();
                break;
            case R.id.tv_result:
                Intent intent = new Intent();
                intent.putExtra("name", "Your king is come back ！！！");
                setResult(1100, intent);
                finish();
                break;
            default:
                break;
        }
    }

    private void setListener() {
        tvSecond.setOnClickListener(this);
        tvResult.setOnClickListener(this);
    }

    private void initView() {
        tvSecond = (TextView) findViewById(R.id.tv_second);
        tvResult = (TextView) findViewById(R.id.tv_result);
    }
}
