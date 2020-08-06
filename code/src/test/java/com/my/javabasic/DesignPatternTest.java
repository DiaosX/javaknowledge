package com.my.javabasic;

import com.my.javabasic.designpattern.adapter.Adaptee;
import com.my.javabasic.designpattern.adapter.Adapter;
import com.my.javabasic.designpattern.adapter.ITarget;
import com.my.javabasic.designpattern.bridge.homeappliance.*;
import com.my.javabasic.designpattern.bridge.packagebuild.*;
import com.my.javabasic.designpattern.decorate.*;
import com.my.javabasic.designpattern.pipeline.*;
import com.my.javabasic.designpattern.pipeline.handler.OneBusinessHandler;
import com.my.javabasic.designpattern.pipeline.handler.TwoBusinessHandler;
import com.my.javabasic.designpattern.pipeline2.Handler;
import com.my.javabasic.designpattern.pipeline2.MyHandler1;
import com.my.javabasic.designpattern.pipeline2.MyHandler2;
import com.my.javabasic.designpattern.proxy.*;
import com.my.javabasic.designpattern.responsibilitychain.HtmlTextSecurityHandler;
import com.my.javabasic.designpattern.responsibilitychain.ScriptTextSecurityHandler;
import com.my.javabasic.designpattern.responsibilitychain.TextSecurityHandlerChain;
import com.my.javabasic.designpattern.singleton.HungrySingleton;
import com.my.javabasic.designpattern.singleton.LazySingleton;
import com.my.javabasic.designpattern.strategy.*;
import com.my.javabasic.designpattern.visitor.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Proxy;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DesignPatternTest {

    @Test
    public void singleton_get_one_instance() {
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
    public void strategy_test() {

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

    /**
     * 静态代理
     */
    @Test
    public void static_proxy_test() {
        AbstractApprover approver = new ConcreteApprover();
        AbstractApprover approverProxy = new ApproverProxyBasedStatic(approver);
        approverProxy.approve("请假申请");
    }

    /**
     * 测试基于接口的动态代理
     */
    @Test
    public void dynamic_proxy_based_interface_test() {
        ApproverProxyBasedInterface handler = new ApproverProxyBasedInterface();
        AbstractApprover approverProxy = (AbstractApprover) handler.newProxyInstance(new ConcreteApprover());
        //验证是否是代理类
        if (Proxy.isProxyClass(approverProxy.getClass())) {
            System.out.println("此实例为代理类实例.");
        }
        approverProxy.approve("请假申请");
        String approveAdvice = approverProxy.getAdvice();
        System.out.println("审批结果：" + approveAdvice);
    }

    /**
     * 测试基于Cglib的动态代理
     */
    @Test
    public void dynamic_proxy_based_cglib_test() {
        ConcreteApprover approver = new ConcreteApprover();
        ApproverProxyBasedCglib cglibProxy = new ApproverProxyBasedCglib();
        AbstractApprover approverProxy = (AbstractApprover) cglibProxy.newProxyInstance(approver);
        approverProxy.approve("请假申请");
        approverProxy.getAdvice();
    }

    /**
     * 装饰模式测试
     */
    @Test
    public void decorate_test() {
        ICup normalCup = new Cup();
        System.out.println("正常杯子：" + normalCup.getCup().toString());

        //在正常杯子的基础上增加保温功能
        normalCup = new KeepWarmCup(normalCup);
        System.out.println("保温杯子：" + normalCup.getCup().toString());

        //在正常杯子的基础上涂上红色
        normalCup = new RedColorCup(normalCup);
        System.out.println("红色杯子：" + normalCup.getCup().toString());
    }


    /**
     * 状态模式测试
     */
    @Test
    public void state_test() {


    }

    /**
     * 职责链模式
     */
    @Test
    public void responsibility_chain_test() {
        TextSecurityHandlerChain chain = new TextSecurityHandlerChain();
        chain.addSecurityHandler(new HtmlTextSecurityHandler())
                .addSecurityHandler(new ScriptTextSecurityHandler());
        String source = "<div>hello world这个是标题<script></div>";
        String target = chain.applyHandle(source);
        System.out.println("处理后最终字符串为:" + target);
    }

    /**
     * 桥接模式测试
     * 家电品牌实列
     */
    @Test
    public void bridge_test_home_appliance() {
        AbstractBrand haierBrand = new HaierBrand();
        AbstractBrand meidiBrand = new MeiDiBrand();

        Appliance appliance = new WashingAppliance();
        //海尔洗衣机
        haierBrand.setAppliance(appliance);
        haierBrand.run();
        //美的洗衣机
        meidiBrand.setAppliance(appliance);
        meidiBrand.run();

        appliance = new FridgeAppliance();
        //海尔电冰箱
        haierBrand.setAppliance(appliance);
        haierBrand.run();
        //美的电冰箱
        meidiBrand.setAppliance(appliance);
        meidiBrand.run();
    }

    /**
     * 桥接模式之包制作
     */
    @Test
    public void bridge_test_package_build() {
        PackageBuildReq req = new PackageBuildReq();
        PackageBuildExecutor executor = new AndroidPakageBuildExecutor();

        //Android操作系统Tbox包制作
        PackageBuildProvider tboxProvider = new TBoxPackageBuildProvider();
        PackageBuildProvider avnProvider = new AvnPackageBuildProvider();
        executor.setPackageBuildProvider(tboxProvider);
        executor.execute(req);

        //Android操作系统Avn包制作
        executor.setPackageBuildProvider(avnProvider);
        executor.execute(req);

        executor = new LinuxPakageBuildExecutor();
        //Linux系统tbox包制作
        executor.setPackageBuildProvider(tboxProvider);
        executor.execute(req);
        //Linux系统avn包制作
        executor.setPackageBuildProvider(avnProvider);
        executor.execute(req);
    }

    /**
     * 适配器模式测试
     */
    @Test
    public void adapter_test() {
        Adaptee adaptee = new Adaptee();
        ITarget target = new Adapter(adaptee);
        target.print("adapter test");
    }

    /**
     * 适配器模式测试
     */
    @Test
    public void visitor_test() {
        DataContext context = new DataContext();
        IElement oneEle = new ElementOne();
        IElement twoEle = new ElementTwo();
        context.addElement(oneEle);
        context.addElement(twoEle);
        IVisitor one = new OneVisitor();
        context.tryExecute(one);
    }

    @Test
    public void pipeline_test() {
        HandlerContext ctx = new HandlerContext();
        ctx.setIndex(0);
        BusinessHandler<HandlerContext> handlerOne = new OneBusinessHandler();
        BusinessHandler<HandlerContext> handlerTwo = new TwoBusinessHandler();
        DefaultHandlerPipeline<HandlerContext> pipeline = new DefaultHandlerPipeline<>();
        pipeline.addValve(handlerOne);
        pipeline.addValve(handlerTwo);
        pipeline.invoke(ctx);
    }

    @Test
    public void pipeline_2_test() {
        com.my.javabasic.designpattern.pipeline2.HandlerPipeline pipe = new com.my.javabasic.designpattern.pipeline2.HandlerPipeline();
        Handler handler1 = new MyHandler1();
        Handler handler2 = new MyHandler2();
        //pipe.addFirst(handler1);
        // pipe.addFirst(handler2);
        com.my.javabasic.designpattern.pipeline2.DataContext data = new com.my.javabasic.designpattern.pipeline2.DataContext();
        data.setName("john");
        data.setSum(100);
        pipe.invoke(data);
    }
}
