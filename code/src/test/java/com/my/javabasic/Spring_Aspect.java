package com.my.javabasic;


import com.my.javabasic.spring.aop.annotationaspect.AnnotationSubject;
import com.my.javabasic.spring.aop.pointcutaspect.Subject;
import com.my.javabasic.spring.lifecycle.MyApplicationContextAware;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Spring_Aspect {

    @Test
    public void test_pointcut_aop_with_no_exception() {
        Subject myBean = (Subject) MyApplicationContextAware.getContext().getBean("subject");
        try {
            myBean.sayHello(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test_pointcut_aop_with_exception() {
        Subject myBean = (Subject) MyApplicationContextAware.getContext().getBean("subject");
        try {
            myBean.sayHello(true);
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }

    @Test
    public void test_annotation_aspect_with_exception() {
        AnnotationSubject myBean = (AnnotationSubject) MyApplicationContextAware.getContext().getBean("annotationSubject");
        try {
            String message = myBean.getHelloMessage(true);
            System.out.println("[test]返回结果=" + message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test_annotation_aspect_with_no_exception() {
        AnnotationSubject myBean = (AnnotationSubject) MyApplicationContextAware.getContext().getBean("annotationSubject");
        try {
            String message = myBean.getHelloMessage(false);
            System.out.println("[test]返回结果=" + message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
