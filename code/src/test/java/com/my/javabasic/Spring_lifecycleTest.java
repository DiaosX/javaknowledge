package com.my.javabasic;


import com.my.javabasic.spring.annotation.InjectByConstructor;
import com.my.javabasic.spring.annotation.InjectByField;
import com.my.javabasic.spring.annotation.InjectBySetter;
import com.my.javabasic.spring.aop.Subject;
import com.my.javabasic.spring.lifecycle.MyApplicationContextAware;
import com.my.javabasic.spring.lifecycle.MyBean;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Spring_lifecycleTest {

    @Test
    public void testSpringLifeCycle() {
        MyBean myBean = (MyBean) MyApplicationContextAware.getContext().getBean("myBean");
        System.out.println(myBean.getName());
    }


    @Test
    public void testSpringInjectType() {
        InjectByConstructor ctorBean = (InjectByConstructor) MyApplicationContextAware.getContext().getBean("injectByConstructor");
        InjectByField propBean = (InjectByField) MyApplicationContextAware.getContext().getBean("injectByField");
        InjectBySetter setterBean = (InjectBySetter) MyApplicationContextAware.getContext().getBean("injectBySetter");

        Assert.assertNotNull("InjectByConstructor的对象不能为空", ctorBean);
        Assert.assertNotNull("InjectByField的对象不能为空", propBean);
        Assert.assertNotNull("InjectBySetter的对象不能为空", setterBean);

        System.out.println(ctorBean.toString());
        System.out.println(propBean.toString());
        System.out.println(setterBean.toString());
    }


    @Test
    public void testAopWithNoException() {
        Subject myBean = (Subject) MyApplicationContextAware.getContext().getBean("subject");
        try {
            myBean.sayHello(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAopWithException() {
        Subject myBean = (Subject) MyApplicationContextAware.getContext().getBean("subject");
        try {
            myBean.sayHello(true);
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }

}
