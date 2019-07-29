package com.my.javabasic;

import com.my.javabasic.basicknowledge.classforname.ClassForNameTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BasicKnowledge_ClassLoad {

    @Test
    public void loadClassWithForName() {
        ClassForNameTest name = new ClassForNameTest();
        name.loadClassUseForName();
    }

    @Test
    public void loadClassWithLoader() {
        ClassForNameTest name = new ClassForNameTest();
        name.loadClassUseLoader();
    }

    @Test
    public void loadClassOnlyUseLoader() {
        ClassForNameTest name = new ClassForNameTest();
        name.loadClassOnlyUseLoader();
    }
}
