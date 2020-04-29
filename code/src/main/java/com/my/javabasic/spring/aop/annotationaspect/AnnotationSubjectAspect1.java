package com.my.javabasic.spring.aop.annotationaspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AnnotationSubjectAspect1 {

    /**
     * 切入点之前执行
     *
     * @param joinPoint
     */
    @Before(value = "execution(* com.my.javabasic.spring.aop.annotationaspect..*.*(..))&&@annotation(enableSecurityHandling) && this(proxy)", argNames = "joinPoint,enableSecurityHandling,proxy")
    public void doActionBefore(JoinPoint joinPoint, EnableAnnotationAspect enableSecurityHandling, Object proxy) {
        System.out.println(proxy.getClass().getName());
        System.out.println("[AnnotationSubjectAspect1]Before-执行连接点方法之前执行");
    }

    /**
     * 切入点之后执行
     *
     * @param joinPoint
     */
    @After("execution(* com.my.javabasic.spring.aop.annotationaspect..*.*(..))&&@annotation(enableSecurityHandling)")
    public void doActionAfter(JoinPoint joinPoint, EnableAnnotationAspect enableSecurityHandling) {
        System.out.println("[AnnotationSubjectAspect1]After-执行连接点方法之后执行");

    }

    /**
     * 方法环绕通知: 环绕连接点执行前后通知
     *
     * @param proceedingJoinPoint 连接点
     * @return ret
     */
    @Around("execution(* com.my.javabasic.spring.aop.annotationaspect..*.*(..))&&@annotation(enableSecurityHandling)")
    public Object doActionAroundAdvice(ProceedingJoinPoint proceedingJoinPoint, EnableAnnotationAspect enableSecurityHandling) throws Throwable {
        System.out.println("[AnnotationSubjectAspect1]Around-执行链接点方法之前");
        // proceeding
        Object proceedResult = proceedingJoinPoint.proceed();

        System.out.println("[AnnotationSubjectAspect1]Around-执行链接点方法之后");
        //return
        return proceedResult;
    }

    /**
     * 方法执行后,抛出异常对象通知:连接点执行后，抛出异常对象通知
     *
     * @param joinPoint 连接点
     * @param exception 抛出异常对象记录
     */
    @AfterThrowing(value = "execution(* com.my.javabasic.spring.aop.annotationaspect..*.*(..))&&@annotation(enableSecurityHandling)", throwing = "exception")
    public void doActionAfterThrowingAdvice(JoinPoint joinPoint, EnableAnnotationAspect enableSecurityHandling, Throwable exception) {
        System.out.println("[AnnotationSubjectAspect1]AfterThrowing-扔出异常了.");
    }

    @AfterReturning(value = "execution(* com.my.javabasic.spring.aop.annotationaspect..*.*(..))&&@annotation(enableSecurityHandling)")
    public void doActionAfterReturningAdvice(JoinPoint joinPoint, EnableAnnotationAspect enableSecurityHandling) {
        System.out.println("[AnnotationSubjectAspect1]AfterReturning-返回之前执行.");
    }
}
