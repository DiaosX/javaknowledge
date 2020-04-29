package com.my.javabasic.spring.aop.annotationaspect;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface EnableAnnotationAspect {
}
