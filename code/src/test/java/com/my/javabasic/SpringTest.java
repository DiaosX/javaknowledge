package com.my.javabasic;


import com.my.javabasic.spring.MyApplicationContextAware;
import com.my.javabasic.spring.MyBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringTest {

    @Test
    public void testSpringLifeCycle() {
        MyBean myBean = (MyBean) MyApplicationContextAware.getContext().getBean("myBean");
        System.out.println(myBean.getName());
    }
}
