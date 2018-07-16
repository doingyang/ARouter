package com.project.ydy.arouter.degrade;

import android.content.Context;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.service.DegradeService;
import com.alibaba.android.arouter.launcher.ARouter;
import com.project.ydy.arouter.constant.RoutePathConstant;

/**
 * **************************************************
 * 文件名称 : MyDegradeService
 * 作    者 : Created by ydy
 * 创建时间 : 2018/7/16 14:51
 * 文件描述 : 降级策略
 *            如果隐性的Intent不能匹配所有的Activity、或者不存在某个路由时，Activity就会报错，更坏的结果就是会导致崩溃
 *            我们可以集中处理这些错误，比如返回到主页面，也可以返回一个错误页面
 *            降级策略需要实现DegradeService接口，并且使用@Route注解来表明那些哪些路由需要被处理
 *            降级策略可以有多个
 *            这里@Route(path = "/user/*")表示只要是user级下的错误路由，都会传递到这里
 * 注意事项 :
 * 修改历史 : 2018/7/16 1.00 初始版本
 * **************************************************
 */
@Route(path = "/user/*")
public class MyDegradeService implements DegradeService {

    private Context context;

    @Override
    public void onLost(Context context, Postcard postcard) {
        //返回到主页面
        ARouter.getInstance().build(RoutePathConstant.ACTIVITY_MAIN).navigation();
    }

    @Override
    public void init(Context context) {
        this.context = context;
    }
}
