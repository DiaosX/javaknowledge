package com.my.javabasic.annotation.lookup;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface ParentAnnotation {

    String value() default "";
}
