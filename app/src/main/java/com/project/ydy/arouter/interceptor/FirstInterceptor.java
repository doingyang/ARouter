package com.project.ydy.arouter.interceptor;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.project.ydy.arouter.constant.RoutePathConstant;

/**
 * **************************************************
 * 文件名称 : FirstInterceptor
 * 作    者 : Created by ydy
 * 创建时间 : 2018/7/16 11:20
 * 文件描述 : ARouter的拦截器，是通过实现 IInterceptor接口，重写init()和process()方法去完成拦截器内部操作
 *            定义ARouter拦截器必须要使用Interceptor类注解，注解里面的priority是声明拦截器的优先级(int类型)
 *            priority数值越小，越先执行，优先级越高
 *            不同拦截器定义的优先级属性值不能相同(如果两个拦截器的优先级一样，项目编译会报错)
 *            callback.onContinue(postcard);决定继续往后执行，不做拦截！！！
 * 注意事项 :
 * 修改历史 : 2018/7/16 1.00 初始版本
 * **************************************************
 */
@Interceptor(priority = 4)
public class FirstInterceptor implements IInterceptor {
    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        if(postcard.getPath().equals(RoutePathConstant.ACTIVITY_INTERCEPTOR)) {
            Log.i("TAG", "FirstInterceptor 进行了拦截处理！");
        }
        boolean flag = true;
        if (flag) {
            //放行
            callback.onContinue(postcard);
        } else {
            //拦截
            callback.onInterrupt(null);
            // TODO: 2018/7/16 拦截后续处理！！！
        }
    }

    @Override
    public void init(Context context) {
        Log.i("TAG", "FirstInterceptor 拦截器init: ");
    }
}
