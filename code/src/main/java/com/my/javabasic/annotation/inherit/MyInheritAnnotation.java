package com.my.javabasic.annotation.inherit;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface MyInheritAnnotation {
    String name() default "";
}
