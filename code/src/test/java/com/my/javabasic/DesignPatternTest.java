package com.my.javabasic;

import com.my.javabasic.designpattern.singleton.HungrySingleton;
import com.my.javabasic.designpattern.singleton.LazySingleton;
import com.my.javabasic.designpattern.strategy.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DesignPatternTest {

    @Test
    public void getInstanceWithSingleton() {
        LazySingleton instance1 = LazySingleton.getInstance();
        LazySingleton instance2 = LazySingleton.getInstance();
        if (instance1 == instance2) {
            System.out.println("instance1.hashCode=" + instance1.hashCode());
            System.out.println("instance2.hashCode=" + instance2.hashCode());
            System.out.println("两个实例相等，属于同一个实例.");
        }

        HungrySingleton instance3 = HungrySingleton.getInstance();
        HungrySingleton instance4 = HungrySingleton.getInstance();
        if (instance3 == instance4) {
            System.out.println("instance3.hashCode=" + instance3.hashCode());
            System.out.println("instance4.hashCode=" + instance4.hashCode());
            System.out.println("两个实例相等，属于同一个实例.");
        }

    }

    @Test
    public void testStrategy() {

        StrategyContext context = new StrategyContext();

        double totalPrice = 500D;
        double finalPrice = 0D;

        //使用策略1
        AbstractStrategy strategy = new ConcreteStrategy1();
        context.setStrategy(strategy);
        finalPrice = context.getPrice(totalPrice);

        System.out.println("应用策略1后的价格为：" + finalPrice);
        //使用策略2
        strategy = new ConcreteStrategy2();
        context.setStrategy(strategy);
        finalPrice = context.getPrice(totalPrice);
        System.out.println("应用策略2后的价格为：" + finalPrice);
        //使用策略3
        strategy = new ConcreteStrategy3();
        context.setStrategy(strategy);
        finalPrice = context.getPrice(totalPrice);
        System.out.println("应用策略3后的价格为：" + finalPrice);
    }
}
