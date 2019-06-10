package com.my.javabasic.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
/*
*
* 满足 pointcut 规则的 joinpoint 会被添加相应的 advice 操作
*
* 切入点表达式：execution([可见性] 返回类型 [声明类型].方法名(参数) [异常])
*
    *：匹配所有字符
    ..：一般用于匹配多个包，多个参数
    + ：表示类及其子类
*
* Joinpoint-连接点：一般表示为一个方法的执行
* Pointcut-切入点：匹配连接点的断言或表达式。
* Advice-通知:在特定的链接点上执行的动作。
*
* 切入点表达式关键词：
* 1）execution：用于匹配子表达式。
            //匹配com.cjm.model包及其子包中所有类中的所有方法，返回类型任意，方法参数任意
            @Pointcut("execution(* com.cjm.model..*.*(..))")
            public void before(){}

      2）within：用于匹配连接点所在的Java类或者包。
            //匹配Person类中的所有方法
            @Pointcut("within(com.cjm.model.Person)")
            public void before(){}

            //匹配com.cjm包及其子包中所有类中的所有方法
            @Pointcut("within(com.cjm..*)")
            public void before(){}

     3） this：用于向通知方法中传入代理对象的引用。
            @Before("before() && this(proxy)")
            public void beforeAdvide(JoinPoint point, Object proxy){
                  //处理逻辑
            }

      4）target：用于向通知方法中传入目标对象的引用。
            @Before("before() && target(target)
            public void beforeAdvide(JoinPoint point, Object proxy){
                  //处理逻辑
            }

      5）args：用于将参数传入到通知方法中。
            @Before("before() && args(age,username)")
            public void beforeAdvide(JoinPoint point, int age, String username){
                  //处理逻辑
            }

      6）@within ：用于匹配在类一级使用了参数确定的注解的类，其所有方法都将被匹配。
            @Pointcut("@within(com.cjm.annotation.AdviceAnnotation)") － 所有被@AdviceAnnotation标注的类都将匹配
            public void before(){}

      7）@target ：和@within的功能类似，但必须要指定注解接口的保留策略为RUNTIME。
            @Pointcut("@target(com.cjm.annotation.AdviceAnnotation)")
            public void before(){}

      8）@args ：传入连接点的对象对应的Java类必须被@args指定的Annotation注解标注。
            @Before("@args(com.cjm.annotation.AdviceAnnotation)")
            public void beforeAdvide(JoinPoint point){
                  //处理逻辑
            }

      9）@annotation ：匹配连接点被它参数指定的Annotation注解的方法。也就是说，所有被指定注解标注的方法都将匹配。
            @Pointcut("@annotation(com.cjm.annotation.AdviceAnnotation)")
            public void before(){}

      10）bean：通过受管Bean的名字来限定连接点所在的Bean。该关键词是Spring2.5新增的。
            @Pointcut("bean(person)")
            public void before(){}
*
* */


@Configuration
@Aspect
@Order(2)
public class SubjectAspect2 {

    /**
     * 切入点
     */
    @Pointcut("execution(* com.my.javabasic.spring.aop..*.*(..))")
    private void subjectPointcut() {
        System.out.println("[SubjectAspect2]here is Pointcut");

    }

    /**
     * 切入点之前执行
     *
     * @param joinPoint
     */
    @Before("subjectPointcut() && this(proxy)")
    public void doActionBefore(JoinPoint joinPoint, Object proxy) {
        System.out.println(proxy.getClass().getName());
        System.out.println("[SubjectAspect2]Before-执行连接点方法之前执行");
    }

    /**
     * 切入点之后执行
     *
     * @param joinPoint
     */
    @After("subjectPointcut()")
    public void doActionAfter(JoinPoint joinPoint) {
        System.out.println("[SubjectAspect2]After-执行连接点方法之后执行");

    }

    /**
     * 方法环绕通知: 环绕连接点执行前后通知
     *
     * @param proceedingJoinPoint 连接点
     * @return ret
     */
    @Around(value = "subjectPointcut()")
    public Object doActionAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("[SubjectAspect2]Around-执行链接点方法之前");
        // proceeding
        Object proceedResult = proceedingJoinPoint.proceed();

        System.out.println("[SubjectAspect2]Around-执行链接点方法之后");
        //return
        return proceedResult;
    }

    /**
     * 方法执行后,抛出异常对象通知:连接点执行后，抛出异常对象通知
     *
     * @param joinPoint 连接点
     * @param exception 抛出异常对象记录
     */
    @AfterThrowing(value = "subjectPointcut()", throwing = "exception")
    public void doActionAfterThrowingAdvice(JoinPoint joinPoint, Throwable exception) {
        System.out.println("[SubjectAspect2]AfterThrowing-扔出异常了.");
    }

    @AfterReturning(value = "subjectPointcut()")
    public void doActionAfterReturningAdvice(JoinPoint joinPoint) {
        System.out.println("[SubjectAspect2]AfterReturning-返回之前执行.");
    }
}
