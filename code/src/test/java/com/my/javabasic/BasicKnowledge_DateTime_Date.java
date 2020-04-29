package com.my.javabasic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BasicKnowledge_DateTime_Date {

    @Test
    public void show_current_time() {
        Date now = new Date();
        System.out.println("当前时间：" + now.toString());
    }
}
