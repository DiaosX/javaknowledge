package com.my.javabasic.annotation.lookup;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Documented
@Retention(RetentionPolicy.RUNTIME)
@ParentAnnotation
public @interface ChildrenAnnotaion {
    String name() default "";
}
