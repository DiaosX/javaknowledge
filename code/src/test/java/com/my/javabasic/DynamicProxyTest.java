package com.my.javabasic;


import com.my.javabasic.dynamicproxy.Crud;
import com.my.javabasic.dynamicproxy.CrudInterceptorFilter;
import com.my.javabasic.dynamicproxy.CrudSelectInterceptor;
import com.my.javabasic.dynamicproxy.CrudUpdateInterceptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.CallbackFilter;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.NoOp;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DynamicProxyTest {

    @Test
    public void methodInterceptBasedRequiredFlag() {
        //代理生成器
        Enhancer enhancer = new Enhancer();
        //被代理对象
        Crud crud = new Crud();

        enhancer.setSuperclass(crud.getClass());
        CallbackFilter filter = new CrudInterceptorFilter();
        enhancer.setCallbackFilter(filter);

        Callback noOp = NoOp.INSTANCE;//(0)
        Callback selectInterceptor = new CrudSelectInterceptor(crud);//(1)
        Callback updateInterceptor = new CrudUpdateInterceptor(crud);//(2)
        enhancer.setCallbacks(new Callback[]{noOp, selectInterceptor, updateInterceptor});

        Crud crudProxy = (Crud) enhancer.create();
        crudProxy.select("select");
        crudProxy.update("update");
        crudProxy.insert();
    }
}
