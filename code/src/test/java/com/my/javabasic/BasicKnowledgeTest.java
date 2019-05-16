package com.my.javabasic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BasicKnowledgeTest {
    /**
     * 比较两个Integer类型数字是否相等
     */
    @Test
    public void compareEqualityForInteger() {
        Integer i1 = Integer.valueOf(1000);
        Integer i2 = Integer.valueOf(1000);
        Integer i3 = Integer.valueOf(100);
        Integer i4 = Integer.valueOf(100);
        //对于引用类型==表示地址相同指向同一个堆对象
        //对于Integer类型，Java对-128到127之间的数字做了缓存，
        //所以如果是-128到127之间的整数对象，指向同一个内存对象相当于单例
        System.out.println("i1 == i2:" + (i1 == i2));//false
        //i3和i4同时指向常量池中的100，所以地址相同
        System.out.println("i3 == i4:" + (i3 == i4));//true
    }


    /**
     * 测试Integer类型的不可变性，变量传值为值传递
     */
    @Test
    public void changeValueInOutsideForInteger() {
        Integer i1 = Integer.valueOf(1000);
        System.out.println("1.i1=1000，内存地址为：" + System.identityHashCode(i1));

        i1 = Integer.valueOf(100);
        System.out.println("2.i1=100，内存地址为：" + System.identityHashCode(i1));

        i1 = Integer.valueOf(10);
        System.out.println("3.i1=10，内存地址为：" + System.identityHashCode(i1));

        i1 = Integer.valueOf(100);
        System.out.println("4.i1=100，内存地址为：" + System.identityHashCode(i1));

        i1 = Integer.valueOf(1000);
        System.out.println("5.i1=1000，内存地址为：" + System.identityHashCode(i1));

        System.out.println("before change:" + i1);
        tryChangeOriginValue(i1);
        System.out.println("after change:" + i1);
        //在外部改变前后，i1的值没有改变，充分可以证明Integer类型为不可变类型
    }

    private void tryChangeOriginValue(Integer i1) {
        System.out.println("进入外部方法时i1的内存地址为：" + System.identityHashCode(i1));
        i1 = new Integer(3000);
    }
}
